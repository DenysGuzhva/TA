package com.proxy.ta.repository;

import com.proxy.ta.entity.CommentEntity;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

  @Modifying
  @Transactional
  @Query(value = "insert into comments (commented_post_id, user_id, date_commented, text) values ( :postId, :userId, :date, :text)", nativeQuery = true)
  void saveComment(Long postId, Long userId, Timestamp date, String text);

  CommentEntity deleteByCommentedPostIdAndUserId(Long commentedPostId, Long userId);

  List<CommentEntity> findAllByCommentedPostId(Long postId);

  CommentEntity findCommentEntitiByCommentedPostIdAndUserId(Long commentedPostId, Long userId);

}
