package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.SpecialOfferMeta;
import angafe.model.SpecialOffer;


public class SpecialOfferService {

    private SpecialOfferMeta s = new SpecialOfferMeta();
    
    public List<SpecialOffer> getSpecialOffers() {
        return Datastore.query(s).sort(s.dataInizio.asc).asList();
    }
    
}
