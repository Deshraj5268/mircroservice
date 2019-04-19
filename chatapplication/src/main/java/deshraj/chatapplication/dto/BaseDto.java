package deshraj.chatapplication.dto;

import java.util.Date;

public class BaseDto {

    private Date createdOn;

    private Date modifiedOn;

    public void setCreatedOn(Date createdOn){
        this.createdOn = new Date();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void  setModifiedOn(Date modifiedOn){
        this.modifiedOn = new Date();
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }
}
