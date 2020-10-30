package com.projectlite.android.app

import android.app.Application
import cn.leancloud.AVLogger
import cn.leancloud.AVOSCloud

class MyApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        // 开启调试日志：在 AVOSCloud.initialize() 之前调用
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        //在应用发布之前，请关闭调试日志，以免暴露敏感数据。

        // 初始化：提供 this、App ID、绑定的自定义 API 域名作为参数
        AVOSCloud.initialize(
                this,
                "xCPMuwMtvrHTaRYE3sdnlBez-MdYXbMMI",
                "nJY5JvhpKI3Nkcob3IevMNr3"
        );
    }
}