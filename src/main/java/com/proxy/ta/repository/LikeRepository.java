package com.proxy.ta.repository;

import com.proxy.ta.entity.LikeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

  @Modifying
  @Transactional
  @Query(value = "insert into likes ( post_id, user_id) values ( :postId, :userId)", nativeQuery = true)
  void save(Long postId, Long userId);

  LikeEntity deleteByPostIdAndUserId(Long postId, Long userId);

  Optional<LikeEntity> findByPostIdAndUserId(Long postId, Long userId);

}
