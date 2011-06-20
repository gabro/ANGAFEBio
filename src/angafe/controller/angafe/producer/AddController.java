package angafe.controller.angafe.producer;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Producer;

public class AddController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("add.jsp");    }
}
