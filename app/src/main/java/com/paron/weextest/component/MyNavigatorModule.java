package com.paron.weextest.component;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;
import com.taobao.weex.utils.WXLogUtils;
import org.json.JSONObject;


public class MyNavigatorModule extends WXModule {
  private static final String INSTANCE_ID = "instanceId";
  private static final String TAG = "Navigator";
  private static final String WEEX = "com.paron.weextest.intent.category.WEEX";
  private static final String URL = "url";

  public MyNavigatorModule() {
  }

  @WXModuleAnno
  public void push(String param, String callbackId) {
    if(!TextUtils.isEmpty(param)) {
      if(WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().push(param)) {
        WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
        return;
      }

      try {
        JSONObject e = new JSONObject(param);
        String url = e.optString("url", "");
        if(!TextUtils.isEmpty(url)) {
          Uri rawUri = Uri.parse(url);
          String scheme = rawUri.getScheme();
          Uri.Builder builder = rawUri.buildUpon();
          if(TextUtils.isEmpty(scheme)) {
            builder.scheme("http");
          }

          Intent intent = new Intent("android.intent.action.VIEW", builder.build());
          intent.addCategory(WEEX);
          intent.putExtra("instanceId", this.mWXSDKInstance.getInstanceId());
          this.mWXSDKInstance.getContext().startActivity(intent);
          WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
        }
      } catch (Exception var9) {
        WXLogUtils.eTag("Navigator", var9);
        WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
      }
    }

    WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
  }

  @WXModuleAnno
  public void pop(String param, String callbackId) {
    if(WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().pop(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      if(this.mWXSDKInstance.getContext() instanceof Activity) {
        ((Activity)this.mWXSDKInstance.getContext()).finish();
      }

    }
  }

  @WXModuleAnno
  public void setNavBarRightItem(String param, String callbackId) {
    if(!TextUtils.isEmpty(param) && WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().setNavBarRightItem(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }

  @WXModuleAnno
  public void clearNavBarRightItem(String param, String callbackId) {
    if(WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().clearNavBarRightItem(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }

  @WXModuleAnno
  public void setNavBarLeftItem(String param, String callbackId) {
    if(!TextUtils.isEmpty(param) && WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().setNavBarLeftItem(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }

  @WXModuleAnno
  public void clearNavBarLeftItem(String param, String callbackId) {
    if(WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().clearNavBarLeftItem(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }

  @WXModuleAnno
  public void setNavBarMoreItem(String param, String callbackId) {
    if(!TextUtils.isEmpty(param) && WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().setNavBarMoreItem(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }

  @WXModuleAnno
  public void clearNavBarMoreItem(String param, String callbackId) {
    if(WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().clearNavBarMoreItem(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }

  @WXModuleAnno
  public void setNavBarTitle(String param, String callbackId) {
    if(!TextUtils.isEmpty(param) && WXSDKEngine.getActivityNavBarSetter() != null && WXSDKEngine.getActivityNavBarSetter().setNavBarTitle(param)) {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "WX_SUCCESS");
    } else {
      WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), callbackId, "MSG_FAILED");
    }
  }
}
