package com.pd.pd_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Reference;

@Data
@Entity
@Table(name = "pd_DataType")
public class DocumentType {
    @Id
    @GeneratedValue
    private long id_DataType;   // Идентификатор типа данных
    private String v_name;      // Название типа данных

    //TODO: Сделать ссылку на себя, если необходимо. А так мб и нулл.
    private long id_Parent;

}
