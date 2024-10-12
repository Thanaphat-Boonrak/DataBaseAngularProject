package com.example.Spring_boost_Ecommerce.config;

import com.example.Spring_boost_Ecommerce.Entity.Country;
import com.example.Spring_boost_Ecommerce.Entity.Product;
import com.example.Spring_boost_Ecommerce.Entity.ProductCategory;
import com.example.Spring_boost_Ecommerce.Entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;
    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsuporttedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};



        DisableHttpMethod(Product.class,config,theUnsuporttedActions);
        DisableHttpMethod(ProductCategory.class,config, theUnsuporttedActions);
        DisableHttpMethod(Country.class,config,theUnsuporttedActions);
        DisableHttpMethod(State.class,config, theUnsuporttedActions);

        exposeId(config);
    }

    private static void DisableHttpMethod(Class Theclass,RepositoryRestConfiguration config, HttpMethod[] theUnsuporttedActions) {
        config.getExposureConfiguration()
                .forDomainType(Theclass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsuporttedActions))).
                withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuporttedActions));
    }

    private void exposeId(RepositoryRestConfiguration config){
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();

        for(EntityType tempEntityType : entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        Class[] domaintype = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domaintype);

    }
}

