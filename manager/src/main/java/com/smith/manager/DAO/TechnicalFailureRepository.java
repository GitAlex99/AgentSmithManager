package com.smith.manager.DAO;

import com.smith.manager.entity.TechnicalFailureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TechnicalFailureRepository extends JpaRepository<TechnicalFailureEntity,Long>, JpaSpecificationExecutor<TechnicalFailureEntity> {
}
