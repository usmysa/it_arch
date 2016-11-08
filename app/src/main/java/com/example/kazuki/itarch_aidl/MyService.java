package com.example.kazuki.itarch_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mStub;
    }

    private IMyAidl.Stub mStub = new IMyAidl.Stub()
    {
        public void PlayJazzMusic() throws RemoteException {
            MediaPlayer music = MediaPlayer.create(getApplicationContext(), R.raw.sample);
            music.start();
        }

        public void showToast() throws RemoteException {
            Toast toast = Toast.makeText(getApplicationContext(), "音楽を再生します！", Toast.LENGTH_SHORT);
            toast.show();
        }
    };
}