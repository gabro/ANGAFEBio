package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ProducerController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("producerlist.jsp");
    }
}
