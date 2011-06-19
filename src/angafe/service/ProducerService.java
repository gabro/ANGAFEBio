package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.ProducerMeta;
import angafe.model.Producer;


public class ProducerService {

    private ProducerMeta p = new ProducerMeta();
    
    public List<Producer> getProducers() {
        return Datastore.query(p).sort(p.name.asc).asList();
    }   
}
