package com.cz.util.dic;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * <Description>：动态Bean
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/22
 */
public class DynamicBean<T> {

    /**
     * 目标对象
     */
    private final T target;

    /**
     * 属性集合
     */
    private final BeanMap beanMap;


    public DynamicBean(T target, Map<String, Class<?>> propertyMap) {
        this.target = generateBean(target.getClass(), propertyMap);
        this.beanMap = BeanMap.create(this.target);
    }

    /**
     * bean 添加属性和值
     *
     * @param property
     * @param value
     */
    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    /**
     * 获取属性值
     *
     * @param property
     * @return
     */
    public Object getValue(String property) {
        return beanMap.get(property);
    }

    /**
     * 获取对象
     *
     * @return
     */
    public T getTarget() {
        return this.target;
    }


    /**
     * 根据属性生成对象
     *
     * @param superclass
     * @param propertyMap
     * @return
     */
    private T generateBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
        BeanGenerator generator = new BeanGenerator();
        if (null != superclass) {
            generator.setSuperclass(superclass);
        }
        BeanGenerator.addProperties(generator, propertyMap);
        return ((T) generator.create());
    }

    /**
     * 为实体添加属性
     *
     * @param target          要增加属性的对象
     * @param addProperties   要增加的属性名及值
     * @param discardOldValue 是否舍弃原有属性的值，如果true，则原有属性的值将都被置为默认值
     * @param <T>
     * @return
     */
    public static <T> T addProperties(T target, Map<String, ?> addProperties, boolean discardOldValue) {

        //1.获取原对象的字段数组
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(target);

        //2.遍历原对象的字段数组，并将其封装到Map
        Map<String, Class<?>> propertyMap = new HashMap<>(16);
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        //3.将扩展字段Map合并到原字段Map中
        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));

        //4.根据新的字段组合生成子类对象
        DynamicBean<T> dynamicBean = new DynamicBean<T>(target, propertyMap);

        //5.添加旧属性值
        if (!discardOldValue) {
            propertyMap.forEach((k, v) -> {
                try {
                    if (!addProperties.containsKey(k)) {
                        dynamicBean.setValue(k, propertyUtilsBean.getNestedProperty(target, k));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        //6.放回合并后的属性集合
        addProperties.forEach((k, v) -> {
            try {
                dynamicBean.setValue(k, v);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return dynamicBean.getTarget();
    }
}
