package angafe.controller.angafe.product;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.Key;

import angafe.model.Photo;
import angafe.model.Product;
import angafe.service.ProductService;

public class LoadController extends Controller {

    ProductService service = new ProductService();
    
    @Override
    public Navigation run() throws Exception {
        String action = (String)request.getParameter("action");
        FileItem fileItem = requestScope("img");
        RequestMap input = new RequestMap(request);
        
        //Se è stata caricata una foto la aggiungo alla Map
        if(fileItem != null) {
            Photo photo = service.upload(fileItem);
            input.put("photo", photo);
        }
        
        //Se è un'azione di modifica recupero la chiave e chiamo il metodo di edit
        if(action.equals("edit")) {
            long id = Long.decode((String)request.getParameter("id"));
            Key prodKey = Datastore.createKey(Product.class, id);
            service.editProduct(prodKey, input);
        }
        
        //Se è un'azione di aggiunta chiamo il metodo di add
        if(action.equals("add")) {
            service.addProduct(input);
        }
        
        return redirect("/angafe/editor");
    }
}
