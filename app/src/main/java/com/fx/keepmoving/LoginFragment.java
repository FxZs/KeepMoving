package com.fx.keepmoving;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cn.room.activity.R;
import com.fx.modle.User;

/**
 * Created by zhangpingzhen on 2018/7/4.
 */

public class LoginFragment extends Fragment implements LoginContract.LoginView{
    private LoginContract.LoginPresenter loginPresenter;
    private EditText username;
    private EditText userpwd;
    private Button loginbtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.activity_main,container);
        username=root.findViewById(R.id.username);
        userpwd=root.findViewById(R.id.userpwd);
        loginbtn=root.findViewById(R.id.btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();
                user.setName(username.getText().toString());
                user.setPwd(userpwd.getText().toString());
                loginPresenter.login(user);
            }
        });
        return root;
    }

    @Override
    public void setPresenter(LoginContract.LoginPresenter presenter) {

    }

    @Override
    public void showLoginResult(String result) {

    }
}
