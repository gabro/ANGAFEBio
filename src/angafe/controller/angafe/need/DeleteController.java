package angafe.controller.angafe.need;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.service.RecipeService;
import angafe.service.SpecialNeedService;

import com.google.appengine.api.datastore.Key;

public class DeleteController extends Controller {

    SpecialNeedService service = new SpecialNeedService();
    
    @Override
    public Navigation run() throws Exception {
        long id = Long.decode((String)request.getAttribute("id"));
        Key needKey = Datastore.createKey(SpecialNeed.class, id);
        service.deleteSpecialNeed(needKey);
        return redirect("/angafe/editor");
    }
}
