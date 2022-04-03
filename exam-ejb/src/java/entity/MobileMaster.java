/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "mobile_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MobileMaster.findAll", query = "SELECT m FROM MobileMaster m"),
    @NamedQuery(name = "MobileMaster.findByMobileId", query = "SELECT m FROM MobileMaster m WHERE m.mobileId = :mobileId"),
    @NamedQuery(name = "MobileMaster.findByCompany", query = "SELECT m FROM MobileMaster m WHERE m.company = :company"),
    @NamedQuery(name = "MobileMaster.findByModel", query = "SELECT m FROM MobileMaster m WHERE m.model = :model"),
    @NamedQuery(name = "MobileMaster.findByYear", query = "SELECT m FROM MobileMaster m WHERE m.year = :year"),
    @NamedQuery(name = "MobileMaster.findBySize", query = "SELECT m FROM MobileMaster m WHERE m.size = :size"),
    @NamedQuery(name = "MobileMaster.findByCamera", query = "SELECT m FROM MobileMaster m WHERE m.camera = :camera"),
    @NamedQuery(name = "MobileMaster.findByMemory", query = "SELECT m FROM MobileMaster m WHERE m.memory = :memory")})
public class MobileMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mobile_id")
    private Integer mobileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "year")
    private String year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "camera")
    private String camera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "memory")
    private String memory;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private CategoryMaster categoryId;

    public MobileMaster() {
    }

    public MobileMaster(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public MobileMaster(Integer mobileId, String company, String model, String year, String size, String camera, String memory) {
        this.mobileId = mobileId;
        this.company = company;
        this.model = model;
        this.year = year;
        this.size = size;
        this.camera = camera;
        this.memory = memory;
    }

    public Integer getMobileId() {
        return mobileId;
    }

    public void setMobileId(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public CategoryMaster getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryMaster categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileId != null ? mobileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MobileMaster)) {
            return false;
        }
        MobileMaster other = (MobileMaster) object;
        if ((this.mobileId == null && other.mobileId != null) || (this.mobileId != null && !this.mobileId.equals(other.mobileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MobileMaster[ mobileId=" + mobileId + " ]";
    }
    
}
