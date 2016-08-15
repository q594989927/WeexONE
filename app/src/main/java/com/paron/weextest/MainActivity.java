package com.paron.weextest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;
import com.paron.weextest.component.ScreenUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    WXSDKInstance mInstance;
    RelativeLayout viewGroup;
    private static final String DEFAULT_IP = "your_current_IP";
    private static String CURRENT_IP= DEFAULT_IP; // your_current_IP
//    private static final String WEEX_INDEX_URL = "http://"+CURRENT_IP+":12580/examples/build/index.js";
    private static final String WEEX_INDEX_URL = "file://assets/index.js";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewGroup = (RelativeLayout)findViewById(R.id.viewGroup);
        mInstance = new WXSDKInstance(this);
        mInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                if(viewGroup.getChildCount()>0){
                    viewGroup.removeAllViews();
                }
                viewGroup.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {

            }
        });
        renderPage(mInstance,getPackageName(), WXFileUtils.loadAsset("WeexOne/index.js",this),WEEX_INDEX_URL,null);
    }

    protected void renderPage(WXSDKInstance mInstance,String packageName,String template,String source,String jsonInitData){
        Map<String, Object> options = new HashMap<>();
        options.put(WXSDKInstance.BUNDLE_URL, source);
        mInstance.render(
                packageName,
                template,
                options,
                jsonInitData,
                ScreenUtil.getDisplayWidth(this),
                ScreenUtil.getDisplayHeight(this),
                WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mInstance!=null){
            mInstance.onActivityStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mInstance!=null){
            mInstance.onActivityResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mInstance!=null){
            mInstance.onActivityPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mInstance!=null){
            mInstance.onActivityStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mInstance!=null){
            mInstance.onActivityDestroy();
        }
    }
}
