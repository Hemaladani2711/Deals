package com.example.deals;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Rangel on 3/3/2016.
 */
public class checknetwork {

    private ConnectivityManager cm;
    private NetworkInfo ani;

    public boolean isNetworkAvailable(Context context)
    {
        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ani = cm.getActiveNetworkInfo();

        if(ani != null && ani.isConnected())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
