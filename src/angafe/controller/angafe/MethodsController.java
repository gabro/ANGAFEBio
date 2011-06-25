package angafe.controller.angafe;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.ProductionMethod;
import angafe.service.ProductionMethodService;

public class MethodsController extends Controller {

    ProductionMethodService methodService = new ProductionMethodService();
    
    @Override
    public Navigation run() throws Exception {
        List<ProductionMethod> methods = new ArrayList<ProductionMethod>();
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
        String backText = "Indietro";
        
        //Mostra tutti i prodotti
        if(null == filter) {
            methods = methodService.getProductionMethods();
            title = "All production methods";
        } else {
            //TODO filtro methods
//            
//            if(filter.equals("producer")) {
//                long id = Long.decode((String)request.getAttribute("id"));
//                Key key = Datastore.createKey(Producer.class, id);
//                Producer producer = producerService.getProducer(key);
//                products = productService.getProducts(producer);
//                title = "Products by "+producer.getName();
//                requestScope("producer",producer);
//                visibility = "visibile";
//                backText = "Torna al produttore";
//            }
        }
        
        requestScope("methods",methods);
        requestScope("title",title);
        requestScope("visibility",visibility);
        requestScope("backText",backText);
        return forward("methods.jsp");    }
}
