package com.zy.blogs.blogssample.activity;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;

import butterknife.Bind;

/**
 * <p/>
 * 作者：zhouyuan on  2016/10/11 17:45
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.webview)
    WebView webview;
    private String url;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_webview, -1, R.menu.menu_webview, 0);
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.icon_back_black);
//        toolbar_title.setTextColor(getResources().getColor(R.color.primary_text));
    }

    @Override
    protected void setUpData() {

        url = getIntent().getStringExtra(TYPE);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
        //强制在webview打开网页，防止使用系统默认的浏览器打开网页
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {
                //onReceivedTitle可以回调网页的title
                toolbar_title.setText(title);
                super.onReceivedTitle(view, title);
            }

        });
    }
}
