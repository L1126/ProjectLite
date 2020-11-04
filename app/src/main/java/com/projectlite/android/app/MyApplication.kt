package com.projectlite.android.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.provider.UserDictionary.Words.APP_ID
import cn.leancloud.AVLogger
import cn.leancloud.AVOSCloud
import cn.leancloud.chatkit.LCChatKit
import com.projectlite.android.CustomUserProvider

class MyApplication :Application(){

    private val _appId:String = "xCPMuwMtvrHTaRYE3sdnlBez-MdYXbMMI"
    private val _appKey:String  = "nJY5JvhpKI3Nkcob3IevMNr3"
    private val _serverUrl:String = "xCPMuwMt.api.lncldglobal.com"

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context=applicationContext

        // 开启调试日志：在 AVOSCloud.initialize() 之前调用
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        //在应用发布之前，请关闭调试日志，以免暴露敏感数据。

        // 初始化：提供 this、App ID、绑定的自定义 API 域名作为参数
        AVOSCloud.initialize(this, _appId, _appKey );



        LCChatKit.getInstance().profileProvider = CustomUserProvider.instance;
        LCChatKit.getInstance().init(applicationContext, _appId, _appKey,_serverUrl);

    }
}