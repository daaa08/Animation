package com.example.da08.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class WindmillActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private RelativeLayout windMill;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windmill);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        windMill = (RelativeLayout) findViewById(R.id.windMill);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button.setOnClickListener(this);
        windMill.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button :
                Animation trans1 = AnimationUtils.loadAnimation(this, R.anim.trans1);
                Animation trans2 = AnimationUtils.loadAnimation(this, R.anim.trans2);
                Animation trans3 = AnimationUtils.loadAnimation(this, R.anim.trans3);
                Animation trans4 = AnimationUtils.loadAnimation(this, R.anim.trans4);
                Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_wind);

                button1.startAnimation(trans1);
                button2.startAnimation(trans2);
                button3.startAnimation(trans3);
                button4.startAnimation(trans4);
                windMill.startAnimation(rotate);
                break;
            case R.id.windMill :
                Intent intent = new Intent(this,AniActivity.class);
                startActivity(intent);
        }
    }
}
