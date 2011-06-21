package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.SpecialOffer;
import angafe.service.SpecialOfferService;

public class OffersController extends Controller {

    SpecialOfferService service = new SpecialOfferService();
    
    @Override
    public Navigation run() throws Exception {
        List<SpecialOffer> offers = null;
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
 
        //Mostro tutti i produttori
        if (null == filter) {
            offers = service.getSpecialOffers();
            title = "All Special Offers";
        }
        requestScope("offers",offers);
        requestScope("title",title);
        requestScope("visibility",visibility);

        return forward("offers.jsp");
    }
}
