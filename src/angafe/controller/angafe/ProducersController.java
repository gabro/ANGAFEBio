package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.model.ProductionMethod;
import angafe.service.ProducerService;
import angafe.service.ProductionMethodService;

import com.google.appengine.api.datastore.Key;

public class ProducersController extends Controller {

    ProducerService service = new ProducerService();
    
    @Override
    public Navigation run() throws Exception {
        List<Producer> producers = null;
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
        String backText = "Indietro";
        String backLink = "#";
        String tourFilter = "";
        
        //Mostro tutti i produttori
        if (null == filter) {
            producers = service.getProducers();
            title = "All producers";
        } else {
            if (filter.equals("method")) {
                ProductionMethodService methodService = new ProductionMethodService();
                long id = Long.decode((String)request.getAttribute("id"));
                Key key = Datastore.createKey(ProductionMethod.class, id);
                ProductionMethod method = methodService.getProductionMethod(key);
                producers = service.getProducers(method);
                
                title = "Producers using "+method.getName();
                visibility = "visibile";
                backText = "Back to the production method";
                backLink = "/angafe/method?id="+id;
                tourFilter = "&tour=method&methodId="+id;
            }
        }
        
        requestScope("tourFilter",tourFilter);
        requestScope("producers",producers);
        requestScope("backText",backText);
        requestScope("backLink",backLink);
        requestScope("title",title);
        requestScope("visibility",visibility);

        return forward("producers.jsp");
    }
}
