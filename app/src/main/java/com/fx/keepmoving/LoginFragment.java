package com.fx.keepmoving;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fx.modle.User;

/**
 * Created by Administrator on 2018/7/4.
 */

public class LoginFragment  extends Fragment implements LoginContract.LoginView{
    private LoginContract.LoginPresenter  mloginPresenter;
    private EditText usename;
    private EditText usepwd;
    private Button loginbtn;

    public static LoginFragment newInstance() {
        Bundle arguments = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void setPresenter(LoginContract.LoginPresenter presenter) {
        mloginPresenter=presenter;
    }

    @Override
    public void showLoginResult(String result) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.context_activity,container,false);
        setHasOptionsMenu(true);
        usename=root.findViewById(R.id.username);
        usepwd=root.findViewById(R.id.userpwd);
        loginbtn=root.findViewById(R.id.btn);
       loginbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        User user=new User();
        user.setName(usename.getText().toString());
        user.setPwd(usepwd.getText().toString());
        mloginPresenter.login(user);
    }
});
        return root;
    }
}
