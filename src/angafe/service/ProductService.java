package angafe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import angafe.meta.ProductMeta;
import angafe.meta.ProductSpecialOfferMeta;
import angafe.model.Producer;
import angafe.model.Product;
import angafe.model.ProductRecipe;
import angafe.model.ProductSpecialOffer;
import angafe.model.ProductionMethod;
import angafe.model.Recipe;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedProduct;
import angafe.model.SpecialOffer;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class ProductService {

    private ProductMeta p = new ProductMeta();
    ProductRecipeService prService = new ProductRecipeService();
    ProductSpecialOfferService poService = new ProductSpecialOfferService();
    
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
        List<ProductRecipe> productsRecipes = prService.getProductsRecipes(recipe);
        List<Product> products = new ArrayList<Product>();
        for(ProductRecipe prodRec: productsRecipes) {
            products.add(prodRec.getProductRef().getModel());
        }
        return products;
    }
    
    //Ritorna una lista dei prodotti di un metodo di produzione
    public List<Product> getProducts(ProductionMethod productionMethod) {
        return Datastore.query(p).filter(p.productionMethodRef.equal(productionMethod.getKey())).asList();
    }
    
    //Ritorna una lista dei prodotti di un'offerta
    public List<Product> getProducts(SpecialOffer offer) {
        ProductSpecialOfferMeta po = new ProductSpecialOfferMeta();
        List<ProductSpecialOffer> productsOffers = Datastore.query(po).filter(po.specialOfferRef.equal(offer.getKey())).asList();
        List<Product> products = new ArrayList<Product>();
        for(ProductSpecialOffer prodOff: productsOffers) {
            products.add(prodOff.getProductRef().getModel());
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
        Datastore.put(tx,product);
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
        //Creo un nuovo modello per il prodotto
        Product product = new Product();
        //Associo i parametri della request
        BeanUtil.copy(input, product);
        //Imposto il produttore
        product.getProducerRef().setModel((Producer)input.get("producer"));
        //Committo
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,product);
        tx.commit();
        return product;        
    }

    /**
     * Cancella un prodotto e tutte le sue relazioni con le ricette
     * 
     * @param key
     */
    public void deleteProduct(Key key) {
        Product product = this.getProduct(key);
        List<ProductRecipe> productsRecipes = prService.getProductsRecipes(product);
        for(ProductRecipe pr: productsRecipes) {
            prService.deleteProductRecipe(pr.getKey());
        }
        List<ProductSpecialOffer> productsOffers = poService.getProductsSpecialOffers(product);
        for(ProductSpecialOffer po: productsOffers) {
            poService.deleteProductSpecialOffer(po.getKey());
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx, key);
        tx.commit();
    }
    /**
     * Ottiene un prodotto
     * 
     * @param key
     *      la chiave del prodotto
     * @return
     *      il prodotto
     */
    public Product getProduct(Key key) {
        return Datastore.get(p, key);
    }

    public Product editProduct(Key prodKey,Map<String,Object> input) {
        Product product = Datastore.get(p, prodKey);
        BeanUtil.copy(input, product);
        //Imposto il produttore
        product.getProducerRef().setModel((Producer)input.get("producer"));
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,product);
        tx.commit();
        return product;
    }

}
