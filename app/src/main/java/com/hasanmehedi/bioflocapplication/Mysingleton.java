package com.hasanmehedi.bioflocapplication;

import android.app.VoiceInteractor;
import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class Mysingleton {
    private static Mysingleton mInstance;
    private RequestQueue mRequestQeu;
    private Context mCtx;

    public Mysingleton(Context mCtx) {
        this.mCtx = mCtx;
        mRequestQeu=getmRequestQeu();

    }
public RequestQueue getmRequestQeu(){
        if (mRequestQeu==null){
            Cache cache=new DiskBasedCache(mCtx.getCacheDir(),1024*1024);
            Network network =new BasicNetwork(new HurlStack());
            mRequestQeu =new RequestQueue(cache,network);
                    mRequestQeu= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
    return mRequestQeu;
}

public static synchronized Mysingleton getInstance(Context context){
        if (mInstance==null){
            mInstance =new Mysingleton(context);

        }
        return  mInstance;
}

public  <T> void addToRequestQueue(Request<T> request){
        mRequestQeu.add(request);
}
}
