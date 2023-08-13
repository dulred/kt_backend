package com.atguigu.ggkt.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgktException  extends RuntimeException{
    private Integer code ;
    private String message;

}
