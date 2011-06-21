package angafe.controller.angafe.recipe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Recipe;
import angafe.service.RecipeService;

import com.google.appengine.api.datastore.Key;

public class DeleteController extends Controller {

    RecipeService service = new RecipeService();
    
    @Override
    public Navigation run() throws Exception {
        long id = Long.decode((String)request.getAttribute("id"));
        Key recKey = Datastore.createKey(Recipe.class, id);
        service.deleteRecipe(recKey);
        return redirect("/angafe/editor");
    }
}
