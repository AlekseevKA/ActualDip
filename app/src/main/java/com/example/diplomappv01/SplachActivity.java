package com.example.diplomappv01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplachActivity extends AppCompatActivity {
    private ImageView logoSplach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);


        logoSplach = findViewById(R.id.logoSplach);
        // Получение высоты экрана
        int screenHeight = getResources().getDisplayMetrics().heightPixels;

        // Создание анимации с перемещением
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -1f,
                Animation.RELATIVE_TO_SELF, 0f);
        translateAnimation.setDuration(1000); // Длительность анимации (в миллисекундах)
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator()); // Интерполятор для плавного старта и остановки
        translateAnimation.setFillAfter(true); // Установка, чтобы View оставался на своем месте после анимации

        // Создание анимации с плавным затуханием
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(1000); // Длительность анимации (в миллисекундах)
        alphaAnimation.setFillAfter(true); // Установка, чтобы View оставался полностью видимым после анимации

        // Создание комбинированной анимации
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);



        // Запуск анимации на ImageView
        logoSplach.startAnimation(animationSet);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplachActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);

    }
}