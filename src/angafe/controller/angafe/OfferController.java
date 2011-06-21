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
        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key offKey = Datastore.createKey(SpecialOffer.class, id);

        SpecialOffer offer = offerService.getOffer(offKey);
        List<Product> products = productService.getProducts(offer);

        //Rendo accessibile la variabile
        requestScope("offer",offer);
        requestScope("products",products);

        //Mostro il jsp
        return forward("offer.jsp");
    }
}
