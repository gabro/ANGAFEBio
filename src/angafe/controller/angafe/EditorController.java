package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Producer;
import angafe.model.Product;
import angafe.service.ProducerService;
import angafe.service.ProductService;

public class EditorController extends Controller {

    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> products = productService.getProducts();
        List<Producer> producers = producerService.getProducers();
        requestScope("allProducts",products);
        requestScope("allProducers",producers);
        return forward("editor.jsp");
    }
}
