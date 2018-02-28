package com.vidala.redditlite.web.rest;

import com.vidala.redditlite.domain.User;
import com.vidala.redditlite.domain.UserPost;
import com.vidala.redditlite.repository.UserPostRepository;
import com.vidala.redditlite.repository.UserRepository;
import com.vidala.redditlite.security.AuthoritiesConstants;
import com.vidala.redditlite.security.SecurityUtils;
import com.vidala.redditlite.service.PostService;
import com.vidala.redditlite.service.dto.UserDTO;
import com.vidala.redditlite.service.dto.UserPostDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserPostResource {

    private final Logger log = LoggerFactory.getLogger(UserPostResource.class);

    private final UserPostRepository userPostRepository;

    private final UserRepository userRepository;

    private final PostService postService;

    public UserPostResource(UserPostRepository userPostRepository, UserRepository userRepository, PostService postService) {
        this.userPostRepository = userPostRepository;
        this.userRepository = userRepository;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<UserPostDTO>> getPosts() {
        log.debug("REST request to get all posts");

        List<UserPost> posts = userPostRepository.findAll();
        return new ResponseEntity<>(postService.convertToDTO(posts), HttpStatus.OK);
    }

    @PutMapping("/posts")
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity<UserPostDTO> createPost(@Valid @RequestBody UserPostDTO postDTO) {

        User currentUser = userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin().get()).get();

        UserPostDTO newPost = postService.savePost(postDTO, currentUser);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
}
