package com.vidala.redditlite.service;

import com.vidala.redditlite.domain.User;
import com.vidala.redditlite.domain.UserPost;
import com.vidala.redditlite.repository.UserPostRepository;
import com.vidala.redditlite.service.dto.UserPostDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserPostRepository userPostRepository;

    public PostService(UserPostRepository postRepository) {
        this.userPostRepository = postRepository;
    }

    public UserPostDTO savePost(UserPostDTO postDTO, User currentUser) {
        UserPost newPost = new UserPost();

        newPost.setTitle(postDTO.getTitle());
        newPost.setDescription(postDTO.getDescription());
        newPost.setImageUrl(postDTO.getImageUrl());
        newPost.setThumbnail(postDTO.getThumbnail());
        newPost.setUser(currentUser);

        userPostRepository.save(newPost);
        log.debug("Saved new post: "+newPost.getId());

        return convertToDTO(newPost);
    }

    public List<UserPostDTO> convertToDTO(List<UserPost> userPosts) {
        List<UserPostDTO> userPostDTOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(userPosts)) {
            for(UserPost post : userPosts) {
                userPostDTOS.add(convertToDTO(post));
            }
        }

        return userPostDTOS;
    }

    private UserPostDTO convertToDTO(UserPost post) {
        UserPostDTO dto = new UserPostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setImageUrl(post.getImageUrl());
        dto.setThumbnail(post.getThumbnail());
        dto.setUserId(post.getUser().getId());
        dto.setUserName(post.getUser().getLogin());

        return dto;
    }
}
