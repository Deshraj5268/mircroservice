package deshraj.chatapplication.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class CommentsDto extends BaseDto{

    private  Long commentId;

    private String text;

    private String commentedBy;

    private PostsDto post;
}
