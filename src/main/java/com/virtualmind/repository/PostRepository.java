package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Post;

@Component("postRepository")
public interface PostRepository extends CrudRepository<Post, Integer> {

}
