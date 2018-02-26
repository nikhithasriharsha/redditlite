package com.vidala.redditlite.repository;

import com.vidala.redditlite.domain.User;
import com.vidala.redditlite.domain.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long>{

    List<UserPost> findAll();

    List<UserPost> findByUser(User user);

}
