package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.Recipe;
import angafe.model.SpecialOffer;
import angafe.service.ProducerService;
import angafe.service.ProductService;
import angafe.service.RecipeService;
import angafe.service.SpecialOfferService;

public class EditorController extends Controller {

    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();
    RecipeService recipeService = new RecipeService();
    SpecialOfferService offerService = new SpecialOfferService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> products = productService.getProducts();
        List<Producer> producers = producerService.getProducers();
        List<Recipe> recipes = recipeService.getRecipes();
        List<SpecialOffer> offers = offerService.getSpecialOffers();
        
        requestScope("allProducts",products);
        requestScope("allProducers",producers);
        requestScope("allRecipes",recipes);
        requestScope("allOffers",offers);
        
        return forward("editor.jsp");
    }
}
