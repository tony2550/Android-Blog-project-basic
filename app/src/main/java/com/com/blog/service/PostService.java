package com.com.blog.service;

import com.com.blog.bean.SessionInterceptor;
import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.model.Post;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

// 인증이 필요없는 주소 /auth
// 인증이 필요한 주소 /user , /post
public interface PostService {

    @GET("/post") // 주소 변경 필요
    Call<CMRespDto<List<Post>>> findAll();

    @GET("/post/{id}") // 주소 변경 필요
    Call<CMRespDto<Post>> findById(@Path("id") int id);

    @GET("init/post")
    Call<CMRespDto<List<Post>>> initPost();

    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new SessionInterceptor()).build();

    Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.100.202.24:8077")
            .build();

    PostService service = retrofit.create(PostService.class);
}
