package angafe.controller.angafe.producer;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class BiofruttaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("biofrutta.jsp");
    }
}
