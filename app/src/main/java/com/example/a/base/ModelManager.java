package com.example.a.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ModelManager {
    private static final  ModelManager  ourInstance  = new ModelManager();
    public   static  ModelManager  getInstance(){
        return  ourInstance;
    }

    private ModelManager(){}

    public <M>  M  getModel (Class<M> modelClass) {
        try {
            Constructor<M>  constructor = modelClass.getConstructor();
            M  instance = constructor.newInstance();
            return   instance;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
}
