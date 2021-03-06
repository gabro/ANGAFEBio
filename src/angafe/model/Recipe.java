package angafe.model;

import java.io.Serializable;

import angafe.meta.ProductMeta;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.images.Image;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.Sort;

@Model(schemaVersion = 1)
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String name;
    private String directions;
    @Attribute(lob = true)
    private Image photo;
    
    //Una ricetta ha N prodotti
    @Attribute(persistent=false)
    private InverseModelListRef<ProductRecipe, Recipe> productRecipeListRef = 
        new InverseModelListRef<ProductRecipe, Recipe>(ProductRecipe.class, "recipeRef", this,
                //prodotti ordinati per nome in ordine ascendente
                new Sort(ProductMeta.get().name.getName(), SortDirection.ASCENDING));
    
    //Ogni ricetta appartiene a N diete
    @Attribute(persistent = false)
    private InverseModelListRef<RecipeDiet, Recipe> recipeDietListRef = 
        new InverseModelListRef<RecipeDiet, Recipe>(RecipeDiet.class, "recipeRef", this);

    //Ogni ricetta appartiene a N diete
    @Attribute(persistent = false)
    private InverseModelListRef<SpecialNeedRecipe, Recipe> specialNeedRecipeListRef = 
        new InverseModelListRef<SpecialNeedRecipe, Recipe>(SpecialNeedRecipe.class, "recipeRef", this);
    
    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Recipe other = (Recipe) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public InverseModelListRef<ProductRecipe, Recipe> getProductRecipeListRef() {
        return productRecipeListRef;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getDirections() {
        return directions;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public Image getPhoto() {
        return photo;
    }

    public InverseModelListRef<RecipeDiet, Recipe> getRecipeDietListRef() {
        return recipeDietListRef;
    }

    public InverseModelListRef<SpecialNeedRecipe, Recipe> getSpecialNeedRecipeListRef() {
        return specialNeedRecipeListRef;
    }
}
