package com.pd.pd_manager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pd_DocumentAttributes")
public class DocumentAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_pd_documentAttribute")
    @SequenceGenerator(name = "s_pd_documentAttribute",
                       sequenceName = "s_pd_documentAttribute",
                       initialValue = 1, allocationSize = 1)
    private Long id_attribute_inst;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_document_inst")
    private Documents document;

}
