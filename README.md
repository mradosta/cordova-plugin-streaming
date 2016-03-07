# cordova-plugin-streaming

This plugin provides an implementation of an Android service library which uses AAC Player. Ready to use Streaming Player Service. (Background Player Service).

Based in [RadioPlayerService](https://github.com/iammert/RadioPlayerService) is the solution for long time Android HTML5 Audio implementation takes before playing a streaming.



## Notifications
Nice notification to control the service when it's in running in the background

<img src="https://raw.githubusercontent.com/mradosta/cordova-plugin-streaming/master/screenshots/a.png" width="49%"/>
<img src="https://raw.githubusercontent.com/mradosta/cordova-plugin-streaming/master/screenshots/b.png" width="49%"/>



## Supported Platforms

- Android


## Supported URLs

- http://xxxx:1232
- http://xxxx/abc.pls
- http://xxxx/abc.ram
- http://xxxx/abc.wax
- http://xxxx/abc.m4a
- http://xxxx/abc.mp3


## Installation

    cordova plugin add cordova-plugin-streaming


### Quick Example
```js
...
onDeviceReady: function() {

  navigator.RADIO.initialize(function(s) {
    console.log('SUCCESS navigator.RADIO.initialize');
    if (s == 'STOPPED-FROM-NOTIFICATION') {
      // the reproduction was stopped from the notification
    } else if (s == 'STOPPED') {
      // the reproduction was stopped other than the notification
    }
  }, function(s) {
    console.log('ERROR navigator.RADIO.initialize');
  });

}
...


var url = 'http://hayatmix.net/;yayin.mp3.m3u';
navigator.RADIO.play(function(s) {
  console.log('SUCCESS navigator.RADIO.play');
}, function(s) {
  console.log('ERROR navigator.RADIO.play');
}, url, 'My Stream Title', 'My Stream Subtitle');


navigator.RADIO.stop(function(s) {
  console.log('SUCCESS navigator.RADIO.stop');
}, function(s) {
  console.log('ERROR navigator.RADIO.stop');
});
```


## Libraries Used ##

[AAC Decoder Library](https://github.com/vbartacek/aacdecoder-android)



### Special thanks
Gonzalo Martinez for his great and continuos contributions



License
--------


    Copyright 2016 Martin Radosta.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
