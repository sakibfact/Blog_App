package com.blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
