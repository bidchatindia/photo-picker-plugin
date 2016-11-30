var exec = require('cordova/exec');

exports.takePhoto = function(arg0, success, error) {
    exec(success, error, "PhotoPicker", "takePhoto", [arg0]);
};
