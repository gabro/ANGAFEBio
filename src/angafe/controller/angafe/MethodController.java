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

public class MethodController extends Controller {

    ProductionMethodService service = new ProductionMethodService();
    
    @Override
    public Navigation run() throws Exception {
        
        String backLinkTitle = "";
        String backLink = "";
        String backLinkVisibility = "hidden";
        
        String groupLinkBackTitle = "";
        String groupLinkBack = "#";
        String groupLinkBackVisibility = "hidden";
        String groupLinkForwardTitle = "";
        String groupLinkForward = "#";
        String groupLinkForwardVisibility = "hidden";
        
        String index = request.getParameter("index");
        if(index != null && index.equals("true")) {
            backLinkTitle = "back to all production methods";
            backLink = "/angafe/methods";
            backLinkVisibility = "visibile";
        }
        
        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key methKey = Datastore.createKey(ProductionMethod.class, id);

        ProductionMethod method = service.getProductionMethod(methKey);
                
        ProductionMethodService methodSevice = new ProductionMethodService();
        String tour = request.getParameter("tour");
        if(tour != null) {
            if(tour.equals("producer")) {
                ProducerService producerService = new ProducerService();
                long producerId = Long.parseLong((String)request.getAttribute("producerId"));
                Key producerKey = Datastore.createKey(Producer.class, producerId);
                Producer producer = producerService.getProducer(producerKey);
                List<ProductionMethod> producerMethods = methodSevice.getProductionMethods(producer);

                backLinkTitle = "back to "+producer.getName();
                backLink = "/angafe/producer?id="+producer.getKey().getId();
                backLinkVisibility = "visibile";
                
                if (producerMethods.indexOf(method) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    ProductionMethod prevMethod = producerMethods.get(producerMethods.indexOf(method) - 1);
                    groupLinkBack = "/angafe/method?id="+prevMethod.getKey().getId()+"&tour=producer&producerId="+producerId;
                    groupLinkBackTitle = "Previous method";
                    groupLinkBackVisibility = "visible";

                }
                
                if (producerMethods.indexOf(method) != producerMethods.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    ProductionMethod nextMethod = producerMethods.get(producerMethods.indexOf(method) + 1);
                    groupLinkForward = "/angafe/method?id="+nextMethod.getKey().getId()+"&tour=producer&producerId="+producerId;
                    groupLinkForwardTitle = "Next method";
                    groupLinkForwardVisibility = "visible";
                }
            }
        }
        
        //Rendo accessibile la variabile
        requestScope("method",method);
      
        requestScope("groupLinkBackVisibility", groupLinkBackVisibility);
        requestScope("groupLinkForwardVisibility", groupLinkForwardVisibility);
        requestScope("groupLinkBack",groupLinkBack);
        requestScope("groupLinkBackTitle",groupLinkBackTitle);
        requestScope("groupLinkForward",groupLinkForward);
        requestScope("groupLinkForwardTitle",groupLinkForwardTitle);

        requestScope("backLink",backLink);
        requestScope("backLinkTitle", backLinkTitle);
        requestScope("backLinkVisibility", backLinkVisibility);
        
        //Mostro il jsp
        return forward("method.jsp");
        }
}
