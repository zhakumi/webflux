package com.wangcan.spring.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

/**
 * @program: demo
 * @description: ${description}
 * @author: wangcan
 * @create: 2018-09-14 21:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String phone;
    private String email;
    private String name;
    private Date birthday;


}
