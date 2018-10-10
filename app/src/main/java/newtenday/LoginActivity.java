package newtenday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cn.room.activity.R;

import newtenday.login.presenter.LoginPresenter;
import newtenday.login.presenter.LoginPresenterImp;
import newtenday.login.view.LoginView;

/**
 * Created by zhangpingzhen on 2018/10/10.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginView{
    private Button login_btn;
    private EditText login_name,login_pwd;
    String name,pwd;
    private LoginPresenterImp loginPresenterImp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        loginPresenterImp=new LoginPresenterImp(this);
        initView();

    }

    private void initView() {
        login_name=findViewById(R.id.login_name);
        login_pwd=findViewById(R.id.login_pwd);
        login_btn=findViewById(R.id.login_btn);
         name=login_name.getText().toString();
        pwd=login_pwd.getText().toString();
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                String name=login_name.getText().toString();
                String pwd=login_pwd.getText().toString();
                if(name.isEmpty()||pwd.isEmpty()){
                    Toast.makeText(this,"用户名和密码不能为空",Toast.LENGTH_LONG).show();
                }else{
                loginPresenterImp.userLogin(name,pwd);
                }
                break;
        }

    }



    @Override
    public void setPresenter(LoginPresenter presenter) {

    }

    @Override
    public void showLoginSuccessfulMeg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFailMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
