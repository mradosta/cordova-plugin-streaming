package com.imsd.radio;

public interface RadioListener {

  void onRadioLoading();

  void onRadioConnected();

  void onRadioStarted();

  void onRadioStopped(boolean closedFromNotification);

  void onMetaDataReceived(String s, String s2);

  void onError();
}
