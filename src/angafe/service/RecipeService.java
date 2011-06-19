package angafe.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.RecipeMeta;
import angafe.model.Diet;
import angafe.model.Recipe;
import angafe.model.RecipeDiet;
import angafe.model.SpecialNeed;


public class RecipeService {

    private RecipeMeta r = new RecipeMeta();
    
    public List<Recipe> getRecipes() {
        return Datastore.query(r).sort(r.name.asc).asList();
    }
    
    /**
     * Filtra le ricette per SpecialNeed
     * @param need
     *      lo special need
     * @return
     *      una lista di ricette
     */
    public List<Recipe> getRecipes(SpecialNeed need) {
        //TODO getRecipes(SpecialNeed need)
        return null;
    }
    
    /**
     * Filtra le ricette per Diet
     * 
     * @param diet
     *      la dieta
     * @return
     *      una lista di ricette
     */
    public List<Recipe> getRecipes(Diet diet) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        
        for(RecipeDiet rd: diet.getRecipeDietListRef().getModelList()) {
            recipes.add(rd.getRecipeRef().getModel());
        }
        
        return recipes;
    }
    
}
