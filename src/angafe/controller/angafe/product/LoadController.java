package angafe.controller.angafe.product;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import angafe.model.Photo;
import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductionMethod;
import angafe.service.PhotoService;
import angafe.service.ProducerService;
import angafe.service.ProductService;
import angafe.service.ProductionMethodService;

import com.google.appengine.api.datastore.Key;

public class LoadController extends Controller {

    ProductService productService = new ProductService();
    ProducerService producerService = new ProducerService();
    ProductionMethodService methodService = new ProductionMethodService();
    PhotoService photoService = new PhotoService();
    
    @Override
    public Navigation run() throws Exception {
        //Attraverso il parametro action capisco se è un'azione di edit o di add
        String action = (String)request.getParameter("action");
        //Recupero il file caricato dall'utente
        FileItem fileItem = requestScope("img");
        //Creo una requestMap
        RequestMap input = new RequestMap(request);
       
        //Recupero l'id e la chiave del produttore
        long producerId = Long.decode((String)request.getAttribute("producerId"));
        Key producerKey = Datastore.createKey(Producer.class, producerId);
        //Recupero il produttore
        Producer producer = producerService.getProducer(producerKey);
        //Aggiungo il produttore alla RequestMap
        input.put("producer",producer);
        
        //Recupero l'id e la chiave del metodo
        long methodId = Long.decode((String)request.getAttribute("methodId"));
        Key methodKey = Datastore.createKey(ProductionMethod.class, methodId);
        //Recupero il metodo
        ProductionMethod method = methodService.getProductionMethod(methodKey);
        //Aggiungo il metodo alla RequestMap
        input.put("method",method);
        
        //Se è stata caricata una foto la aggiungo alla RequestMap
        if(fileItem != null) {
            Photo photo = photoService.uploadPhoto(fileItem);
            input.put("photo", photo);
        }
        
        //Se è un'azione di modifica recupero la chiave e chiamo il metodo di edit
        if(action.equals("edit")) {
            long id = Long.decode((String)request.getParameter("id"));
            Key prodKey = Datastore.createKey(Product.class, id);
            productService.editProduct(prodKey, input);
        }
        
        //Se è un'azione di aggiunta chiamo il metodo di add
        if(action.equals("add")) {
            productService.addProduct(input);
        }
        
        return redirect("/angafe/editor");
    }
}
