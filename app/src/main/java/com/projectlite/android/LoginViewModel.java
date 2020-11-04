package com.projectlite.android;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.projectlite.android.app.MyApplication;

import org.jetbrains.annotations.NotNull;

public class LoginViewModel extends ViewModel {

//    private MutableLiveData<UserInfo>_user;
    private MutableLiveData<String>_phoneNumber;
    private MutableLiveData<String>_password;

    public MutableLiveData<String>getPhoneNumber() {
        if(_phoneNumber == null){
            _phoneNumber.setValue("");
        }
        return _phoneNumber;
    }

    public MutableLiveData<String>getPassword() {
        if(_password == null){
            _password.setValue("");
        }
        return _password;
    }




    public void Login(){
        Toast.makeText(MyApplication.context,getPassword().getValue(),Toast.LENGTH_SHORT).show();

//        AVUser.loginByMobilePhoneNumber(String.valueOf(getPhoneNumber()), String.valueOf(getPassword())).subscribe(new Observer<AVUser>() {
//            public void onSubscribe(Disposable disposable) {}
//            public void onNext(AVUser user) {
//                // 登录成功
//                Toast.makeText(MyApplication.context, "登陆成功"+user.getObjectId(),Toast.LENGTH_SHORT).show();
//            }
//            public void onError(Throwable throwable) {
//                Toast.makeText(MyApplication.context, "登陆失败",Toast.LENGTH_SHORT).show();
//            }
//            public void onComplete() {}
//        });
    }
}
