package com.example.a.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public  abstract class MvpActivity<V  extends BaseView, P  extends BasePresenter<V>,D> extends BaseActivity implements BaseView<D>{
    protected  P  presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V)this);
    }
    protected   abstract P  createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
