package angafe.controller.angafe.product;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class MelaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("mela.jsp");
    }
}
