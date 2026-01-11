package com.smith.manager.specification;

import com.smith.manager.entity.EventEntity;
import com.smith.manager.model.EventType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class EventSpecification {

    public static Specification<EventEntity> ids(List<UUID> ids){
        return ((root, query, criteriaBuilder) -> {
            if(CollectionUtils.isEmpty(ids))
                return criteriaBuilder.conjunction();
            return root.get("id_event").in(ids);
        });
    }

    public static Specification<EventEntity> topics(List<String> topics){
        return ((root, query, criteriaBuilder) -> {
            if(CollectionUtils.isEmpty(topics))
                return criteriaBuilder.conjunction();
            return root.get("topic").in(topics);
        });
    }

    public static Specification<EventEntity> severity(List<String> severity){
        return ((root, query, criteriaBuilder) -> {
            if(CollectionUtils.isEmpty(severity))
                return criteriaBuilder.conjunction();
            return root.get("severity").in(severity);
        });
    }

    public static Specification<EventEntity> type(List<EventType> type){
        return ((root, query, criteriaBuilder) -> {
            if(CollectionUtils.isEmpty(type))
                return criteriaBuilder.conjunction();
            List<String> filter = type.stream().map(Enum::toString).toList();
            return root.get("type").in(filter);
        });
    }
    public static Specification<EventEntity> clientId(List<UUID> clientId){
        return ((root, query, criteriaBuilder) -> {
            if(CollectionUtils.isEmpty(clientId))
                return criteriaBuilder.conjunction();
            return root.get("clientId").in(clientId);
        });
    }

    public static Specification<EventEntity> minOffset(long offset){
        return (((root, query, criteriaBuilder) -> {
            if(offset==-1)
                return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(root.get("kafka_offset"),offset);
        }));
    }

    public static Specification<EventEntity> offset(Long offsetFrom, Long offsetTo){
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

    public static Specification<EventEntity> sentAt(Timestamp from, Timestamp to){
        return (((root, query, criteriaBuilder) -> {
            if(from == null && to == null)
                return criteriaBuilder.conjunction();
            else if(from != null && to == null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("sent_at"), from);
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("sent_at"), to);
        }));
    }


}
