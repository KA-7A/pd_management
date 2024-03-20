package com.pd.pd_manager.repository;

import com.pd.pd_manager.model.DataType;
import com.pd.pd_manager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTypeRepository extends JpaRepository<DataType, Long> {
}
