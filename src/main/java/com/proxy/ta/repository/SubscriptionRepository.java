package com.proxy.ta.repository;

import com.proxy.ta.entity.SubscriptionEntity;
import java.util.List;
import java.util.Optional;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

  Optional<SubscriptionEntity> findByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

  @Override
  <S extends SubscriptionEntity> List<S> saveAll(Iterable<S> entities);
}
