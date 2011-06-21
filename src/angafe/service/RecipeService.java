package angafe.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import angafe.meta.RecipeMeta;
import angafe.model.Diet;
import angafe.model.Product;
import angafe.model.ProductRecipe;
import angafe.model.Recipe;
import angafe.model.RecipeDiet;
import angafe.model.SpecialNeed;
import angafe.model.SpecialNeedRecipe;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class RecipeService {

    private RecipeMeta r = new RecipeMeta();
    
    ProductRecipeService prService = new ProductRecipeService();
    
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
        List<Recipe> recipes = new ArrayList<Recipe>();
        for(SpecialNeedRecipe nr: need.getSpecialNeedRecipeListRef().getModelList()) {
            recipes.add(nr.getRecipeRef().getModel());
        }
        return recipes;
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

    
    /**
     * Filtra le ricette per Product
     * 
     * @param product
     *      il prodotto
     * @return
     *      una lista di ricette
     */
    public List<Recipe> getRecipes(Product product) {
        List<Recipe> recipes = new ArrayList<Recipe>();

        for(ProductRecipe pr: product.getProductRecipeListRef().getModelList()) {
            recipes.add(pr.getRecipeRef().getModel());
        }

        return recipes;
    }

    public Recipe addRecipe(RequestMap input) {
        //Creo un nuovo modello per la ricetta
        Recipe recipe = new Recipe();
        //Associo i parametri della request
        BeanUtil.copy(input, recipe);
        
        //Ottengo la lista dei prodotti
        @SuppressWarnings("unchecked")
        List<Product> products = (List<Product>) input.get("productsFeatured");
        //Ottengo la lista delle relazioni Ricetta-Prodotto
        List<ProductRecipe> productsRecipes = recipe.getProductRecipeListRef().getModelList();

        //Aggiungo i prodotti alla ricetta
        for (int i = 0; i < products.size(); i++) {
            ProductRecipe pr = new ProductRecipe();
            pr.getProductRef().setModel(products.get(i));
            pr.getRecipeRef().setModel(recipe);
            productsRecipes.add(pr);
            Transaction tx1 = Datastore.beginTransaction();
            Datastore.put(tx1,pr);
            tx1.commit();
        }
        
        //Committo
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,recipe);
        tx.commit();
        return recipe;          
    }
    
    public Recipe editRecipe(Key key, RequestMap input) {
        Recipe recipe = Datastore.get(r, key);
        BeanUtil.copy(input, recipe);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx,recipe);
        tx.commit();
        return recipe;        
    }
    /**
     * Cancella una ricetta e tutte le sue associazioni con i prodotti
     * 
     * @param key
     */
    public void deleteRecipe(Key key) {
        Recipe recipe = this.getRecipe(key);
        List<ProductRecipe> productsRecipes = prService.getProductsRecipes(recipe);
        for(ProductRecipe pr: productsRecipes) {
            prService.deleteProductRecipe(pr.getKey());
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx,key);
        tx.commit();
    }
    
    public Recipe getRecipe(Key key) {
        return Datastore.get(r,key);
    }
}
