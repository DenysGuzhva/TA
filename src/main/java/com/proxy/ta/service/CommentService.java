package com.proxy.ta.service;

import com.proxy.ta.entity.CommentEntity;
import com.proxy.ta.repository.CommentRepository;
import com.proxy.ta.request.CommentRequest;
import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

  CommentRepository commentRepository;

  public CommentEntity addNewComment(CommentRequest request) {
    commentRepository.saveComment(request.getCommentedPostId(), request.getUserID(), request.getDateCommented(), request.getText());
    return commentRepository.findCommentEntitiByCommentedPostIdAndUserId(request.getCommentedPostId(), request.getUserID());
  }

  public CommentEntity deleteComment(CommentRequest request) {
    return commentRepository.deleteByCommentedPostIdAndUserId(request.getCommentedPostId(), request.getUserID());
  }

  public List<CommentEntity> getAllByPostId(Long postId) {
    return commentRepository.findAllByCommentedPostId(postId);
  }

}
