# cordova-plugin-streaming

This plugin provides an implementation of an Android service library which uses AAC Player. Ready to use Radio Player Service. (Background Player Service)


## Installation

    cordova plugin add cordova-plugin-streaming

## Supported Platforms

- Android


### Quick Example
...
onDeviceReady: function() {
```js
  navigator.RADIO.initialize(function(s) {
    console.log('SUCCESS navigator.RADIO.initialize');
  }, function(s) {
    console.log('ERROR navigator.RADIO.initialize');
  });

}
...


var url = 'http://hayatmix.net/;yayin.mp3.m3u';
navigator.RADIO.play(function(s) {
  if (s == 'STOPPED') {
    // the reproduction was stopped somewhere else. The notification?
  }
}, function(s) {
  console.log('ERROR navigator.RADIO.play');
}, url, 'My Stream Title', 'My Stream Subtitle');


navigator.RADIO.stop(function(s) {
  console.log('SUCCESS navigator.RADIO.stop');
}, function(s) {
  console.log('ERROR navigator.RADIO.stop');
});
```
