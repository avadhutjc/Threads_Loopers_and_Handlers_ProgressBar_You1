package com.masai.a1085aug_threads_loopers_and_handlers_progressbar_you1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class WorkerThread extends Thread {

    private final Handler mainHandler;

    public WorkerThread(Handler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        int progress = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress = progress + 10;
            Message message = Message.obtain();
            message.obj = progress;
            mainHandler.sendMessage(message);
        }
        Looper.loop();
    }
}
