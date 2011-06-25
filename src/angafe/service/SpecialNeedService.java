package angafe.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import angafe.meta.SpecialNeedMeta;
import angafe.meta.SpecialNeedProductMeta;
import angafe.model.Product;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedProduct;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class SpecialNeedService {

    SpecialNeedMeta n = new SpecialNeedMeta(); 

    SpecialNeedProductService npService = new SpecialNeedProductService();
    
    public List<SpecialNeed> getSpecialNeeds() {
        return Datastore.query(n).sort(n.name.asc).asList();
    }

    public SpecialNeed addNeed(RequestMap input) {
        SpecialNeed need = new SpecialNeed();
        //Associo i parametri della request
        BeanUtil.copy(input, need);

        //Ottengo la lista dei prodotti
        @SuppressWarnings("unchecked")
        List<Product> products = (List<Product>) input.get("productsFeatured");

        for (int i = 0; i < products.size(); i++) {
            SpecialNeedProduct pn = new SpecialNeedProduct();
            pn.getProductRef().setModel(products.get(i));
            pn.getSpecialNeedRef().setModel(need);
            Transaction tx1 = Datastore.beginTransaction();
            Datastore.put(tx1,pn);
            tx1.commit();
        }

        //Committo
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,need);
        tx.commit();
        return need; 
    }

    public SpecialNeed editNeed(Key needKey, RequestMap input) {
        // TODO editNeed
        return null;
    }

    public SpecialNeed getSpecialNeed(Key key) {
        return Datastore.get(n,key);
    }

    public List<SpecialNeed> getSpecialNeeds(Product product) {
        SpecialNeedProductMeta np = new SpecialNeedProductMeta();
        List<SpecialNeedProduct> needsProducts = Datastore.query(np).filter(np.productRef.equal(product.getKey())).asList();
        List<SpecialNeed> needs = new ArrayList<SpecialNeed>();
        for(SpecialNeedProduct needProd: needsProducts) {
            needs.add(needProd.getSpecialNeedRef().getModel());
        }
        return needs;
    }

    public void deleteSpecialNeed(Key key) {
        SpecialNeed need = this.getSpecialNeed(key);
        List<SpecialNeedProduct> needsProducts = npService.getSpecialNeedsProducts(need);
        for(SpecialNeedProduct np: needsProducts) {
            npService.deleteSpecialNeedProduct(np.getKey());
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx, key);
        tx.commit();
    }       

}
