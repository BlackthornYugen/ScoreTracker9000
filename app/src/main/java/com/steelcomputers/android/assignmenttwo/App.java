package com.steelcomputers.android.assignmenttwo;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by black_000 on 2015-10-31.
 */
public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        try {
            Parse.enableLocalDatastore(this);
            ParseObject.registerSubclass(Player.class);
            Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_api_key));
            Log.i("App", "Parse library initialized");
        } catch (Exception e) {
            Log.e("App", "Failed to initialize parse library.", e);
        }

        try {
            Player.queryPlayers(false); // Load offline copy
            Log.i("App", "Loaded players from localdb");
        } catch (Exception e) {
            Log.e("App", "Failed to get players from localdb.", e);
        }
    }
}
