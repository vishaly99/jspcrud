package entity;

import entity.CategoryMaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-03T11:45:52", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(MobileMaster.class)
public class MobileMaster_ { 

    public static volatile SingularAttribute<MobileMaster, String> memory;
    public static volatile SingularAttribute<MobileMaster, String> size;
    public static volatile SingularAttribute<MobileMaster, Integer> mobileId;
    public static volatile SingularAttribute<MobileMaster, String> year;
    public static volatile SingularAttribute<MobileMaster, String> company;
    public static volatile SingularAttribute<MobileMaster, String> model;
    public static volatile SingularAttribute<MobileMaster, String> camera;
    public static volatile SingularAttribute<MobileMaster, CategoryMaster> categoryId;

}