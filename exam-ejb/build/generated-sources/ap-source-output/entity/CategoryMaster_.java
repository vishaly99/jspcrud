package entity;

import entity.MobileMaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-03T11:45:52", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(CategoryMaster.class)
public class CategoryMaster_ { 

    public static volatile CollectionAttribute<CategoryMaster, MobileMaster> mobileMasterCollection;
    public static volatile SingularAttribute<CategoryMaster, String> categoryName;
    public static volatile SingularAttribute<CategoryMaster, Integer> categoryId;

}