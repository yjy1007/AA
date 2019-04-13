package com.example.a.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.a.R;
import com.example.a.base.BaseActivity;
import com.example.a.guide.GuideActivity;

public class SplashActivity extends BaseActivity {

    private ImageView myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        //setAnimation(myimage);
        setAnimator(myimage);
    }

    private void setAnimator(ImageView myimage) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(myimage, "alpha", 0f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(myimage, "scaleX", 0, 1, 0, 1);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(myimage, "Rotation", 0, 1080f);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(myimage, "translationX", 0f, 10f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alpha,scaleX,rotation,translationX);
        animatorSet.setDuration(3000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.start();
    }

    private void setAnimation(ImageView myimage) {
        AlphaAnimation alpha = new AlphaAnimation(0f,1);
        ScaleAnimation scale = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alpha);
        animationSet.addAnimation(scale);
        animationSet.addAnimation(rotate);
        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);
        myimage.setAnimation(animationSet);
        animationSet.start();
    }

    private void initView() {
        myimage = (ImageView) findViewById(R.id.myimage);
    }
}
