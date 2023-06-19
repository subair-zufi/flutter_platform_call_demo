package com.example.method_call;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import android.util.Log;


public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.method_call/app_channel";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if(call.method.equals("openAndroid")) {
                                Log.d("TAG", "Hello, console!");
                                Intent intent = new Intent(MainActivity.this, AndroidPageActivity.class);
                                startActivity(intent);
                                result.success("null");
                            }
                            else {
                                Log.d("TAG", "Hello, console!!!");
                                result.notImplemented();
                            }
                        }
                );
    }
}