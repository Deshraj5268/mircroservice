package deshraj.chatapplication.controller;

import deshraj.chatapplication.dto.CommentsDto;
import deshraj.chatapplication.dto.PostsDto;
import deshraj.chatapplication.dto.io.CommentsInput;
import deshraj.chatapplication.service.CommentsService;
import deshraj.chatapplication.service.PostsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/chats/", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostsService postsService;
    @Autowired
    private CommentsService commentsService;

    @PostMapping(path = "save/posts")
    public ResponseEntity<?> createPost(@RequestBody PostsDto post){
        LOGGER.error("posts payload {} : ",post);
        return new ResponseEntity(postsService.savePosts(post),HttpStatus.OK);
    }

    @GetMapping(path = "/posts/{postId}")
    public ResponseEntity<PostsDto> getPost(@RequestBody @PathVariable(value = "postId") Long postId) throws Exception{
        LOGGER.error("postID payload {} : ",postId);
        return new ResponseEntity<>(postsService.getPostService(postId),HttpStatus.OK);
    }

    @PostMapping(path = "/post/comments")
    public ResponseEntity<?> createComment(@RequestBody CommentsInput commentsInput){
        LOGGER.error("comment payload {} : ",commentsInput);
        return new ResponseEntity(commentsService.saveComment(commentsInput),HttpStatus.OK);
    }

    @GetMapping(path = "/posts/comments/{commentId}")
    public ResponseEntity<CommentsDto> getComment(@RequestBody @PathVariable(value = "commentId") Long commentId){
        LOGGER.error("commentId payload {} : ",commentId);
        return new ResponseEntity<>(commentsService.getCommentService(commentId),HttpStatus.OK);
    }

    @GetMapping(path = "/test")
    public ResponseEntity<String> testUrl(){
        String result = "Hello world";
        return new ResponseEntity<>(result, HttpStatus.OK) ;
    }
}