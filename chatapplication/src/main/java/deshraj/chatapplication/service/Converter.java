package deshraj.chatapplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import deshraj.chatapplication.dto.PostsDto;
import deshraj.chatapplication.entity.PostsEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Converter {

    private Converter(){

    }

    public static <T> T convertToEntity(Object object,Class<T> classOf){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(object,classOf);
    }

    public static Map convertToMap(PostsDto postObj){
        Map responseMap = new HashMap<String,Object>();
        //PostsEntity postObj =  object.get();
        responseMap.put("title",postObj.getTitle());
        responseMap.put("content",postObj.getContent());
        responseMap.put("disc",postObj.getDescription());
        return responseMap;
    }
}
