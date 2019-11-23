package com.fun.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author chenh
 * @date 2019-10-25
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity<E extends BaseEntity, R extends JpaRepository> extends AbstractEntity<E, R> {

    @Id
    @GeneratedValue
    private Long id;

}
