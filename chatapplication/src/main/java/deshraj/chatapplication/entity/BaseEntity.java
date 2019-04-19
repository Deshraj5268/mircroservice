package deshraj.chatapplication.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    private Date createdOn;

    private Date modifiedOn;
}
