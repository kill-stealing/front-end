package com.lmy.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmy.demo.domain.Comment;
import com.lmy.demo.mapper.CommentMapper;

@Service
public class CommentService {
	@Autowired
	CommentMapper commentMapper;
	
	public List<Comment> getCommentsByProductId(int productId){
		return commentMapper.getCommentsByProductId(productId);
	}	
	
	public List<Comment> doInsertCommnet(Comment comment){
		commentMapper.doInsertComment(comment);
		System.out.println(comment);
		return commentMapper.getCommentsByProductId(comment.getProductId());
	}
}
