package com.atguigu.ggkt.config.result;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class Result <T>{

    //返回码
    private Integer Code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    public Result(){}

    public static <T> Result<T> build (T body,Integer code,String message) {
        Result<T> result  = new Result<>();
        if (body!=null) {
            result.setData(body);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public  static <T> Result<T> ok (){
        return Result.ok(null);
    }

    /**
     * 操作成功
     * @param data
     * @return
     * @param <T>
     */
    public static <T> Result<T> ok(T data){
        return build(data,20000,"成功");
    }

    public static <T> Result<T> fail(){
        return Result.fail(null);
    }

    /**
     * 操作失败
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail (T data){
        return Result.build(data,20001,"失败");
    }

    public Result<T> message (String message) {
        this.setMessage(message);
        return this;
    }

    public Result<T> code (Integer code) {
        this.setCode(code);
        return this;
    }





}
