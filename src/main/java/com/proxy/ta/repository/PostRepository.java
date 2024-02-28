package com.proxy.ta.repository;

import com.proxy.ta.entity.PostEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

  @Query(value = "SELECT posts.* FROM posts LEFT JOIN subscriptions ON subscriptions.to_user_id = posts.user_id WHERE subscriptions.from_user_id = :userId ORDER BY posts.date_posted DESC", nativeQuery = true)
  List<PostEntity> findAllForUsersFeedByUserID(Long userId);

  Optional<PostEntity> findById(Long aLong);

  @Override
  List<PostEntity> findAll();

}
