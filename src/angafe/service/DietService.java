package angafe.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.DietMeta;
import angafe.model.Diet;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedDiet;


public class DietService {

    private DietMeta d = new DietMeta();
    
    public List<Diet> getDiets() {
        return Datastore.query(d).sort(d.name.asc).asList();
    }
    
    public List<Diet> getDiets(SpecialNeed need) {
        List<Diet> diets = new ArrayList<Diet>();
        for(SpecialNeedDiet nd: need.getSpecialNeedDietListRef().getModelList()) {
            diets.add(nd.getDietRef().getModel());
        }
        return diets;
    }
}
