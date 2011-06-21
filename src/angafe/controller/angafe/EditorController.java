package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import angafe.model.Diet;
import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductionMethod;
import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.model.SpecialOffer;
import angafe.service.DietService;
import angafe.service.ProducerService;
import angafe.service.ProductService;
import angafe.service.ProductionMethodService;
import angafe.service.RecipeService;
import angafe.service.SpecialNeedService;
import angafe.service.SpecialOfferService;

public class EditorController extends Controller {

    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();
    RecipeService recipeService = new RecipeService();
    SpecialOfferService offerService = new SpecialOfferService();
    DietService dietService = new DietService();
    ProductionMethodService productionMethodService = new ProductionMethodService();
    SpecialNeedService specialNeedService = new SpecialNeedService();
    
    @Override
    public Navigation run() throws Exception {
        List<Product> products = productService.getProducts();
        List<Producer> producers = producerService.getProducers();
        List<Recipe> recipes = recipeService.getRecipes();
        List<SpecialOffer> offers = offerService.getSpecialOffers();
        List<Diet> diets = dietService.getDiets();
        List<ProductionMethod> methods = productionMethodService.getProductionMethods();
        List<SpecialNeed> needs = specialNeedService.getSpecialNeeds();
        
        requestScope("allProducts",products);
        requestScope("allProducers",producers);
        requestScope("allRecipes",recipes);
        requestScope("allOffers",offers);
        requestScope("allDiets",diets);
        requestScope("allMethods",methods);
        requestScope("allNeeds",needs);
        
        return forward("editor.jsp");
    }
}
