package com.pd.pd_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pd_DataType")
public class DataType {
    @Id
    @GeneratedValue
    private long id_DataType;   // Идентификатор типа данных
    private String v_name;      // Название типа данных

}
