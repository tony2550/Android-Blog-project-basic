package com.com.blog.controller;

import android.util.Log;

import com.com.blog.model.Post;
import com.com.blog.service.PostService;
import com.com.blog.controller.dto.CMRespDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// View와 통신하는 중개자
public class PostController {

    private static final String TAG = "PostController";
    private PostService postService = PostService.service;

    public Call<CMRespDto<List<Post>>> findAll(){
        return postService.findAll();
    }

    public Call<CMRespDto<Post>> findById(int postId){
        return postService.findById(postId);
    }


    //test
    public void initPost(){
        Log.d(TAG, "initPost: ");
        Call<CMRespDto<List<Post>>> call = postService.initPost(); // postService.initPost().enqueue();
        call.enqueue(new Callback<CMRespDto<List<Post>>>() {
            @Override
            public void onResponse(Call<CMRespDto<List<Post>>> call, Response<CMRespDto<List<Post>>> response) {
                CMRespDto<List<Post>> cm = response.body();
                Log.d(TAG, "onResponse: title:"+cm.getData().get(0));
            }

            @Override
            public void onFailure(Call<CMRespDto<List<Post>>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });

    }
}
