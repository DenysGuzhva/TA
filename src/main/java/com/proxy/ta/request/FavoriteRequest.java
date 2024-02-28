package com.proxy.ta.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FavoriteRequest {

  private Long userId;
  private Long postId;



}
