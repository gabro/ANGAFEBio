package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import com.google.appengine.api.datastore.Key;

import angafe.model.Product;

public class ProductController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key prodKey = Datastore.createKey(Product.class, id);
        
        //Ottengo il prodotto dal datastore tramite la chiave
        Product product = Datastore.get(Product.class, prodKey);
        //Rendo accessibile la variabile
        
        requestScope("product",product);
        //Mostro il jsp
        return forward("product.jsp");
    }
}
