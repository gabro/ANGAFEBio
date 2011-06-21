package angafe.controller.angafe.recipe;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import angafe.model.Photo;
import angafe.model.Product;
import angafe.model.Recipe;
import angafe.service.PhotoService;
import angafe.service.ProductService;
import angafe.service.RecipeService;

import com.google.appengine.api.datastore.Key;

public class LoadController extends Controller {

    ProductService productService = new ProductService();
    RecipeService recipeService = new RecipeService();
    PhotoService photoService = new PhotoService();
    
    @Override
    public Navigation run() throws Exception {

        //Attraverso il parametro action capisco se è un'azione di edit o di add
        String action = (String)request.getParameter("action");
        
        //Recupero il file caricato dall'utente
        FileItem fileItem = requestScope("img");
       
        //Creo una requestMap
        RequestMap input = new RequestMap(request);
           
        //Recupero la lista dei prodotti inclusi nella ricetta
        String[] productsId = request.getParameterValues("product");
        System.out.println(productsId);
        List<Product> productsFeatured = new ArrayList<Product>();
        for(String id: productsId) {
            long idProd = Long.decode(id);
            Key prodKey = Datastore.createKey(Product.class, idProd);
            productsFeatured.add(productService.getProduct(prodKey));
        }
        input.put("productsFeatured", productsFeatured);
        
        //Se è stata caricata una foto la aggiungo alla RequestMap
        if(fileItem != null) {
            Photo photo = photoService.uploadPhoto(fileItem);
            input.put("photo", photo);
        }
        
        //Se è un'azione di modifica recupero la chiave e chiamo il metodo di edit
        if(action.equals("edit")) {
            long id = Long.decode((String)request.getParameter("id"));
            Key recKey = Datastore.createKey(Recipe.class, id);
            recipeService.editRecipe(recKey, input);
        }
        
        //Se è un'azione di aggiunta chiamo il metodo di add
        if(action.equals("add")) {
            recipeService.addRecipe(input);
        }
        
        return redirect("/angafe/editor");
    }
}
