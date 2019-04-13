package com.example.a.main;

import com.example.a.base.BasePresenter;
import com.example.a.base.ModelManager;

public class MainPresenter extends BasePresenter<MainView>{

    public   void   translate(String  doctype,String  type,String i) {
        MainModel model = ModelManager.getInstance().getModel(MainModel.class);
        model.translate(doctype, type, i, new MainCallback() {
            @Override
            public void onSuccess(WordBean data) {
                if(isAttach()){
                    view.onSuccess(data);
                }
            }

            @Override
            public void onFailure(String message) {
                if(isAttach()){
                    view.onFailure(message);
                }
            }
        });
    }
}
