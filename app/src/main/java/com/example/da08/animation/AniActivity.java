package com.example.da08.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

public class AniActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button5;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        initView();
    }

    private void initView() {
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button5 :
                ObjectAnimator transY = ObjectAnimator.ofFloat(
                        button6,        // 움직일 대상
                        "translationY", // 애니메이션 속성
                        -500             // 속성 값
                );
                ObjectAnimator transX = ObjectAnimator.ofFloat(
                        button6,        // 움직일 대상
                        "translationX", // 애니메이션 속성
                        300             // 속성 값
                );
                ObjectAnimator rotate = ObjectAnimator.ofFloat(
                        button6,        // 움직일 대상
                        "rotation", // 애니메이션 속성
                        1440             // 속성 값
                );

                // 애니메이터 셋을 구성해서 실행
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(transX,transY,rotate);   // 개수 제한 없음
                animatorSet.setDuration(3000);             // 실행시간
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());   // 가속도
                animatorSet.start();
                break;
            case R.id.button6 :

                break;
        }
    }
}
