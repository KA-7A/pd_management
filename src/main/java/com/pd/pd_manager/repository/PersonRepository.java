package com.pd.pd_manager.repository;

import com.pd.pd_manager.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Persons, Long> {
}
