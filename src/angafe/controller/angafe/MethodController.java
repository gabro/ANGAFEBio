package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.ProductionMethod;
import angafe.service.ProductionMethodService;

import com.google.appengine.api.datastore.Key;

public class MethodController extends Controller {

    ProductionMethodService service = new ProductionMethodService();
    
    @Override
    public Navigation run() throws Exception {
        
        String backLinkTitle = "";
        String backLink = "";
        String backLinkVisibility = "hidden";
        
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
        //Rendo accessibile la variabile
        requestScope("method",method);

        requestScope("backLink",backLink);
        requestScope("backLinkTitle", backLinkTitle);
        requestScope("backLinkVisibility", backLinkVisibility);
        
        //Mostro il jsp
        return forward("method.jsp");
        }
}
