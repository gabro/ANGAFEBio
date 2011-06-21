package angafe.controller.angafe.offer;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Producer;
import angafe.service.ProducerService;

import com.google.appengine.api.datastore.Key;

public class EditController extends Controller {

    ProducerService service = new ProducerService();

    @Override
    public Navigation run() throws Exception {
        long id = Long.decode((String)request.getAttribute("id"));
        Key prodKey = Datastore.createKey(Producer.class, id);
        Producer producer = service.getProducer(prodKey);
        requestScope("producer",producer);
        return forward("edit.jsp");
    }
}
