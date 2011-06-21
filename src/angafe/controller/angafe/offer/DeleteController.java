package angafe.controller.angafe.offer;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.SpecialOffer;
import angafe.service.SpecialOfferService;

import com.google.appengine.api.datastore.Key;

public class DeleteController extends Controller {

    SpecialOfferService service = new SpecialOfferService();
    
    @Override
    public Navigation run() throws Exception {
        long id = Long.decode((String)request.getAttribute("id"));
        Key offKey = Datastore.createKey(SpecialOffer.class, id);
        service.deleteSpecialOffer(offKey);
        return redirect("/angafe/editor");
    }
}
