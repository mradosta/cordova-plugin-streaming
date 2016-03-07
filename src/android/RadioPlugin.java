package com.imsd.radio;


// rm -fr MyApp; cordova create MyApp; cd MyApp;  cordova platform add android; cordova plugin add ../cordova-plugin/;
//  cordova build android; adb install -r /Users/mradosta/htdocs/intertron/adv-sdk/MyApp/platforms/android/build/outputs/apk/android-debug.apk; adb logcat

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import java.util.List;

//import co.mobiwise.library.radio.RadioListener;
//import co.mobiwise.library.radio.RadioManager;



public class RadioPlugin extends CordovaPlugin implements RadioListener {

  private static final String LOG_TAG = "RadioPlugin";

  RadioManager mRadioManager = null;
  private CallbackContext connectionCallbackContext;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if ("initialize".equals(action)) {
      try {
        mRadioManager = RadioManager.with(this.cordova.getActivity());
        mRadioManager.registerListener(this);
        mRadioManager.setLogging(true);
        mRadioManager.connect();

        this.connectionCallbackContext = callbackContext;
        PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
        pluginResult.setKeepCallback(true);

        //callbackContext.success();
        return true;
      } catch (Exception e) {
        Log.e(LOG_TAG, "Exception occurred: ".concat(e.getMessage()));
        callbackContext.error(e.getMessage());
        return false;
      }


//    } else if ("onStop".equals(action)) {
//      this.connectionCallbackContext = callbackContext;
//      PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
//      pluginResult.setKeepCallback(true);

    } else if ("play".equals(action)) {
      mRadioManager.startRadio(args.getString(0), args.getString(1), args.getString(2));
      callbackContext.success();
      return true;

    } else if ("stop".equals(action)) {
      mRadioManager.stopRadio();
      callbackContext.success();
      return true;
    }

    Log.e(LOG_TAG, "Called invalid action: " + action);
    return false;
  }


  @Override
  public void onRadioLoading() {
    Log.e(LOG_TAG, "RADIO STATE : LOADING...");
  }


  @Override
  public void onRadioConnected() {
    /*
    PluginResult result = new PluginResult(PluginResult.Status.OK, "onRadioConnected");
    result.setKeepCallback(false);
    if (callbackContext != null) {
      callbackContext.sendPluginResult(result);
      callbackContext = null;
    }
    */
  }

  @Override
  public void onRadioStarted() {
    Log.e(LOG_TAG, "RADIO STATE : PLAYING...");
  }

  @Override
  public void onRadioStopped(boolean closedFromNotification) {
    Log.e(LOG_TAG, "RADIO STATE : STOPPED...");

    if (this.connectionCallbackContext != null) {

      //PluginResult result = new PluginResult(PluginResult.Status.OK, data);
      //result.setKeepCallback(false);
      //this.success(result, this.myCallbackId);
      PluginResult pluginResult = null;
      if (closedFromNotification) {
        pluginResult = new PluginResult(PluginResult.Status.OK, "STOPPED-FROM-NOTIFICATION");
      } else {
        pluginResult = new PluginResult(PluginResult.Status.OK, "STOPPED");
      }
      //pluginResult.setKeepCallback(false);
      pluginResult.setKeepCallback(true);
      this.connectionCallbackContext.sendPluginResult(pluginResult);
      //this.connectionCallbackContext = null;


      //this.success(result, this.myCallbackId);
    }

  }

  @Override
  public void onMetaDataReceived(String s, String s1) {
    //TODO Check metadata values. Singer name, song name or whatever you have.
  }


  @Override
  public void onError() {

  }

}
