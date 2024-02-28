package com.proxy.ta.repository;

import com.proxy.ta.entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {

  FavoriteEntity deleteByUserIdAndPostId(Long userId, Long postId);

}
