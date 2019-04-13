package com.example.a.base;

public interface BaseCallback<D> {
    void  onSuccess(D  data);
    void  onFailure(String  message);
}
