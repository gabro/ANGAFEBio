package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Product;
import angafe.service.ProductService;

public class ProductController extends Controller {

    ProductService service = new ProductService();
    
    
    @Override
    public Navigation run() throws Exception {
        azzeraDB();
        aggiungiProdotti();
        List<Product> products = service.getProducts();
        requestScope("allProducts",products);
        return forward("productlist.jsp");
    }
    
    private void aggiungiProdotti() {
        Product p1 = new Product();
        p1.setName("Mela");
        p1.getPhotos().add("PHOTO 1");
        
        Product p2 = new Product();
        p2.setName("Pera");
        p2.getPhotos().add("PHOTO 2");
        
        service.addProduct(p1);
        service.addProduct(p2);
    }
    
    private void azzeraDB() {
        service.deleteAllProducts();
    }
}
