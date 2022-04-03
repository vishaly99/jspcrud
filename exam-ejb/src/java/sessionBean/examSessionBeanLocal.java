/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;
import entity.CategoryMaster;
import entity.MobileMaster;
import javax.ejb.Local;
import java.util.List;
/**
 *
 * @author Dell
 */
@Local
public interface examSessionBeanLocal {
    
    //categorytb
    public List<CategoryMaster> showcategory();
    public String insertcategory(CategoryMaster cat);
    public String updatecategory(CategoryMaster cat);
    public String deletecategory(int categoryID);
    public CategoryMaster searchcategory(int categoryID);
    
    //Mobilemaster
    public List<MobileMaster> showmobile();
    public String insertmobile(MobileMaster m);
    public String updatemobile(MobileMaster m);
    public String deletemobile(int mobileID);
    public MobileMaster searchmobile(int mobileID);
    
    
    
}
