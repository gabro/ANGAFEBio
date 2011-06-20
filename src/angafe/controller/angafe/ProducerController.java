package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.model.Product;

import com.google.appengine.api.datastore.Key;

public class ProducerController extends Controller {

    @Override
    public Navigation run() throws Exception {
        //Recupero l'id dalla request e lo trasformo in long
        long id = Long.parseLong((String)request.getAttribute("id"));
        //Creo una chiave con quell'id
        Key prodKey = Datastore.createKey(Producer.class, id);
        //Ottengo il prodotto dal datastore tramite la chiave
        Producer producer = Datastore.get(Producer.class, prodKey);
        //Rendo accessibile la variabile
        requestScope("producer",producer);

        //Mostro il jsp
        return forward("producer.jsp");
        }
}
