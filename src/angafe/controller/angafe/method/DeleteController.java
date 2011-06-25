package angafe.controller.angafe.method;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.ProductionMethod;
import angafe.service.ProductionMethodService;

import com.google.appengine.api.datastore.Key;

public class DeleteController extends Controller {

    ProductionMethodService service = new ProductionMethodService();
    
    @Override
    public Navigation run() throws Exception {
        long id = Long.decode((String)request.getAttribute("id"));
        Key methKey = Datastore.createKey(ProductionMethod.class, id);
        service.deleteMethod(methKey);
        return redirect("/angafe/editor");
    }
}
