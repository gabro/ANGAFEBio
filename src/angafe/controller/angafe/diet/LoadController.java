package angafe.controller.angafe.diet;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import angafe.model.Product;
import angafe.service.ProductService;
import angafe.service.SpecialOfferService;

import com.google.appengine.api.datastore.Key;

public class LoadController extends Controller {

    SpecialOfferService specialOfferService = new SpecialOfferService();
    ProductService productService = new ProductService();
    
    @Override
    public Navigation run() throws Exception {
        //Attraverso il parametro action capisco se è un'azione di edit o di add
        String action = (String)request.getParameter("action");
        //Creo una requestMap
        RequestMap input = new RequestMap(request);
        
        //Recupero la lista dei prodotti inclusi nella ricetta
        String[] productsId = request.getParameterValues("product");
        System.out.println(productsId);
        List<Product> productsFeatured = new ArrayList<Product>();
        for(String id: productsId) {
            long idProd = Long.decode(id);
            Key prodKey = Datastore.createKey(Product.class, idProd);
            productsFeatured.add(productService.getProduct(prodKey));
        }
        input.put("productsFeatured", productsFeatured);
        
        //Se è un'azione di modifica recupero la chiave e chiamo il metodo di edit
        if(action.equals("edit")) {
            //TODO
//            long id = Long.decode((String)request.getParameter("id"));
//            Key prodKey = Datastore.createKey(Producer.class, id);
//            producerService.editProducer(prodKey, input);
        }
        
        //Se è un'azione di aggiunta chiamo il metodo di add
        if(action.equals("add")) {
            specialOfferService.addSpecialOffer(input);
        }
        
        return redirect("/angafe/editor");
    }
}
