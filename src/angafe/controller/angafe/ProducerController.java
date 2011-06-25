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

public class ProducerController extends Controller {

    ProducerService service = new ProducerService();
    ProductionMethodService methodService = new ProductionMethodService();
    
    @Override
    public Navigation run() throws Exception {
        
        String backLinkTitle = "";
        String backLink = "";
        String backLinkVisibility = "hidden";
        
        String index = request.getParameter("index");
        if(index != null && index.equals("true")) {
            backLinkTitle = "back to all producers";
            backLink = "/angafe/producers";
            backLinkVisibility = "visibile";
        }
        
        String groupLinkBackTitle = "";
        String groupLinkBack = "#";
        String groupLinkBackVisibility = "hidden";
        String groupLinkForwardTitle = "";
        String groupLinkForward = "#";
        String groupLinkForwardVisibility = "hidden";

        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key prodKey = Datastore.createKey(Producer.class, id);
        
        //Ottengo il produttore dal datastore tramite la chiave
        Producer producer = service.getProducer(prodKey);
       
        List<ProductionMethod> methods = methodService.getProductionMethods(producer);
        
        String tour = request.getParameter("tour");
        if(tour != null) {
            if(tour.equals("method")) { 
                ProductionMethodService methodService = new ProductionMethodService();
                ProducerService producerService = new ProducerService();
                long methodId = Long.parseLong((String)request.getAttribute("methodId"));
                Key methodKey = Datastore.createKey(ProductionMethod.class, methodId);
                ProductionMethod method = methodService.getProductionMethod(methodKey);
                
                List<Producer> methodProducers = producerService.getProducers(method);

                backLinkTitle = "back to producers using "+method.getName();
                backLink = "/angafe/producers?filter=method&id="+methodId;
                backLinkVisibility = "visibile";
                
                if (methodProducers.indexOf(producer) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    Producer prevProducer = methodProducers.get(methodProducers.indexOf(producer) - 1);
                    groupLinkBack = "/angafe/producer?id="+prevProducer.getKey().getId()+"&tour=method&methodId="+methodId;
                    groupLinkBackTitle = "Previous producer";
                    groupLinkBackVisibility = "visible";

                }

                if (methodProducers.indexOf(producer) != methodProducers.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    Producer nextProducer = methodProducers.get(methodProducers.indexOf(producer) + 1);
                    groupLinkForward = "/angafe/producer?id="+nextProducer.getKey().getId()+"&tour=method&methodId="+methodId;
                    groupLinkForwardTitle = "Next producer";
                    groupLinkForwardVisibility = "visible";
                }
            }
        }
        
        requestScope("methods",methods);
        
        //Rendo accessibile la variabile
        requestScope("producer",producer);        
       
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
        return forward("producer.jsp");
        }
}
