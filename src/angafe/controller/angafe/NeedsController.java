package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.SpecialNeed;
import angafe.service.SpecialNeedService;

public class NeedsController extends Controller {

    SpecialNeedService service = new SpecialNeedService();
    
    @Override
    public Navigation run() throws Exception {
        List<SpecialNeed> needs = service.getSpecialNeeds();
        String title = "All special needs";
        String visibility = "hidden";
 
        requestScope("needs",needs);
        requestScope("title",title);
        requestScope("visibility",visibility);

        return forward("needs.jsp");
     }
}
