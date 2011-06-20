package angafe.controller.angafe.product;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Producer;
import angafe.service.ProducerService;

public class AddController extends Controller {

    ProducerService producerService = new ProducerService();
    
    @Override
    public Navigation run() throws Exception {
        List<Producer> allProducers = producerService.getProducers();
        requestScope("allProducers",allProducers);
        return forward("add.jsp");
    }
}
