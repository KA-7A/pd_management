package com.pd.pd_manager.repository;

import com.pd.pd_manager.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTypeRepository extends JpaRepository<DocumentType, Long> {
}
