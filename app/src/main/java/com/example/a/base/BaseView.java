package com.example.a.base;

public interface BaseView<D> {
    void  onSuccess(D  data);
    void  onFailure(String  message);
}
