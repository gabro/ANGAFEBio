package angafe.controller.angafe.product;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Producer;
import angafe.model.ProductionMethod;
import angafe.service.ProducerService;
import angafe.service.ProductionMethodService;

public class AddController extends Controller {

    ProducerService producerService = new ProducerService();
    ProductionMethodService methodService = new ProductionMethodService();
    
    @Override
    public Navigation run() throws Exception {
        List<Producer> allProducers = producerService.getProducers();
        List<ProductionMethod> allMethods = methodService.getProductionMethods();
        requestScope("allProducers",allProducers);
        requestScope("allMethods",allMethods);
        return forward("add.jsp");
    }
}
