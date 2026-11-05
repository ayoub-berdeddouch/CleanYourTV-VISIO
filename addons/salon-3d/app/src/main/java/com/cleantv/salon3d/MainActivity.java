package com.cleantv.salon3d;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Keep screen on and hide system UI for full TV immersion
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);

        // Enable hardware acceleration layer
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.setBackgroundColor(0xFF080B10);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/salon.html");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            webView.evaluateJavascript("window.dispatchEvent(new KeyboardEvent('keydown', {'key': 'ArrowLeft'}));", null);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            webView.evaluateJavascript("window.dispatchEvent(new KeyboardEvent('keydown', {'key': 'ArrowRight'}));", null);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            webView.evaluateJavascript("window.dispatchEvent(new KeyboardEvent('keydown', {'key': 'ArrowUp'}));", null);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            webView.evaluateJavascript("window.dispatchEvent(new KeyboardEvent('keydown', {'key': 'ArrowDown'}));", null);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            webView.evaluateJavascript("window.dispatchEvent(new KeyboardEvent('keydown', {'key': 'Enter'}));", null);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) webView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) webView.onPause();
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
