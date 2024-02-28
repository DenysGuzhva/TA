package com.proxy.ta.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class LikeRequest {

  private Long userId;
  private Long postId;
}
