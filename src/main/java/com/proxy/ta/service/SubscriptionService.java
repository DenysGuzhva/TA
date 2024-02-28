package com.proxy.ta.service;

import com.proxy.ta.entity.SubscriptionEntity;
import com.proxy.ta.repository.SubscriptionRepository;
import com.proxy.ta.request.SubscriptionRequest;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {

  private SubscriptionRepository subscriptionRepository;

  public SubscriptionEntity subscribeOrUnsubscribeToUser(SubscriptionRequest request) {
    Optional<SubscriptionEntity> subscribeEntity = subscriptionRepository.findByFromUserIdAndToUserId(request.getFromUserId(), request.getToUserId());

    if (subscribeEntity.isPresent()) {
      subscriptionRepository.delete(subscribeEntity.get());
      return subscribeEntity.get();

    }
    return subscriptionRepository
        .save(SubscriptionEntity.builder().fromUserId(request.getFromUserId()).toUserId(request.getToUserId()).build());
  }

}
