package deshraj.chatapplication.service;

import deshraj.chatapplication.dto.PostsDto;
import deshraj.chatapplication.entity.PostsEntity;
import deshraj.chatapplication.repository.PostsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PostsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostsService.class);

    @Autowired
    private PostsRepository postsRepository;

    public Long savePosts(PostsDto post){
        PostsEntity postsEntity = Converter.convertToEntity(post,PostsEntity.class);
        postsEntity = postsRepository.save(postsEntity);
        LOGGER.error("post response payload {}: ",postsEntity);
        return postsEntity.getPostId();
    }

    public PostsDto getPostService(Long postId) throws Exception {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postId);
        LOGGER.error("postResponse payload {} :",postsEntity);
        if(!postsEntity.isPresent()){
            throw new Exception("Id does not exist ");
        }
        PostsEntity postsE = postsEntity.get();
        PostsDto postsDto = Converter.convertToEntity(postsE,PostsDto.class);
        return postsDto;
    }
}