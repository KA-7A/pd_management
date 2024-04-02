package com.pd.pd_manager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "pd_RoleDataType")
public class RoleDataTypeMap {
    @Id
    @GeneratedValue
    private long id_RoleDataTypeMap;

    @ManyToMany
    private Set<Role> id_role;

    @ManyToMany
    private Set<DocumentType> id_data_type;

}
