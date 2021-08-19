package com.com.blog.bean;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SessionInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();// 체인 개념
        Request.Builder requestBuilder = request.newBuilder();

        requestBuilder.addHeader("Authorization", SessionUser.token);

        return chain.proceed(requestBuilder.build());
    }
}
