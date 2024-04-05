package com.pd.pd_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "pd_DocumentAttributeType")
public class AttributeType {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "id_attribute_type")
    private Long id_attribute_type;
    private String v_name;


    @ManyToMany(mappedBy = "attributeTypes", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<DocumentTypeToAttributeTypeListMap> listMapSet;
//    @OneToMany(fetch = FetchType.LAZY)
//    private Set<DocumentAttributes> documentAttributes;


}
