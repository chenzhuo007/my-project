package com.cz.util.bean;


import com.cz.util.dic.DicTranslateUtil;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <Description>：特性
 * 1、属性名称、类型都相同的字段，拷贝成功
 * 2、属性名称相同、类型不同的字段，拷贝失败，基础类型和包装类型视为不同类型
 * 3、setter，getter要一一对应，否则出现拷贝丢失
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/14
 */
public class CopyUtils {

    private static final Map<String, BeanCopier> CACHE_COPIER_MAP = new ConcurrentHashMap<>();

    private static final Converter DEFAULT_CONVERTER = null;

    /**
     * 构造器私有化
     */
    private CopyUtils() {
    }

    /**
     * 复制对象属性
     *
     * @param source       源
     * @param target       目标
     * @param dicTranslate 翻译：false：不翻译
     * @param converter    转换器
     * @param <S>          源泛型
     * @param <T>          目标泛型
     */
    public static <S, T> T copyObject(S source, T target, boolean dicTranslate, Converter converter) {
        if (null == source || target == null) {
            return null;
        }
        BeanCopier bc = getBeanCopierInstance(source.getClass(), target.getClass(), converter);
        bc.copy(source, target, converter);
        if (dicTranslate) {
            return DicTranslateUtil.translate(target);
        }
        return target;
    }

    /**
     * 复制对象属性
     *
     * @param source       源
     * @param target       目标
     * @param dicTranslate 翻译：false：不翻译
     * @param <S>          源泛型
     * @param <T>          目标泛型
     */
    public static <S, T> T copyObject(S source, T target, boolean dicTranslate) {
        return copyObject(source, target, dicTranslate, DEFAULT_CONVERTER);
    }

    /**
     * 复制对象属性
     *
     * @param source 源
     * @param target 目标
     * @param <S>    源泛型
     * @param <T>    目标泛型
     */
    public static <S, T> T copyObject(S source, T target) {
        return copyObject(source, target, false, DEFAULT_CONVERTER);
    }


    /**
     * 复制对象属性
     *
     * @param source       源
     * @param targetClass  目标类对象
     * @param dicTranslate 翻译：false：不翻译
     * @param converter    转换器
     * @param <S>          源泛型
     * @param <T>          目标泛型
     */
    public static <S, T> T copyObject(S source, Class<T> targetClass, boolean dicTranslate, Converter converter) {
        if (null == source) {
            return null;
        }
        T target;
        try {
            target = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Cannot instantiate an object of %s.", targetClass));
        }
        return copyObject(source, target, dicTranslate, converter);
    }

    /**
     * 复制对象属性
     *
     * @param source       源
     * @param targetClass  目标类对象
     * @param dicTranslate 翻译：false：不翻译
     * @param <S>          源泛型
     * @param <T>          目标泛型
     */
    public static <S, T> T copyObject(S source, Class<T> targetClass, boolean dicTranslate) {
        return copyObject(source, targetClass, dicTranslate, DEFAULT_CONVERTER);
    }

    /**
     * 复制对象属性
     *
     * @param source      源
     * @param targetClass 目标类对象
     * @param <S>         源泛型
     * @param <T>         目标泛型
     */
    public static <S, T> T copyObject(S source, Class<T> targetClass) {
        return copyObject(source, targetClass, false, DEFAULT_CONVERTER);
    }

    /**
     * 复制列表中所有元素到新列表中.
     *
     * @param sourceList   源列表
     * @param targetClass  目标列表元素class
     * @param <S>          源列表元素类型
     * @param <T>          目标列表元素类型
     * @param dicTranslate 是否需要翻译
     * @return 目标列表
     */
    public static <S, T> List<T> copyList(List<S> sourceList, Class<T> targetClass, boolean dicTranslate,
                                          Converter converter) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        }
        List<T> targetList = new ArrayList<T>();
        for (S source : sourceList) {
            try {
                T target = copyObject(source, targetClass, dicTranslate, converter);
                targetList.add(target);
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Cannot instantiate an object of %s.",
                        targetClass));
            }
        }
        return targetList;
    }

    /**
     * 复制列表中所有元素到新列表中.
     *
     * @param sourceList   源列表
     * @param targetClass  目标列表元素class
     * @param <S>          源列表元素类型
     * @param <T>          目标列表元素类型
     * @param dicTranslate 是否需要翻译
     * @return 目标列表
     */
    public static <S, T> List<T> copyList(List<S> sourceList, Class<T> targetClass, boolean dicTranslate) {
        return copyList(sourceList, targetClass, dicTranslate, DEFAULT_CONVERTER);
    }

    /**
     * 复制列表中所有元素到新列表中.
     *
     * @param sourceList  源列表
     * @param targetClass 目标列表元素class
     * @param <S>         源列表元素类型
     * @param <T>         目标列表元素类型
     * @return 目标列表
     */
    public static <S, T> List<T> copyList(List<S> sourceList, Class<T> targetClass) {
        return copyList(sourceList, targetClass, false, DEFAULT_CONVERTER);
    }

    /**
     * 缓存
     *
     * @param sourceClass
     * @param targetClass
     * @param converter
     * @param <S>
     * @param <T>
     * @return
     */
    private static <S, T> BeanCopier getBeanCopierInstance(Class<S> sourceClass, Class<T> targetClass,
                                                           Converter converter) {
        return CACHE_COPIER_MAP.computeIfAbsent(sourceClass.getName() + "#" + targetClass.getName(),
                value -> BeanCopier.create(sourceClass, targetClass, converter != null));
    }
}


