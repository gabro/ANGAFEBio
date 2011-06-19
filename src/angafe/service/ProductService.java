package angafe.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import angafe.meta.ProductMeta;
import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductRecipe;
import angafe.model.ProductSpecialOffer;
import angafe.model.ProductionMethod;
import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedProduct;
import angafe.model.SpecialOffer;


public class ProductService {

    private ProductMeta p = new ProductMeta();
    
    //Ritorna una lista di tutti i prodotti
    public List<Product> getProducts() {
        return Datastore.query(p).sort(p.name.asc).asList();
    }
    
    //Ritorna una lista dei prodotti di un produttore
    public List<Product> getProducts(Producer producer) {
        return Datastore.query(p).filter(p.producerRef.equal(producer.getKey())).asList();
    }
    
    //Ritorna una lista dei prodotti di un produttore
    public List<Product> getProducts(Recipe recipe) {
       
        List<Product> products = new ArrayList<Product>();
        
        for(ProductRecipe pr: recipe.getProductRecipeListRef().getModelList()) {
            products.add(pr.getProductRef().getModel());
        }
        
        return products;
    }
    
    //Ritorna una lista dei prodotti di un metodo di produzione
    public List<Product> getProducts(ProductionMethod productionMethod) {
        return Datastore.query(p).filter(p.productionMethodRef.equal(productionMethod.getKey())).asList();
    }
    
    //Ritorna una lista dei prodotti di un'offerta
    public List<Product> getProducts(SpecialOffer offer) {
       
        List<Product> products = new ArrayList<Product>();
        
        for(ProductSpecialOffer po: offer.getProductSpecialOfferListRef().getModelList()) {
            products.add(po.getProductRef().getModel());
        }
        
        return products;
    }   
    
    //Ritorna una lista dei prodotti di uno special need
    public List<Product> getProducts(SpecialNeed need) {
        List<Product> products = new ArrayList<Product>();

        for(SpecialNeedProduct np: need.getSpecialNeedProductListRef().getModelList()) {
            products.add(np.getProductRef().getModel());
        }

        return products;
    }

    public void addProduct(Product product) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(product);
        tx.commit();
    }
    
    public void deleteAllProducts() {
        List<Key> keys = new ArrayList<Key>();
        for(Product product: this.getProducts()) {
            keys.add(product.getKey());
        }
        Datastore.delete(keys);
    }
        
}
