package angafe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import angafe.meta.PhotoMeta;
import angafe.meta.ProductMeta;
import angafe.model.Photo;
import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductRecipe;
import angafe.model.ProductSpecialOffer;
import angafe.model.ProductionMethod;
import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedProduct;
import angafe.model.SpecialOffer;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class ProductService {

    private ProductMeta p = new ProductMeta();
    private PhotoMeta ph = new PhotoMeta();
    
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

    public Product addProduct(Map<String,Object> input) {
        Product product = new Product();
        BeanUtil.copy(input, product);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(product);
        tx.commit();
        return product;        
    }

    public Photo upload(FileItem file) {
        if (file == null) {
            return null;
        }
        
        Photo photo = new Photo();
        photo.setKey(Datastore.allocateId(ph));
        photo.setFileName(file.getShortFileName());
        photo.setLength(file.getData().length);
        byte[] bytes = file.getData();
        photo.setBytes(bytes);
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx, photo);
        tx.commit();
        return photo;
    }
    
    public Photo getPhoto(Key key) {
        return Datastore.get(ph, key);
    }
    
    
    public void deleteProduct(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx, key);
        tx.commit();
    }

    public Product getProduct(Key key) {
        return Datastore.get(p, key);
    }

    public void editProduct(Key prodKey,Map<String,Object> input) {
        Product product = Datastore.get(p, prodKey);
        BeanUtil.copy(input, product);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(product);
        tx.commit();
    }

}
