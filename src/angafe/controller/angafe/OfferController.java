package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Product;
import angafe.model.SpecialOffer;
import angafe.service.ProductService;
import angafe.service.SpecialOfferService;

import com.google.appengine.api.datastore.Key;

public class OfferController extends Controller {

    SpecialOfferService offerService = new SpecialOfferService();
    ProductService productService = new ProductService();

    @Override
    public Navigation run() throws Exception {
        
        String backLinkTitle = "";
        String backLink = "";
        String backLinkVisibility = "hidden";
        
        String index = request.getParameter("index");
        if(index != null && index.equals("true")) {
            backLinkTitle = "back to all special offers";
            backLink = "/angafe/offers";
            backLinkVisibility = "visibile";
        }
        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key offKey = Datastore.createKey(SpecialOffer.class, id);

        SpecialOffer offer = offerService.getOffer(offKey);
        List<Product> products = productService.getProducts(offer);

        //Rendo accessibile la variabile
        requestScope("offer",offer);
        requestScope("products",products);

        requestScope("backLink",backLink);
        requestScope("backLinkTitle", backLinkTitle);
        requestScope("backLinkVisibility", backLinkVisibility);

        //Mostro il jsp
        return forward("offer.jsp");
    }
}
