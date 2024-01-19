package com.blog.services.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Repositories.CategoryRepository;
import com.blog.Repositories.PostRepository;
import com.blog.Repositories.UserRepository;
import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.globalExceptionhandler.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.payloads.PostDto;
import com.blog.payloads.UserDto;
import com.blog.services.PostService;

@Service
public class PostServiceImplementation implements PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("Default.png");
		post.setAddedDate(Timestamp.valueOf(LocalDateTime.now()));
		post.setUser(user);
		post.setCategory(category);
		Post createdPost = this.postRepository.save(post);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		PostDto updatePostDTO = this.modelMapper.map(createdPost, PostDto.class);
		updatePostDTO.setCategoryDto(categoryDto);
		updatePostDTO.setUserDto(userDto);
		return updatePostDTO;
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
           Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		post.setAddedDate(Timestamp.valueOf(LocalDateTime.now()));
		Post updatedPost = postRepository.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
		this.postRepository.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = this.postRepository.findAll();
		User user = posts.stream().map(Post::getUser).findAny().get();
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		Category category = posts.stream().map(Post::getCategory).findAny().get();
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		postDtos.forEach(item -> {
			item.setCategoryDto(categoryDto);
			item.setUserDto(userDto);

		});
		return postDtos;
	}

	@Override
	public List<PostDto> getPostById(Integer postId) {

		Optional<Post> findById = this.postRepository.findById(postId);
		Category category = findById.stream().map(Post::getCategory).findAny().get();
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		User user = findById.stream().map(Post::getUser).findAny().get();
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		List<PostDto> postDto = findById.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		postDto.forEach(item -> {
			item.setCategoryDto(categoryDto);
			item.setUserDto(userDto);
		});
		return postDto;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
		List<Post> posts = this.postRepository.findByCategory(category);
		User user = posts.stream().map(Post::getUser).findAny().get();
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		postDtos.forEach(item -> {
			item.setCategoryDto(categoryDto);
			item.setUserDto(userDto);
		});

		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		List<Post> posts = this.postRepository.findByUser(user);
		Category category = posts.stream().map(Post::getCategory).findAny().get();
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		postDtos.forEach(item -> {
			item.setCategoryDto(categoryDto);
			item.setUserDto(userDto);
		});
		return postDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
