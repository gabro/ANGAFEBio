package angafe.model;

import java.io.Serializable;

import angafe.meta.ProductMeta;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.Sort;

@Model(schemaVersion = 1)
public class Producer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    
    private String name;
    private String description;
    private Email email;
    private String phone;
    private String fax;
    private String address;
    //Un produttore ha N prodotti
    @Attribute(persistent = false)
    private InverseModelListRef<Product, Producer> productListRef = 
        new InverseModelListRef<Product, Producer>(Product.class, "producerRef", this,
                //prodotti ordinati per nome in ordine ascendente
                new Sort(ProductMeta.get().name.getName(), SortDirection.ASCENDING));

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

    public final Email getEmail() {
        return email;
    }

    public final void setEmail(Email email) {
        this.email = email;
    }

    public final String getPhone() {
        return phone;
    }

    public final void setPhone(String phone) {
        this.phone = phone;
    }

    public final String getFax() {
        return fax;
    }

    public final void setFax(String fax) {
        this.fax = fax;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
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
        Producer other = (Producer) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public InverseModelListRef<Product, Producer> getProductListRef() {
        return productListRef;
    }
}
