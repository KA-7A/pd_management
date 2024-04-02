package com.pd.pd_manager.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "pd_role")
public class Role {
    @Id
    @GeneratedValue
    private long id_role_type;

    private String v_name;
    private String v_description;

    private long id_parent;

    @OneToMany
    @JoinColumn(name = "id_role_type", insertable = false, updatable = false)
    private Set<Roles> rolesSet;
}
