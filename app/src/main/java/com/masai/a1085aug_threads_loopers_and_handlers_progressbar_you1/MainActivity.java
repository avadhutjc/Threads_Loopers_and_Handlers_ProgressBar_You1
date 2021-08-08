package com.masai.a1085aug_threads_loopers_and_handlers_progressbar_you1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class MainActivity extends AppCompatActivity {
    //logt shortcut
    private static final String TAG = "MainActivity";
    public Button mBtn;
    private LinearProgressIndicator progressBar;
    int progress;
    private final Handler mainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            progress = (int) msg.obj;
            //progressBar.setProgress(progress);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //logd shortcut
        Log.d(TAG, "onCreate: 1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        WorkerThread workerThread = new WorkerThread(mainHandler);
        workerThread.start();

        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(progress);
            }
        });
    }
}