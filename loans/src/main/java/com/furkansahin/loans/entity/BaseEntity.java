package com.furkansahin.loans.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedBy
    @Column(updatable = false)
    String createdBy;
    
    @CreatedDate
    @Column(updatable = false)
    LocalDateTime createdAt;

    @LastModifiedBy
    @Column(insertable = false)
    String updatedBy;

    @LastModifiedDate
    @Column(insertable = false)
    LocalDateTime updatedAt;
}
