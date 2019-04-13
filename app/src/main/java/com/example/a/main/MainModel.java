package com.example.a.main;

import com.example.a.base.BaseModel;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel{
    public  void  translate(String  doctype,String  type,String i,final  MainCallback  callback){
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://fanyi.youdao.com/")
                        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                        .build();
        TranslateService service = retrofit.create(TranslateService.class);
        Call<WordBean> call = service.translate(doctype, type, i);
        call.enqueue(new Callback<WordBean>() {
            @Override
            public void onResponse(Call<WordBean> call, Response<WordBean> response) {
                if(callback != null) {
                    if(response.isSuccessful()){
                        WordBean bean = response.body();
                        callback.onSuccess(bean);
                    }else {
                        callback.onFailure(response.message());
                    }
                }else {
                  throw  new NullPointerException("空指针");
                }
            }

            @Override
            public void onFailure(Call<WordBean> call, Throwable t) {
                if(callback != null){
                    callback.onFailure(t.getMessage());
                }else {
                    throw  new NullPointerException("空指针");
                }
            }
        });

    }
}
