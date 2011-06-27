package angafe.controller.angafe.method;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.model.Product;
import angafe.service.ProducerService;
import angafe.service.ProductService;

import com.google.appengine.api.datastore.Key;

public class EditController extends Controller {

    ProductService service = new ProductService();
    ProducerService producerService = new ProducerService();

    @Override
    public Navigation run() throws Exception {
        List<Producer> allProducers = producerService.getProducers();
        requestScope("allProducers",allProducers);
        
        long id = Long.decode((String)request.getAttribute("id"));
        Key prodKey = Datastore.createKey(Product.class, id);
        Product product = service.getProduct(prodKey);
        requestScope("product",product);
        return forward("edit.jsp");
    }
}
