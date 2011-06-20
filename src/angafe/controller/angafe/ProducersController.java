package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Producer;
import angafe.service.ProducerService;

public class ProducersController extends Controller {

    ProducerService service = new ProducerService();
    
    @Override
    public Navigation run() throws Exception {
        List<Producer> producers = null;
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
 
        //Mostro tutti i produttori
        if (null == filter) {
            producers = service.getProducers();
            title = "All producers";
        }
        requestScope("producers",producers);
        requestScope("title",title);
        requestScope("visibility",visibility);

        return forward("producers.jsp");
    }
}
