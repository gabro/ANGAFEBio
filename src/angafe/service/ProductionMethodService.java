package angafe.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import angafe.meta.ProductionMethodMeta;
import angafe.model.Producer;
import angafe.model.Product;
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


    public void deleteMethod(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx,key);
        tx.commit();
    }


    public List<ProductionMethod> getProductionMethods(Producer producer) {
        //Recupero i metodi di produzione di un produttore come i metodi di produzione
        //usati per i prodotti di quel produttore
        ProductService productService = new ProductService();
        List<Product> products = productService.getProducts(producer);
        List<ProductionMethod> methods = new ArrayList<ProductionMethod>();
        for(Product product: products) {
            ProductionMethod method = product.getProductionMethodRef().getModel();
            if (!methods.contains(method)) {
                methods.add(method);
            }
        }
        
        return methods;
    }
}
