package in.sodevan.sqlphpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,username,userpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.username);
        userpass=(EditText)findViewById(R.id.userpass);
        String Name=name.getText().toString();
        String Username=username.getText().toString();
        String Userpass=userpass.getText().toString();
        String method="register";
        backgroundtask backgroundtask=new backgroundtask(this);
        backgroundtask.execute(method,Name,Username,Userpass);

    }


}
