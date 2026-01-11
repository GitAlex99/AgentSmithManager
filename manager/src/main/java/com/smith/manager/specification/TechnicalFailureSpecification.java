package com.smith.manager.specification;

import com.smith.manager.entity.EventEntity;
import com.smith.manager.entity.TechnicalFailureEntity;
import org.springframework.data.jpa.domain.Specification;

public class TechnicalFailureSpecification {
    public static Specification<TechnicalFailureEntity> topicTechFailure(String topic){
        return ((root, query, criteriaBuilder) -> {
            if(topic == null)
                return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("topic"),topic);
        });
    }
    public static Specification<TechnicalFailureEntity> offsetTechFailure(Long offsetFrom, Long offsetTo){
        return (((root, query, criteriaBuilder) -> {
            if(offsetFrom == null && offsetTo == null)
                return criteriaBuilder.conjunction();
            else if(offsetFrom == null && offsetTo != null)
                return criteriaBuilder.lessThanOrEqualTo(root.get("kafka_offset"),offsetTo);
            else if(offsetFrom != null && offsetTo == null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("kafka_offset"),offsetFrom);
            return criteriaBuilder.between(root.get("kafka_offset"),offsetFrom,offsetTo);
        }));
    }
}
