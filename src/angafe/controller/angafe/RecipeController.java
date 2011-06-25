package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Product;
import angafe.model.Recipe;
import angafe.service.ProductService;
import angafe.service.RecipeService;

import com.google.appengine.api.datastore.Key;

public class RecipeController extends Controller {

    RecipeService recipeService = new RecipeService();
    ProductService productService = new ProductService();
    
    @Override
    public Navigation run() throws Exception {
        
        String backLinkTitle = "back to all recipes";
        String backLink = "/angafe/recipes";
        String backLinkVisibility = "visibile";

        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key recKey = Datastore.createKey(Recipe.class, id);
        
        //Ottengo la ricetta dal datastore tramite la chiave
        Recipe recipe = recipeService.getRecipe(recKey);
        List<Product> products = productService.getProducts(recipe);
        //Rendo accessibile la variabile
        requestScope("recipe",recipe);
        requestScope("products",products);
        
        requestScope("backLink",backLink);
        requestScope("backLinkTitle", backLinkTitle);
        requestScope("backLinkVisibility", backLinkVisibility);

        
        //Mostro il jsp
        return forward("recipe.jsp");
    }
}
