package com.com.blog.bean;

import com.com.blog.model.User;

import lombok.Data;

@Data
public class SessionUser {
    public static User user;
    public static String token;
}
