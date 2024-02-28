package com.proxy.ta.request;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentRequest {

  private Long commentedPostId;
  private Long userID;
  private Timestamp dateCommented;
  private String text;

}
