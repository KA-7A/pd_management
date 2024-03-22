package com.pd.pd_manager.model;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table (name = "pd_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_pd_person")
    @SequenceGenerator(name = "s_pd_person",
                       sequenceName = "s_pd_person",
                       initialValue = 1, allocationSize = 1)    // Да, не очень производительно, но оно и не надо.
                                                    // Не слишком безопасно, но пока сойдёт
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_person")
    private long id_person;

    private String v_name, v_last_name, v_patronymic_name;

    Date    dt_birthdate;
}
