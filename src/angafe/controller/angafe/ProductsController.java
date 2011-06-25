package angafe.controller.angafe;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductionMethod;
import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.service.ProducerService;
import angafe.service.ProductService;
import angafe.service.ProductionMethodService;
import angafe.service.RecipeService;
import angafe.service.SpecialNeedService;

import com.google.appengine.api.datastore.Key;

public class ProductsController extends Controller {

    
    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();
    ProductionMethodService methodService = new ProductionMethodService();
    SpecialNeedService needService = new SpecialNeedService();
    RecipeService recipeService = new RecipeService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> products = new ArrayList<Product>();
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
        String backText = "Indietro";
        String backLink = "#";
        String tourFilter = "";
        
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
                visibility = "visibile";
                backText = "Back to "+producer.getName();
                backLink = "/angafe/producer?id="+id;
                tourFilter = "&tour=producer";
            }
            
            //Mostra i prodotti che usano un determinato metodo
            if(filter.equals("method")) {
                long id = Long.decode((String)request.getAttribute("id"));
                Key key = Datastore.createKey(ProductionMethod.class, id);
                ProductionMethod method = methodService.getProductionMethod(key);
                products = productService.getProducts(method);
                title = "Products using "+method.getName();
                visibility = "visibile";
                backText = "Back to the production method";
                backLink = "/angafe/method?id="+method.getKey().getId();
            }
            
            if(filter.equals("need")) {
                long id = Long.decode((String)request.getAttribute("id"));
                Key key = Datastore.createKey(SpecialNeed.class, id);
                SpecialNeed need = needService.getSpecialNeed(key);
                products = productService.getProducts(need);
                title = "Product for special need "+need.getName();
                visibility = "visible";
                backText = "Back to special needs";
                backLink = "/angafe/needs";
            }
        }
        
        requestScope("tourFilter",tourFilter);
        requestScope("products",products);
        requestScope("title",title);
        requestScope("visibility",visibility);
        requestScope("backText",backText);
        requestScope("backLink",backLink);
        
        return forward("products.jsp");
    }
}