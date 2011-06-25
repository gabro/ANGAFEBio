package angafe.controller.angafe;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Product;
import angafe.model.Recipe;
import angafe.service.ProductService;
import angafe.service.RecipeService;

import com.google.appengine.api.datastore.Key;

public class RecipesController extends Controller {

    RecipeService recipeService = new RecipeService();
    ProductService productService = new ProductService();
    
    @Override
    public Navigation run() throws Exception {
        List<Recipe> recipes = new ArrayList<Recipe>();
        String filter = request.getParameter("filter");
        String title = "";
        String visibility = "hidden";
        String backText = "Indietro";
        String tourFilter = "";

        //Mostra tutti i prodotti
        if(null == filter) {
            recipes = recipeService.getRecipes();
            title = "All recipes";
        } else {

            //Mostra i prodotti di un determinato prodotto
            if(filter.equals("product")) {
                long id = Long.decode((String)request.getAttribute("id"));
                Key key = Datastore.createKey(Product.class, id);
                Product product = productService.getProduct(key);
                recipes = recipeService.getRecipes(product);
                title = "Recipes featuring "+product.getName();
                requestScope("product",product);
                visibility = "visibile";
                backText = "torna a "+product.getName();
                tourFilter = "&tour=product&productId="+id;
            }
        }
        
        requestScope("tourFilter",tourFilter);
        requestScope("recipes",recipes);
        requestScope("title",title);
        requestScope("visibility",visibility);
        requestScope("backText",backText);
        
        return forward("recipes.jsp");
    }
}
