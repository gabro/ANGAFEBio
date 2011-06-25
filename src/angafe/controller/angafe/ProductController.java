package angafe.controller.angafe;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductionMethod;
import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.model.SpecialOffer;
import angafe.service.ProducerService;
import angafe.service.ProductService;
import angafe.service.RecipeService;
import angafe.service.SpecialNeedService;
import angafe.service.SpecialOfferService;

import com.google.appengine.api.datastore.Key;

public class ProductController extends Controller {

    SpecialNeedService needService = new SpecialNeedService();
    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();

    @Override
    public Navigation run() throws Exception {

        String backLinkTitle = "";
        String backLink = "";
        String backLinkVisibility = "hidden";
        
        String index = request.getParameter("index");
        if(index != null && index.equals("true")) {
            backLinkTitle = "back to all products";
            backLink = "/angafe/products";
            backLinkVisibility = "visibile";
        }
        
        String groupLinkBackTitle = "";
        String groupLinkBack = "#";
        String groupLinkBackVisibility = "hidden";
        String groupLinkForwardTitle = "";
        String groupLinkForward = "#";
        String groupLinkForwardVisibility = "hidden";

        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getParameter("id"));
        //Creo una chiave con quell'id
        Key prodKey = Datastore.createKey(Product.class, id);

        //Ottengo il prodotto dal datastore tramite la chiave
        Product product = productService.getProduct(prodKey);
        //Rendo accessibile la variabile

        List<SpecialNeed> needs = needService.getSpecialNeeds(product);

