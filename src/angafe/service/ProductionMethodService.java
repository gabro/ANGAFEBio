package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.ProductionMethodMeta;
import angafe.model.ProductionMethod;


public class ProductionMethodService {

    private ProductionMethodMeta p = new ProductionMethodMeta();
    
    public List<ProductionMethod> getProductionMethods() {
        return Datastore.query(p).sort(p.name.asc).asList();
    }
}
