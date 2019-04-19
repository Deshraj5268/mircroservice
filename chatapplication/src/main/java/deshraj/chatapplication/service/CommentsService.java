
package deshraj.chatapplication.service;

import deshraj.chatapplication.dto.CommentsDto;
import deshraj.chatapplication.dto.PostsDto;
import deshraj.chatapplication.dto.io.CommentsInput;
import deshraj.chatapplication.entity.CommentsEntity;
import deshraj.chatapplication.entity.PostsEntity;
import deshraj.chatapplication.repository.CommentsRepository;
import deshraj.chatapplication.repository.PostsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsService.class);

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private PostsRepository postsRepository;

    public CommentsDto saveComment(CommentsInput commentsInput){
        CommentsDto commentsDto = null;
        try {
            ////validation
            commentsDto = Converter.convertToEntity(commentsInput, CommentsDto.class);
            CommentsEntity commentsEntity = Converter.convertToEntity(commentsDto, CommentsEntity.class);
            PostsEntity postsEntity = postsRepository.findById(commentsInput.getPostId()).get();
            commentsEntity.setPost(postsEntity);
            commentsEntity = commentsRepository.save(commentsEntity);
            commentsDto = Converter.convertToEntity(commentsEntity, CommentsDto.class);
            LOGGER.error("post response payload {}: ", commentsDto);
        }catch(Exception ex){
            LOGGER.error("exception : {}",ex);
        }
        return commentsDto;
    }

    public CommentsDto getCommentService(Long commentId){
        CommentsDto commentsDto = null;
        try {
            Optional<CommentsEntity> commentsEntity = commentsRepository.findById(commentId);
            if (!commentsEntity.isPresent()) {
                throw new Exception("Id does not exist ");
            }
            CommentsEntity commentsE = commentsEntity.get();
            LOGGER.error("commentResponse payload {} :", commentsE);
            commentsDto = Converter.convertToEntity(commentsE, CommentsDto.class);
        }catch (Exception ex){
            LOGGER.error("exception  :",ex);
        }
        return commentsDto;
    }
}