package com.com.blog.view;

public interface InitActivity {
    void init(); // findViewId , new 메모리의 초기화 담당
    void initLr(); // 리스너 등록
    void initSetting(); // 각종 세팅
    default void initAdapter(){}
    default void initData(){} // 화면 초기화
}
