package com.proxy.ta.controller;

import com.proxy.ta.entity.CommentEntity;
import com.proxy.ta.entity.FavoriteEntity;
import com.proxy.ta.entity.LikeEntity;
import com.proxy.ta.entity.PostEntity;
import com.proxy.ta.request.CommentRequest;
import com.proxy.ta.request.FavoriteRequest;
import com.proxy.ta.request.LikeRequest;
import com.proxy.ta.request.PostRequest;
import com.proxy.ta.service.CommentService;
import com.proxy.ta.service.LikeService;
import com.proxy.ta.service.PostService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostController {

  private PostService postService;
  private CommentService commentService;
  private LikeService likeService;

  @GetMapping("/feed")
  public List<PostEntity> getUsersFeed(@RequestParam Long userId) {
    return postService.getUserFeedPostsByUserId(userId);
  }

  @PostMapping("/new")
  public PostEntity newPost(@RequestBody PostRequest request) {
    return postService.newPost(request);
  }

  @PostMapping("/add-favorite")
  public FavoriteEntity addToFavorite(@RequestBody FavoriteRequest request) {
    return postService.addToFavorite(request);
  }

  @DeleteMapping("/remove-favorite")
  public FavoriteEntity removeFromFavorite(@RequestBody FavoriteRequest request) {
    return postService.removeFromFavorite(request);
  }

  @PostMapping("/add-comment")
  public CommentEntity addComment(@RequestBody CommentRequest request) {
    return commentService.addNewComment(request);
  }

  @GetMapping("/all-post-comments")
  public List<CommentEntity> getAllPostComments(@RequestParam Long postId) {
    return commentService.getAllByPostId(postId);
  }

  @PostMapping("/like")
  public LikeEntity addOrRemoveLike(@RequestBody LikeRequest request) {
    System.out.println("System.out.println(request);");
    System.out.println(request.getPostId() + " " + request.getUserId());
    return likeService.likePost(request);
  }

}
