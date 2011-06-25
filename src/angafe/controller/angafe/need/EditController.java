package angafe.controller.angafe.need;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.service.ProducerService;
import angafe.service.ProductService;

public class EditController extends Controller {

    ProductService service = new ProductService();
    ProducerService producerService = new ProducerService();

    @Override
    public Navigation run() throws Exception {
        //TODO Edit Recipe
        return forward("edit.jsp");
    }
}
