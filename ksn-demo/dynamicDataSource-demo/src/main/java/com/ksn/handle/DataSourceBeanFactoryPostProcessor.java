package com.ksn.handle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/23 10:20
 */

@Component
public class DataSourceBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public static final String DATA_SOURCE_INITIALIZER_POST_PROCESSOR = "dataSourceInitializerPostProcessor";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        /**
         * MyBatisAutoConfiguration会自动注册一个dataSourceInitializerPostProcessor 导致引入动态数据源的是时候查找其他数据源，
         * 但是创建完成之后通过dataSourceInitializerPostProcessor处理会导致循环依赖
         * dynamicDataSource->sourceDataSource->dataSourceInitializerPostProcessor->DataSourceInitializerInvoker
         * ->dynamicDataSource循环依赖
         */
        if (registry.containsBeanDefinition(DATA_SOURCE_INITIALIZER_POST_PROCESSOR)) {
            registry.removeBeanDefinition(DATA_SOURCE_INITIALIZER_POST_PROCESSOR);
        }
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }
}