        String tour = request.getParameter("tour");
        if(tour != null) {
            if(tour.equals("producer")) {                
                Producer producer = product.getProducerRef().getModel();
                List<Product> producerProducts = productService.getProducts(producer);

                backLinkTitle = "back to products by "+producer.getName();
                backLink = "/angafe/products?filter=producer&id="+producer.getKey().getId();
                backLinkVisibility = "visibile";
                
                if (producerProducts.indexOf(product) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    Product prevProduct = producerProducts.get(producerProducts.indexOf(product) - 1);
                    groupLinkBack = "/angafe/product?id="+prevProduct.getKey().getId()+"&tour=producer";
                    groupLinkBackTitle = "Previous product";
                    groupLinkBackVisibility = "visible";

                }

                if (producerProducts.indexOf(product) != producerProducts.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    Product nextProduct = producerProducts.get(producerProducts.indexOf(product) + 1);
                    groupLinkForward = "/angafe/product?id="+nextProduct.getKey().getId()+"&tour=producer";
                    groupLinkForwardTitle = "Next product";
                    groupLinkForwardVisibility = "visible";
                }
            }
            
            if(tour.equals("recipe")) {
                RecipeService recipeService = new RecipeService();
                long recipeId = Long.parseLong((String)request.getParameter("recipeId"));
                Key recipeKey = Datastore.createKey(Recipe.class, recipeId);
                Recipe recipe = recipeService.getRecipe(recipeKey);
                List<Product> recipeProducts = productService.getProducts(recipe);
                backLinkTitle = "back to "+recipe.getName();
                backLink = "/angafe/recipe?id="+recipeId;
                backLinkVisibility = "visibile";
                
                if (recipeProducts.indexOf(product) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    Product prevProduct = recipeProducts.get(recipeProducts.indexOf(product) - 1);
                    groupLinkBack = "/angafe/product?id="+prevProduct.getKey().getId()+"&tour=recipe&recipeId="+recipeId;
                    groupLinkBackTitle = "Previous product";
                    groupLinkBackVisibility = "visible";

                }

                if (recipeProducts.indexOf(product) != recipeProducts.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    Product nextProduct = recipeProducts.get(recipeProducts.indexOf(product) + 1);
                    groupLinkForward = "/angafe/product?id="+nextProduct.getKey().getId()+"&tour=recipe&recipeId="+recipeId;
                    groupLinkForwardTitle = "Next product";
                    groupLinkForwardVisibility = "visible";
                }
            }
            
            if(tour.equals("offer")) {
                SpecialOfferService offerService = new SpecialOfferService();
                long offerId = Long.parseLong((String)request.getParameter("offerId"));
                Key offerKey = Datastore.createKey(SpecialOffer.class, offerId);
                SpecialOffer offer = offerService.getSpecialOffer(offerKey);
                List<Product> offerProducts = productService.getProducts(offer);
                backLinkTitle = "back to "+offer.getName();
                backLink = "/angafe/offer?id="+offerId;
                backLinkVisibility = "visibile";
                
                if (offerProducts.indexOf(product) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    Product prevProduct = offerProducts.get(offerProducts.indexOf(product) - 1);
                    groupLinkBack = "/angafe/product?id="+prevProduct.getKey().getId()+"&tour=offer&offerId="+offerId;
                    groupLinkBackTitle = "Previous product";
                    groupLinkBackVisibility = "visible";

                }

                if (offerProducts.indexOf(product) != offerProducts.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    Product nextProduct = offerProducts.get(offerProducts.indexOf(product) + 1);
                    groupLinkForward = "/angafe/product?id="+nextProduct.getKey().getId()+"&tour=offer&offerId="+offerId;
                    groupLinkForwardTitle = "Next product";
                    groupLinkForwardVisibility = "visible";
                }
            }
            
            if(tour.equals("need")) {
                SpecialNeedService needService = new SpecialNeedService();
                long needId = Long.parseLong((String)request.getParameter("needId"));
                Key needKey = Datastore.createKey(SpecialNeed.class, needId);
                SpecialNeed need = needService.getSpecialNeed(needKey);
                List<Product> needProducts = productService.getProducts(need);
                backLinkTitle = "back to products for "+need.getName();
                backLink = "/angafe/products?filter=need&id="+needId;
                backLinkVisibility = "visibile";
                
                if (needProducts.indexOf(product) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    Product prevProduct = needProducts.get(needProducts.indexOf(product) - 1);
                    groupLinkBack = "/angafe/product?id="+prevProduct.getKey().getId()+"&tour=need&needId="+needId;
                    groupLinkBackTitle = "Previous product";
                    groupLinkBackVisibility = "visible";

                }

                if (needProducts.indexOf(product) != needProducts.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    Product nextProduct = needProducts.get(needProducts.indexOf(product) + 1);
                    groupLinkForward = "/angafe/product?id="+nextProduct.getKey().getId()+"&tour=need&needId="+needId;
                    groupLinkForwardTitle = "Next product";
                    groupLinkForwardVisibility = "visible";
                }
            }
            
            if(tour.equals("method")) {                
                ProductionMethod method = product.getProductionMethodRef().getModel();
                List<Product> methodProducts = productService.getProducts(method);

                backLinkTitle = "back to products made with "+method.getName();
                backLink = "/angafe/products?filter=method&id="+method.getKey().getId();
                backLinkVisibility = "visibile";
                
                if (methodProducts.indexOf(product) != 0) {
                    //Se il prodotto corrente NON è il primo della lista
                    Product prevProduct = methodProducts.get(methodProducts.indexOf(product) - 1);
                    groupLinkBack = "/angafe/product?id="+prevProduct.getKey().getId()+"&tour=method";
                    groupLinkBackTitle = "Previous product";
                    groupLinkBackVisibility = "visible";

                }

                if (methodProducts.indexOf(product) != methodProducts.size() - 1 ) {
                    //Se il prodotto corrente NON è l'ultimo della lista
                    Product nextProduct = methodProducts.get(methodProducts.indexOf(product) + 1);
                    groupLinkForward = "/angafe/product?id="+nextProduct.getKey().getId()+"&tour=method";
                    groupLinkForwardTitle = "Next product";
                    groupLinkForwardVisibility = "visible";
                }
            }
        }
        
        requestScope("backLink",backLink);
        requestScope("backLinkTitle", backLinkTitle);
        requestScope("backLinkVisibility", backLinkVisibility);
        
        requestScope("groupLinkBackVisibility", groupLinkBackVisibility);
        requestScope("groupLinkForwardVisibility", groupLinkForwardVisibility);
        requestScope("groupLinkBack",groupLinkBack);
        requestScope("groupLinkBackTitle",groupLinkBackTitle);
        requestScope("groupLinkForward",groupLinkForward);
        requestScope("groupLinkForwardTitle",groupLinkForwardTitle);
        
        requestScope("needs",needs);
        requestScope("product",product);
        //Mostro il jsp
        return forward("product.jsp");
    }
}
