package com.software.personalmanagement.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataVO<T> {


    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    @NotNull
    public static DataVO<Object> success(){
        return new DataVO<>(0,"success",null,null);
    }

    public static DataVO<Object> fail(){
        return new DataVO<>(-1,"fail",null,null);
    }

    public static DataVO<Object> fail(String msg){
        return new DataVO<>(-1,msg,null,null);
    }
}
