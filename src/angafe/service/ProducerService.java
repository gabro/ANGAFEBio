package angafe.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import angafe.meta.ProducerMeta;
import angafe.model.Producer;
import angafe.model.Product;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class ProducerService {

    private ProducerMeta p = new ProducerMeta();
    
    public List<Producer> getProducers() {
        return Datastore.query(p).sort(p.name.asc).asList();
    }

    public Producer getProducer(Key key) {
        return Datastore.get(p, key);
    }   
    
    public Producer addProducer(Map<String,Object> input) {
        //Creo un nuovo modello per il prodotto
        Producer producer = new Producer();
        //Associo i parametri della request
        BeanUtil.copy(input, producer);
        //Committo
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(producer);
        tx.commit();
        return producer;        
    }

    public void deleteProducer(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx, key);
        tx.commit();
    }

    public void editProducer(Key prodKey, RequestMap input) {
        Producer producer = Datastore.get(p, prodKey);
        BeanUtil.copy(input, producer);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(producer);
        tx.commit();        
    }
    
}
