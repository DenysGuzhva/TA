package com.proxy.ta.service;

import com.proxy.ta.entity.FavoriteEntity;
import com.proxy.ta.entity.PostEntity;
import com.proxy.ta.repository.FavoriteRepository;
import com.proxy.ta.repository.PostRepository;
import com.proxy.ta.request.FavoriteRequest;
import com.proxy.ta.request.PostRequest;
import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {

  private PostRepository postRepository;
  private FavoriteRepository favoriteRepository;

  public List<PostEntity> getUserFeedPostsByUserId(Long userId) {
    return postRepository.findAllForUsersFeedByUserID(userId);
  }

  public PostEntity newPost(PostRequest request) {
    return postRepository.save(PostEntity
        .builder()
        .userId(request.getUserId())
        .datePosted(new Timestamp(System.currentTimeMillis()))
        .text(request.getText())
        .build());
  }

  public FavoriteEntity addToFavorite(FavoriteRequest request) {
    return favoriteRepository.save(FavoriteEntity
        .builder()
        .userId(request.getUserId())
        .postId(request.getPostId()).build());
  }

  public FavoriteEntity removeFromFavorite(FavoriteRequest request) {
    return favoriteRepository.deleteByUserIdAndPostId(request.getUserId(), request.getPostId());
  }
}
