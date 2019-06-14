package testapp.hzh.jstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setSupportZoom(false);
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new DemoJavaScriptInterface(),"demo");

        webView.loadUrl("file:///android_asset/test.html");
    }

    public void myClick(View view) {
        //调用js中的方法
        webView.loadUrl("javascript:callHello()");
    }

    final class DemoJavaScriptInterface{

        @JavascriptInterface
        public void callHello(){
            Toast.makeText(MainActivity.this,"hello !!!",Toast.LENGTH_SHORT).show();
        }

    }
}
