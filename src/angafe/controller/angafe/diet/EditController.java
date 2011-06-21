package angafe.controller.angafe.diet;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.service.ProducerService;

public class EditController extends Controller {

    ProducerService service = new ProducerService();

    @Override
    public Navigation run() throws Exception {
        //TODO Edit offerta
        return forward("edit.jsp");
    }
}
