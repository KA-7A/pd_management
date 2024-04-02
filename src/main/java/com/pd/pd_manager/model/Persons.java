package com.pd.pd_manager.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "pd_persons")
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_pd_person")
    @SequenceGenerator(name = "s_pd_person",
                       sequenceName = "s_pd_person",
                       initialValue = 1, allocationSize = 1)    // Да, не очень производительно, но оно и не надо.
                                                    // Не слишком безопасно, но пока сойдёт
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_person")
    private long id_person_inst;

    private String v_name, v_last_name, v_patronymic_name;

    Date    dt_birthdate;


    public Persons(Long personId, String firstName, String lastName, String patronymicName, String birthdate) {

    }

    @ManyToMany(mappedBy = "personsWithRole", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Roles> rolesOfPerson;

    @ManyToMany(mappedBy = "personsUnderRole", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Roles> rolesUnderPerson;
}

// TODO: Исправить мои мудрения вокруг внешних ключей... Крч опять спотыкаемся об всякие неприятные мелочи в то время
// TODO: как давно их уже показывать и двигаться куда-то дальше. Как-то таааак :)