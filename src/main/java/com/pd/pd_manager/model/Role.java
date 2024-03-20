package com.pd.pd_manager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pd_role")
public class Role {
    @Id
    @GeneratedValue
    private long id_role;

    private String v_name;
}
