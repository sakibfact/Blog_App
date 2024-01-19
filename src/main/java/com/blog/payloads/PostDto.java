package com.blog.payloads;

import java.sql.Timestamp;

public class PostDto {

	private String title;
	private String content;
	private String imageName;
	private Timestamp addedDate;

	private CategoryDto categoryDto;

	private UserDto userDto;

	public PostDto(String title, String content, String imageName, Timestamp addedDate, CategoryDto categoryDto,
			UserDto userDto) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.categoryDto = categoryDto;
		this.userDto = userDto;
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Timestamp getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Timestamp addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "PostDto [title=" + title + ", content=" + content + ", imageName=" + imageName + ", addedDate="
				+ addedDate + ", categoryDto=" + categoryDto + ", userDto=" + userDto + "]";
	}
	
	

	
}
