package com.example.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GameService extends Service {

    private Binder mBinder = new Binder() {
        @Override
        protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
            if(code==1){
                String arg;
                arg=data.readString();
                int result=getGamePrice(arg);
                reply.writeInt(result);
                return true;
            }

            return super.onTransact(code, data, reply, flags);
        }

        public int getGamePrice(String name) {
            int price = -1;
            if ("逃生2".equals(name)) {
                price = 88;
            } else if ("饥荒".equals("name")) {
                price = 24;
            }
            return price;
        }
    };

    public GameService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}