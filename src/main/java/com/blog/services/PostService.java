package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;

public interface PostService  {

	// For create post
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//For update post
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//For deleting post
	
	void deletePost(Integer postId);
	
	//Get ALL posts
	
	List<PostDto> getAllPost();
	
	//Get single post
	
	List<PostDto> getPostById(Integer postId);
	
	//Get all posts by category 
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	
	//Get all posts by User
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//SerchPosts
	
	List<PostDto> searchPosts(String keyword);

	
}
