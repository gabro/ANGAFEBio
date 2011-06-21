package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.SpecialNeedMeta;
import angafe.model.SpecialNeed;

public class SpecialNeedService {
    
    SpecialNeedMeta n = new SpecialNeedMeta(); 
    
    public List<SpecialNeed> getSpecialNeeds() {
        return Datastore.query(n).sort(n.name.asc).asList();
    }
    
}
