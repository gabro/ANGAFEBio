package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.DietMeta;
import angafe.model.Diet;
import angafe.model.SpecialNeed;


public class DietService {

    private DietMeta d = new DietMeta();
    
    public List<Diet> getDiets() {
        return Datastore.query(d).sort(d.name.asc).asList();
    }
    
    public List<Diet> getDiets(SpecialNeed need) {
        //TODO
        return null;
    }
}
