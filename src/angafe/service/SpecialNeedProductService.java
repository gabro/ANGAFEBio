package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.SpecialNeedProductMeta;
import angafe.model.Product;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedProduct;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class SpecialNeedProductService {

    SpecialNeedProductMeta np = new SpecialNeedProductMeta();
    
    public List<SpecialNeedProduct> getSpecialNeedsProducts(Product product) {
        return Datastore.query(np).filter(np.productRef.equal(product.getKey())).asList();
    }

    public List<SpecialNeedProduct> getSpecialNeedsProducts(SpecialNeed need) {
        return Datastore.query(np).filter(np.specialNeedRef.equal(need.getKey())).asList();
    }
 
    public void deleteSpecialNeedProduct(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx,key);
        tx.commit();        
    }
}
