package com.lmy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lmy.demo.domain.Comment;
import com.lmy.demo.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/comments/{productId}", method = RequestMethod.GET)
	public List<Comment> getCommentsByProductId(@PathVariable int productId) {
		return commentService.getCommentsByProductId(productId);
	}

	@PostMapping(value = "/comment")
	public List<Comment> doInsertComment(@RequestBody Comment comment) {
		return commentService.doInsertCommnet(comment);
	}
}
