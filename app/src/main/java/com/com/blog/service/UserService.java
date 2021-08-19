package com.com.blog.service;

import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.controller.dto.LoginDto;
import com.com.blog.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

// 회원 정보보기는 토큰 필요 retrofit2 사용
public interface UserService {
    @POST("/login")
    Call<CMRespDto<User>> login(@Body LoginDto loginDto);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.100.202.24:8077/") // ip 주소 검색 하는 법 중요
            .build();

    UserService service = retrofit.create(UserService.class);
}
