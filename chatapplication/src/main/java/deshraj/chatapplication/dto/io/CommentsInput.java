package deshraj.chatapplication.dto.io;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import deshraj.chatapplication.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsInput extends BaseDto{

    private String text;

    private String commentedBy;

    private Long postId;
}
