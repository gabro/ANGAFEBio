package angafe.controller.angafe.producer;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import angafe.model.Photo;
import angafe.model.Producer;
import angafe.service.PhotoService;
import angafe.service.ProducerService;

import com.google.appengine.api.datastore.Key;

public class LoadController extends Controller {

    ProducerService producerService = new ProducerService();
    PhotoService photoService = new PhotoService();
    
    @Override
    public Navigation run() throws Exception {
        //Attraverso il parametro action capisco se è un'azione di edit o di add
        String action = (String)request.getParameter("action");
        //Recupero il file caricato dall'utente
        FileItem fileItem = requestScope("img");
        //Creo una requestMap
        RequestMap input = new RequestMap(request);
        
        //Se è stata caricata una foto la aggiungo alla RequestMap
        if(fileItem != null) {
            Photo photo = photoService.uploadPhoto(fileItem);
            input.put("photo", photo);
        }
        
        //Se è un'azione di modifica recupero la chiave e chiamo il metodo di edit
        if(action.equals("edit")) {
            long id = Long.decode((String)request.getParameter("id"));
            Key prodKey = Datastore.createKey(Producer.class, id);
            producerService.editProducer(prodKey, input);
        }
        
        //Se è un'azione di aggiunta chiamo il metodo di add
        if(action.equals("add")) {
            producerService.addProducer(input);
        }
        
        return redirect("/angafe/editor");
    }
}
