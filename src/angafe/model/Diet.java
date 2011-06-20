package angafe.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private String name;
    private String genInfo;
    
    //Ogni dieta contiene N ricette
    @Attribute(persistent = false)
    private InverseModelListRef<RecipeDiet, Diet> recipeDietListRef = 
        new InverseModelListRef<RecipeDiet, Diet>(RecipeDiet.class, "dietRef", this);
    
    //Ogni dieta ha N Special Need
    @Attribute(persistent = false)
    private InverseModelListRef<SpecialNeedDiet, Diet> specialNeedDietListRef = 
        new InverseModelListRef<SpecialNeedDiet, Diet>(SpecialNeedDiet.class, "dietRef", this);

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
        Diet other = (Diet) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public void setGenInfo(String genInfo) {
        this.genInfo = genInfo;
    }

    public String getGenInfo() {
        return genInfo;
    }

    public InverseModelListRef<RecipeDiet, Diet> getRecipeDietListRef() {
        return recipeDietListRef;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public InverseModelListRef<SpecialNeedDiet, Diet> getSpecialNeedDietListRef() {
        return specialNeedDietListRef;
    }
    
}
