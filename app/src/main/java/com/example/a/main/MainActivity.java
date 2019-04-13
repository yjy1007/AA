package com.example.a.main;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a.R;
import com.example.a.base.MvpActivity;

public class MainActivity extends MvpActivity<MainView, MainPresenter, WordBean> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         presenter.translate("json", "auto", "code");
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onSuccess(WordBean data) {
        String result = data.getTranslateResult().get(0).get(0).getTgt();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        System.out.println(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
