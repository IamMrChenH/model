package com.fun.model.entity;

import java.io.Serializable;

/**
 * @author chenh
 * @date 2019-10-25
 */
public interface Entity {

    Serializable getId();

    Object getRepository();

    Class getRepositoryClass();
}
