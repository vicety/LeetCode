package com.company.springBootPractice.withAnnotation.utils;

import com.company.springBootPractice.withAnnotation.entity.Human;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author vicety
 * @date 2020/4/13 11:18
 */
public class HumanFactory implements FactoryBean<Human> {
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Human getObject() throws Exception {
        Human human = new Human(100, "qwe");
        return human;
    }

    @Override
    public Class<?> getObjectType() {
        return Human.class;
    }
}
