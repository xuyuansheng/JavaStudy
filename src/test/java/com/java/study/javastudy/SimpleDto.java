package com.java.study.javastudy;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Mr.Xu
 * @date 2020/3/31 21:27
 */

@Data
@Accessors(chain = true)
@Builder
public class SimpleDto {

    private String dept;
    private String name;
    private Integer age;
}
