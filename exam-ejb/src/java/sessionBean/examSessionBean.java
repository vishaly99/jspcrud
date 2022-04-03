/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;
import entity.CategoryMaster;
import entity.MobileMaster;
import java.util.List;
import javax.ejb.Stateless;
import sessionBean.examSessionBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Dell
 */
@Stateless
public class examSessionBean implements examSessionBeanLocal {
@PersistenceContext(unitName="exam-ejbPU")
 private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<CategoryMaster> showcategory() {
        List<CategoryMaster> categorylist = em.createNamedQuery("CategoryMaster.findAll").getResultList();
        return categorylist;
    }

    @Override
    public String insertcategory(CategoryMaster cat) {
        try{
            em.persist(cat);
            return "record inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    @Override
    public String updatecategory(CategoryMaster cat) {
        try{
            CategoryMaster updatecat = em.find(CategoryMaster.class, cat.getCategoryId());
            updatecat.setCategoryId(cat.getCategoryId());
            updatecat.setCategoryName(cat.getCategoryName());
            em.merge(updatecat);
            return "record updated";
        }
        catch(Exception e){
           return e.getMessage();
        }
    }

    @Override
    public String deletecategory(int categoryID) {
        try
        {
            CategoryMaster deletecat = em.find(CategoryMaster.class, categoryID);
            
            return "record updated";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    @Override
    public CategoryMaster searchcategory(int categoryID) {
        try{
            CategoryMaster cat = em.find(CategoryMaster.class, categoryID);
            return cat;
        }catch(Exception e)
        {
            return null;
        }
     }

    @Override
    public List<MobileMaster> showmobile() {
         List<MobileMaster> mobilelist = em.createNamedQuery("MobileMaster.findAll").getResultList();
        return mobilelist;
    }

    @Override
    public String insertmobile(MobileMaster m) {
        try
        {
            em.persist(m);
            return "record inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    @Override
    public String updatemobile(MobileMaster m) {
        try
        {
            MobileMaster updatemobile = em.find(MobileMaster.class, m.getMobileId());
            updatemobile.setMobileId(m.getMobileId());
            updatemobile.setCamera(m.getCamera());
            updatemobile.setMemory(m.getMemory());
            updatemobile.setModel(m.getModel());
            updatemobile.setSize(m.getSize());
            updatemobile.setYear(m.getYear());
            updatemobile.setCompany(m.getCompany());
            updatemobile.setCategoryId(m.getCategoryId());
            em.merge(updatemobile);
            return "record updated";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String deletemobile(int mobileID) {
         try
        {
            MobileMaster deletemob = em.find(MobileMaster.class, mobileID);
            em.remove(deletemob);
            return "record deleted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
            }

    @Override
    public MobileMaster searchmobile(int mobileID) {
       try{
            MobileMaster mobile = em.find(MobileMaster.class, mobileID);
            return mobile;
        }catch(Exception e)
        {
            return null;
        } 
    }

    /**
     *
     * @param mobileID
     * @return
     */
   
    
}
