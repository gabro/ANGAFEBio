package angafe.controller.angafe.diet;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Product;
import angafe.model.Recipe;
import angafe.service.ProductService;
import angafe.service.RecipeService;

public class AddController extends Controller {

    ProductService productService = new ProductService();
    RecipeService recipeService = new RecipeService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> allProducts = productService.getProducts();
        List<Recipe> allRecipes = recipeService.getRecipes();
        requestScope("allProducts",allProducts);
        requestScope("allRecipes",allRecipes);
        return forward("add.jsp");    }
}
