package com.smith.manager.specification;

import com.smith.manager.entity.EventEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.List;

public class EventSpecification {

    public static Specification<EventEntity> ids(List<Long> ids){
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

    public static Specification<EventEntity> minOffset(long offset){
        return (((root, query, criteriaBuilder) -> {
            if(offset==-1)
                return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThanOrEqualTo(root.get("kafka_offset"),offset);
        }));
    }

    public static Specification<EventEntity> offset(long offsetFrom, long offsetTO){
        return (((root, query, criteriaBuilder) -> {
            if(offsetFrom == -1 && offsetTO == -1)
                return criteriaBuilder.conjunction();
            else if(offsetFrom == -1 && offsetTO != -1)
                return criteriaBuilder.lessThanOrEqualTo(root.get("kafka_offset"),offsetTO);
            return criteriaBuilder.greaterThanOrEqualTo(root.get("kafka_offset"),offsetFrom);
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
