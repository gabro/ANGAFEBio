package angafe.controller.angafe;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.model.Product;
import angafe.service.ProducerService;
import angafe.service.ProductService;

import com.google.appengine.api.datastore.Key;

public class ProductsController extends Controller {

    
    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> products = new ArrayList();
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
        String backText = "Indietro";
        
        //Mostra tutti i prodotti
        if(null == filter) {
            products = productService.getProducts();
            title = "All products";
        } else {

            //Mostra i prodotti di un determinato produttore
            if(filter.equals("producer")) {
                long id = Long.decode((String)request.getAttribute("id"));
                Key key = Datastore.createKey(Producer.class, id);
                Producer producer = producerService.getProducer(key);
                products = productService.getProducts(producer);
                title = "Products by "+producer.getName();
                requestScope("producer",producer);
                visibility = "visibile";
                backText = "Torna al produttore";
            }
        }
        requestScope("products",products);
        requestScope("title",title);
        requestScope("visibility",visibility);
        requestScope("backText",backText);
        return forward("products.jsp");
    }
}