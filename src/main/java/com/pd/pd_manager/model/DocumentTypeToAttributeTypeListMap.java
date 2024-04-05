package com.pd.pd_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pd_DocumentTypeToAttributeTypeListMap")
public class DocumentTypeToAttributeTypeListMap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_doc_to_attr_map;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pd_DocTypeToListMap_map",
               joinColumns = {
                       //@JoinColumn(name = "id_document_type", referencedColumnName = "id_document_type", nullable = false)
                       @JoinColumn(name = "id_doc_to_attr_map", referencedColumnName = "id_doc_to_attr_map", nullable = false)
               },
               inverseJoinColumns = {
                       @JoinColumn(name = "id_document_type", referencedColumnName = "id_document_type", nullable = false)
               })
    private Set<DocumentType> documentTypes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pd_AttrTypeToListMap_map",
            joinColumns = {
                    //@JoinColumn(name = "id_attribute_type", referencedColumnName = "id_attribute_type", nullable = false)
                    @JoinColumn(name = "id_doc_to_attr_map", referencedColumnName = "id_doc_to_attr_map", nullable = false)  // Или так? Чет я не очень понимаю :(
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_attribute_type", referencedColumnName = "id_attribute_type", nullable = false)
            })
    private Set<AttributeType> attributeTypes;
}
