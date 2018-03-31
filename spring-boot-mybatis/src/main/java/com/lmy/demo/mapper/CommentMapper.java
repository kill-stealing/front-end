package com.lmy.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.lmy.demo.domain.Comment;

public interface CommentMapper {
	List<Comment> getCommentsByProductId(int productId);
	void doInsertComment(Comment comment);
}
