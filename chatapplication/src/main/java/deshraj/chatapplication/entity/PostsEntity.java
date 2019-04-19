package deshraj.chatapplication.entity;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
public class PostsEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "postId")
    private Long postId;

    @NonNull
    @Column(name = "title",unique = true)
    private String title;

    @NonNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "content")
    private String content;

}