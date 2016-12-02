package com.bidchat.photopicker;

import android.content.Intent;
import android.widget.Toast;
import android.net.Uri;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import io.cordova.hellocordova.MainActivity;

import com.desmond.squarecamera.CameraActivity;
import com.desmond.squarecamera.ImageUtility;

import static android.app.Activity.RESULT_OK;

/**
 * This class echoes a string called from JavaScript.
 */
public class PhotoPicker extends CordovaPlugin {

    private final static int CAMERA_RQ = 6969;
    private CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
//            this.takephoto(message, callbackContext);
            return true;
        }
        if (action.equals("takePhoto")) {
            this.callbackContext = callbackContext;
            PluginResult pr = new PluginResult(PluginResult.Status.NO_RESULT);
            pr.setKeepCallback(true);
            callbackContext.sendPluginResult(pr);
            cordova.setActivityResultCallback(this);
            Intent startCustomCameraIntent = new Intent(cordova.getActivity(), CameraActivity.class);
            cordova.getActivity().startActivityForResult(startCustomCameraIntent, CAMERA_RQ);
            return true;
        }
        return false;
    }

    private void takephoto(CallbackContext callbackContext) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_RQ) {

            if (resultCode == RESULT_OK) {
                try {
                    Uri photoUri = data.getData();
                    this.callbackContext.success(photoUri.toString());
                }
                catch (Exception e)
                {
                    this.callbackContext.error("Cannot capture the image");
                }
            } else if(data != null) {
                this.callbackContext.error("Cannot capture the image");
            }
        }
    }
}
