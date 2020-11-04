package com.projectlite.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.projectlite.android.databinding.FragmentLoginPwdBinding;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel viewModel;                       //      声明viewModel实例
    FragmentLoginPwdBinding loginPwdBinding;        //      声明dataBinding实例

//    public static String PHONE_NUMBER = "";
//    public static String PASSWORD = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();   //      隐藏默认显示的标题栏

        viewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        ).get(LoginViewModel.class);//      获取viewModel实例引用

        loginPwdBinding = DataBindingUtil.setContentView(this, R.layout.fragment_login_pwd);    //      使用dataBinding的方式填充布局

//        viewModel.getPhoneNumber().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                loginPwdBinding.txtPhone.setText(s);
//            }
//        });
        viewModel.getPassword().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                loginPwdBinding.txtPassword.setText(s);
            }
        });

        loginPwdBinding.setData(viewModel);         //      关联dataBinding和viewModel
        loginPwdBinding.setLifecycleOwner(this);        //      设置dataBinding生命周期


    }

}