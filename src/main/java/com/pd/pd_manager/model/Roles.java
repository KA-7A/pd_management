package com.pd.pd_manager.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pd_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_pd_roles")
    @SequenceGenerator(name = "s_pd_roles",
                       sequenceName = "s_pd_roles",
                       initialValue = 1, allocationSize = 1)
    private long id_role_inst;

    @ManyToOne
    @JoinColumn(name = "pd_role")
    private RoleType roleType;

    @ManyToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pd_roles_of_person_map",
               joinColumns = {
                    @JoinColumn(name = "id_role_inst", referencedColumnName = "id_role_inst", nullable = false)
               },
               inverseJoinColumns = {
                    @JoinColumn(name = "id_person_inst", referencedColumnName = "id_person_inst", nullable = false)
               }
    )
    @JsonManagedReference
    private Set<Persons> personsWithRole;

    @ManyToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pd_persons_under_role_map",
            joinColumns = {
                    @JoinColumn(name = "id_role_inst", referencedColumnName = "id_role_inst", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_person_inst", referencedColumnName = "id_person_inst", nullable = false)
            }
    )
    @JsonManagedReference
    private Set<Persons> personsUnderRole;
}
