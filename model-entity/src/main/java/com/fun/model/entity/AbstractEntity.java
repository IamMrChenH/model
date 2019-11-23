package com.fun.model.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenh
 * @date 2019-10-25
 */
@MappedSuperclass
public abstract class AbstractEntity<E extends AbstractEntity, R extends JpaRepository> implements Entity {

    @Transient
    private Object repository;

    private static final ConcurrentHashMap CACHE = new ConcurrentHashMap();

    @Override
    public R getRepository() {
        if (repository != null) {
            return (R) repository;
        }
        Class repositoryClass = getRepositoryClass();
        repository = CACHE.get(repositoryClass);
        if (repository != null) {
            return (R) repository;
        }
        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        if (applicationContext != null) {
            synchronized (CACHE) {
                Object bean = applicationContext.getBean(repositoryClass);
                repository = bean;
                CACHE.put(repositoryClass, bean);
            }
            return (R) repository;
        }
        return null;
    }

    public E findOne() {
        return getId() == null ? null : (E) getRepository().findOne(getId());
    }

    public E findAbsoluteOne() {
        E one = this.findOne();
        if (one != null) {
            return one;
        }
        throw new RuntimeException("NOT.FIND_DATA");
    }

}
