package com.proxy.ta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CommentEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "commented_post_id", insertable=false, updatable=false)
  private Long commentedPostId;
  @Column(name = "user_id")
  private Long userId;
  @Column(name = "date_commented")
  private Timestamp dateCommented;
  @Column(name = "text")
  private String text;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="commented_post_id", nullable=false)
  private PostEntity post;


}
