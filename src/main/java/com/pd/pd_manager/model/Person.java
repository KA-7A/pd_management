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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_person;

    private String v_name, v_last_name, v_patronymic_name;

    Date    dt_birthdate;
}
