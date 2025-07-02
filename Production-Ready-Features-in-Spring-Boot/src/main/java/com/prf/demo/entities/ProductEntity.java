package com.prf.demo.entities;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="productss")
@Audited
//@AuditTable(value = "products_audit")
public class ProductEntity extends AuditableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String title;
    @NotAudited
    private String description;
    
    @PrePersist
    void beforeSave(){

    }

    @PreUpdate
    void beforeUpdate(){

    }

    @PreRemove
    
    void beforeRemove(){

    }
}
