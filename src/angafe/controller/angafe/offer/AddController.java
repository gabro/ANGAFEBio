package angafe.controller.angafe.offer;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Product;
import angafe.service.ProductService;

public class AddController extends Controller {

    ProductService productService = new ProductService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> allProducts = productService.getProducts();
        requestScope("allProducts",allProducts);
        return forward("add.jsp");    }
}
