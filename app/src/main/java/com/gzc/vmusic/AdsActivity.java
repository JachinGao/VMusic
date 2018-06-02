package com.gzc.vmusic;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.gzc.vmusic.activities.MainActivity;

public class AdsActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ads);
        init();
    }

    private Handler handler = new Handler(this);

    private void init() {
        handler.sendEmptyMessageDelayed(0,2500);
    }

    @Override
    public boolean handleMessage(Message msg) {
        startActivity(new Intent(AdsActivity.this, MainActivity.class));
        finish();
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
        return false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
}
