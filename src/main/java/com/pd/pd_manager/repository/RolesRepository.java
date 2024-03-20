package com.pd.pd_manager.repository;

import com.pd.pd_manager.model.Person;
import com.pd.pd_manager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
