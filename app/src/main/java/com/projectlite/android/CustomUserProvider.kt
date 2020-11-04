package com.projectlite.android

import cn.leancloud.chatkit.LCChatKitUser
import cn.leancloud.chatkit.LCChatProfileProvider
import cn.leancloud.chatkit.LCChatProfilesCallBack
import java.util.*


//ChatKit 在设计上抽象出了一个「用户体系」的接口，需要开发者自己提供用户信息的获取方式。
// 该接口只有一个方法需要开发者实现：fetchProfiles

class CustomUserProvider private constructor() : LCChatProfileProvider {
    companion object {
        private var customUserProvider: CustomUserProvider? = null

        @get:Synchronized
        val instance: CustomUserProvider?
            get() {
                if (null == customUserProvider) {
                    customUserProvider = CustomUserProvider()
                }
                return customUserProvider
            }

        private val partUsers: MutableList<LCChatKitUser> =
            ArrayList()

        // 此数据均为 fake，仅供参考
        init {
            partUsers.add(
                LCChatKitUser(
                    "Tom",
                    "Tom",
                    "http://www.avatarsdb.com/avatars/tom_and_jerry2.jpg"
                )
            )
            partUsers.add(
                LCChatKitUser(
                    "Jerry",
                    "Jerry",
                    "http://www.avatarsdb.com/avatars/jerry.jpg"
                )
            )
            partUsers.add(
                LCChatKitUser(
                    "Harry",
                    "Harry",
                    "http://www.avatarsdb.com/avatars/young_harry.jpg"
                )
            )
            partUsers.add(
                LCChatKitUser(
                    "William",
                    "William",
                    "http://www.avatarsdb.com/avatars/william_shakespeare.jpg"
                )
            )
            partUsers.add(
                LCChatKitUser(
                    "Bob",
                    "Bob",
                    "http://www.avatarsdb.com/avatars/bath_bob.jpg"
                )
            )
        }
    }

    override fun fetchProfiles(
        list: List<String>,
        callBack: LCChatProfilesCallBack
    ) {
        val userList: MutableList<LCChatKitUser> =
            ArrayList()
        for (userId in list) {
            for (user in partUsers) {
                if (user.userId == userId) {
                    userList.add(user)
                    break
                }
            }
        }
        callBack.done(userList, null)
    }

    override fun getAllUsers(): List<LCChatKitUser> {
        return partUsers
    }
}
