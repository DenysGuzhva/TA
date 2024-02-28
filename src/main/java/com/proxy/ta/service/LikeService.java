package com.proxy.ta.service;

import com.proxy.ta.entity.LikeEntity;
import com.proxy.ta.repository.LikeRepository;
import com.proxy.ta.request.LikeRequest;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeService {

  private LikeRepository likeRepository;

  public LikeEntity likePost(LikeRequest request) {
    Optional<LikeEntity> likeEntity = likeRepository.findByPostIdAndUserId(request.getPostId(), request.getUserId());

    if (likeEntity.isPresent()) {
      likeRepository.delete(likeEntity.get());
      return likeEntity.get();

    }
    likeRepository.save(request.getPostId(), request.getUserId());
    return likeRepository.findByPostIdAndUserId(request.getPostId(), request.getUserId()).orElse(null);
  }

}
