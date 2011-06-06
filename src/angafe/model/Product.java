package angafe.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.images.Image;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String name;
    private String description;
    private String healthBenefits;
    @Attribute(lob = true)
    private ArrayList<Image> photos;
    //Un prodotto ha N ricette
    @Attribute(persistent = false)
    private InverseModelListRef<ProductRecipe, Product> productRecipeListRef = 
        new  InverseModelListRef<ProductRecipe, Product>(ProductRecipe.class,  "productRef", this);
    //Un prodotto ha 1 produttore
    private ModelRef<Producer> producerRef = new ModelRef<Producer>(Producer.class);
    //Un prodotto ha N metodi di produzione
    @Attribute(persistent = false)
    private InverseModelListRef<ProductProductionMethod, Product> productProductionMethodListRef =
        new InverseModelListRef<ProductProductionMethod, Product>(ProductProductionMethod.class, "productRef", this);
    
    
    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final String getHealthBenefits() {
        return healthBenefits;
    }

    public final void setHealthBenefits(String healthBenefits) {
        this.healthBenefits = healthBenefits;
    }

    public final ArrayList<Image> getPhotos() {
        return photos;
    }

    public final void setPhotos(ArrayList<Image> photos) {
        this.photos = photos;
    }
    
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
        Product other = (Product) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public InverseModelListRef<ProductRecipe, Product> getProductRecipeListRef() {
        return productRecipeListRef;
    }

    public ModelRef<Producer> getProducerRef() {
        return producerRef;
    }

    public InverseModelListRef<ProductProductionMethod, Product> getProductProductionMethodListRef() {
        return productProductionMethodListRef;
    }
}
