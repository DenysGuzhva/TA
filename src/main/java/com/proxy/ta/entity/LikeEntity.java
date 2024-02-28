package com.proxy.ta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@Table(name = "likes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LikeEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "post_id", insertable=false, updatable=false)
  private Long postId;
  @Column(name = "user_id")
  private Long userId;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="post_id", nullable=false)
  private PostEntity post;

}
