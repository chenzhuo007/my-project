package com.cz.util.id;

/**
 * <Description>：Id生成器接口
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/21
 */
public interface IdentifierGenerator {

    /**
     * 生成Id
     *
     * @param entity 实体
     * @return id
     */
    Number nextId(Object entity);

    /**
     * 生成uuid
     *
     * @param entity 实体
     * @return uuid
     */
    default String nextUUID(Object entity) {
        return IdWorker.get32UUID();
    }
}

