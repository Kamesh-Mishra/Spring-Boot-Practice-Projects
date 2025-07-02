package com.prf.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prf.demo.entities.ProductEntity;

import jakarta.persistence.EntityManagerFactory;

@RestController
@RequestMapping("/audit")
public class AuditController {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@GetMapping("/products/{id}")
    public List<ProductEntity> getProductRevision(@PathVariable Long id){
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = auditReader.getRevisions(ProductEntity.class,id);

        return revisions.stream().map(revisionNumber -> auditReader.find(ProductEntity.class,id,revisionNumber))
                .collect(Collectors.toList());

    }
}
