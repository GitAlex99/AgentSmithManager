package com.smith.manager.DAO;

import com.smith.manager.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<EventEntity,Long>, JpaSpecificationExecutor<EventEntity> {
}
