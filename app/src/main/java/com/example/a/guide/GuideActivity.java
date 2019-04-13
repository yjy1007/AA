package com.example.a.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a.R;
import com.example.a.news.NewsActivity;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager vp;
    List<Fragment> fraglist = new ArrayList<>();
    private ImageView image_bt1;
    private ImageView image_bt2;
    private ImageView image_bt4;
    private ImageView image_bt3;
    private Button experience_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
        initAdapter();
        initListener();
    }

    private void initListener() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                System.out.println(i + "," + v + "," + i1 + ",");
                int distance = image_bt3.getLeft() - image_bt1.getLeft();
                if (i == 0) {
                    image_bt2.setTranslationX(distance * v);
                }
                if (i == 1) {
                    image_bt2.setTranslationX(distance);
                    image_bt2.setTranslationX((distance * v) + distance);
                }
            }

            @Override
            public void onPageSelected(int i) {
                if (0 == i) {
                    image_bt2.setTranslationX(0);
                } else if (1 == i) {
                    image_bt2.setTranslationX(image_bt3.getLeft() - image_bt1.getLeft());
                } else if (2 == i) {
                    image_bt2.setTranslationX(image_bt4.getLeft() - image_bt1.getLeft());
                }

                if(i == fraglist.size()-1) {
                    experience_btn.setVisibility(View.VISIBLE);
                }else {
                    experience_btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initAdapter() {
        Myadapter myadapter = new Myadapter(getSupportFragmentManager(), fraglist);
        vp.setAdapter(myadapter);
    }

    private void initData() {
        fraglist.add(new OneFragment());
        fraglist.add(new TwoFragment());
        fraglist.add(new ThreeFragment());
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        image_bt1 = (ImageView) findViewById(R.id.image_bt1);
        image_bt2 = (ImageView) findViewById(R.id.image_bt2);
        image_bt4 = (ImageView) findViewById(R.id.image_bt4);
        image_bt3 = (ImageView) findViewById(R.id.image_bt3);
        experience_btn = (Button) findViewById(R.id.experience_btn);
        //experience_btn.setOnClickListener(this);
    }

    //TODO  立即体验的监听事件
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.experience_btn:
////                Intent intent = new Intent(GuideActivity.this, NewsActivity.class);
////                startActivity(intent);
//                break;
//        }
//    }
}
