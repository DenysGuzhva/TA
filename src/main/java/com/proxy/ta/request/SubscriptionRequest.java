package com.proxy.ta.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionRequest {

  private Long fromUserId;
  private Long toUserId;

}
