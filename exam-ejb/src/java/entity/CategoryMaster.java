/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "category_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryMaster.findAll", query = "SELECT c FROM CategoryMaster c"),
    @NamedQuery(name = "CategoryMaster.findByCategoryId", query = "SELECT c FROM CategoryMaster c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "CategoryMaster.findByCategoryName", query = "SELECT c FROM CategoryMaster c WHERE c.categoryName = :categoryName")})
public class CategoryMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<MobileMaster> mobileMasterCollection;

    public CategoryMaster() {
    }

    public CategoryMaster(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryMaster(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public Collection<MobileMaster> getMobileMasterCollection() {
        return mobileMasterCollection;
    }

    public void setMobileMasterCollection(Collection<MobileMaster> mobileMasterCollection) {
        this.mobileMasterCollection = mobileMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryMaster)) {
            return false;
        }
        CategoryMaster other = (CategoryMaster) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CategoryMaster[ categoryId=" + categoryId + " ]";
    }
    
}
