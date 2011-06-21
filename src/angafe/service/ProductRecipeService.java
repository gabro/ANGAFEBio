package angafe.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import angafe.meta.ProductRecipeMeta;
import angafe.model.Product;
import angafe.model.ProductRecipe;
import angafe.model.Recipe;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class ProductRecipeService {
    
    ProductRecipeMeta pr = new ProductRecipeMeta();
    
    public List<ProductRecipe> getProductsRecipes() {
        return Datastore.query(pr).asList();
    }
    
    public List<ProductRecipe> getProductsRecipes(Product product) {
        return Datastore.query(pr).filter(pr.productRef.equal(product.getKey())).asList();
    }
    
    public List<ProductRecipe> getProductsRecipes(Recipe recipe) {
        return Datastore.query(pr).filter(pr.recipeRef.equal(recipe.getKey())).asList();
    }
    
    public void deleteProductRecipe(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx,key);
        tx.commit();
    }
}
