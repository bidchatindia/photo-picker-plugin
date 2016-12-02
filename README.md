# photo-picker-plugin
This will allow tho click or select photo from disk to cordova app. 
## Install

```
$ cordova plugin add --save https://github.com/rahul-bidchat/photo-picker-plugin.git
```

## Usage
To use this plugin we need to make the make use of the api call from the Cordova app that will launch the Image picker activity.
The image picker activity will allow the user to pick a new image from the storage or the Camera. 
A sucess callback will be given to user that will have the image path as the param.

##Example
```js
    cordova.plugins.PhotoPicker.takePhoto(function success(argument) {
        alert(argument);
    }, function error(argument) {
        alert(argument);
    });
```

## License

MIT © [Bidchat](https://github.com/bidchatindia)
