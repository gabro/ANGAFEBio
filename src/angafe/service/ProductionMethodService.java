package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import angafe.meta.ProductProductionMethodMeta;
import angafe.meta.ProductionMethodMeta;
import angafe.model.ProductionMethod;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class ProductionMethodService {

    private ProductionMethodMeta p = new ProductionMethodMeta();
    
    public List<ProductionMethod> getProductionMethods() {
        return Datastore.query(p).sort(p.name.asc).asList();
    }


    public ProductionMethod addMethod(RequestMap input) {
        ProductionMethod method = new ProductionMethod();
        BeanUtil.copy(input, method);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,method);
        tx.commit();
        return method;
    }

    public ProductionMethod getProductionMethod(Key key) {
        return Datastore.get(p, key);
    }
}
