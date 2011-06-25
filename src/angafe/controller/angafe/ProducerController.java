package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.service.ProducerService;

import com.google.appengine.api.datastore.Key;

public class ProducerController extends Controller {

    ProducerService service = new ProducerService();
    
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
        
        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key prodKey = Datastore.createKey(Producer.class, id);
        
        //Ottengo il produttore dal datastore tramite la chiave
        Producer producer = service.getProducer(prodKey);
        //Rendo accessibile la variabile
        requestScope("producer",producer);

        requestScope("backLink",backLink);
        requestScope("backLinkTitle", backLinkTitle);
        requestScope("backLinkVisibility", backLinkVisibility);

        
        //Mostro il jsp
        return forward("producer.jsp");
        }
}
