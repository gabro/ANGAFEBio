package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import angafe.meta.ProductSpecialOfferMeta;
import angafe.model.Product;
import angafe.model.ProductSpecialOffer;
import angafe.model.SpecialOffer;


public class ProductSpecialOfferService {

    ProductSpecialOfferMeta po = new ProductSpecialOfferMeta();
    
    public List<ProductSpecialOffer> getProductsSpecialOffers(Product product) {
        return Datastore.query(po).filter(po.productRef.equal(product.getKey())).asList();
    }

    public List<ProductSpecialOffer> getProductsSpecialOffers(SpecialOffer offer) {
        return Datastore.query(po).filter(po.specialOfferRef.equal(offer.getKey())).asList();
    }

    
    public void deleteProductSpecialOffer(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx,key);
        tx.commit();        
    }
}
