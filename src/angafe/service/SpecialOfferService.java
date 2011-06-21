package angafe.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import angafe.meta.SpecialOfferMeta;
import angafe.model.Product;
import angafe.model.ProductSpecialOffer;
import angafe.model.SpecialOffer;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class SpecialOfferService {

    private SpecialOfferMeta s = new SpecialOfferMeta();
    ProductSpecialOfferService poService = new ProductSpecialOfferService();
    
    public List<SpecialOffer> getSpecialOffers() {
        return Datastore.query(s).sort(s.dataInizio.asc).asList();
    }
    
    public SpecialOffer addSpecialOffer(Map<String,Object> input) {
        
        SpecialOffer offer = new SpecialOffer();
        BeanUtil.copy(input, offer);
        
        //Ottengo la lista dei prodotti
        @SuppressWarnings("unchecked")
        List<Product> products = (List<Product>) input.get("productsFeatured");
        //Ottengo la lista delle relazioni Offerta-Prodotto
        List<ProductSpecialOffer> productsOffers = offer.getProductSpecialOfferListRef().getModelList();

        //Aggiungo i prodotti alla ricetta
        for (int i = 0; i < products.size(); i++) {
            ProductSpecialOffer po = new ProductSpecialOffer();
            po.getProductRef().setModel(products.get(i));
            po.getSpecialOfferRef().setModel(offer);
            productsOffers.add(po);
            Transaction tx1 = Datastore.beginTransaction();
            Datastore.put(tx1,po);
            tx1.commit();
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,offer);
        tx.commit();
        return offer;        
    }

    public SpecialOffer getOffer(Key key) {
        return Datastore.get(s,key);
    }

    public void deleteSpecialOffer(Key key) {
        SpecialOffer offer = this.getOffer(key);
        List<ProductSpecialOffer> productsOffers = poService.getProductsSpecialOffers(offer);
        for(ProductSpecialOffer po: productsOffers) {
            poService.deleteProductSpecialOffer(po.getKey());
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx,key);
        tx.commit();
    }
}
