package com.projectlite.android.app

import android.app.Application
import cn.leancloud.AVOSCloud

class MyApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        // 提供 this、App ID、绑定的自定义 API 域名作为参数
        AVOSCloud.initializeSecurely(
            this,
            "w1vGF0c7QirnF5rFE0CXXFvs-gzGzoHsz",
            "https://please-replace-with-your-customized.domain.com"
        )
    }
}