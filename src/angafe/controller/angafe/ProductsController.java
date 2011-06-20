package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Product;
import angafe.service.ProductService;

public class ProductsController extends Controller {

    
    ProductService service = new ProductService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> products = service.getProducts();
        requestScope("allProducts",products);
        return forward("products.jsp");
    }
}