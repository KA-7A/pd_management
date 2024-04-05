package com.pd.pd_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Reference;

import java.util.Set;

@Data
@Entity
@Table(name = "pd_DocumentType")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_document_type;
    private String v_name;
    private String v_document_schema;

    @ManyToMany(mappedBy = "documentTypes", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<DocumentTypeToAttributeTypeListMap> listMapSet;

}
