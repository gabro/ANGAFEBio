package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Product;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        Product product = new Product();
        product.setName("prod1");
        product.setDescription("prod1descr");
        Datastore.put(product);
        return forward("index.jsp");
    }
}
