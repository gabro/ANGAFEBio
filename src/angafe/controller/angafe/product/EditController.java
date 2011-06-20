package angafe.controller.angafe.product;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Product;
import angafe.service.ProductService;

import com.google.appengine.api.datastore.Key;

public class EditController extends Controller {

    ProductService service = new ProductService();

    @Override
    public Navigation run() throws Exception {
        long id = Long.decode((String)request.getAttribute("id"));
        Key prodKey = Datastore.createKey(Product.class, id);
        Product product = service.getProduct(prodKey);
        requestScope("product",product);
        return forward("edit.jsp");
    }
}
