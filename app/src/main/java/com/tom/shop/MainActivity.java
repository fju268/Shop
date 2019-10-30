package com.tom.shop;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView password;
    private Button button;
    private ImageView up;
    private ImageView mid;
    private ImageView down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.your_name);
        email = findViewById(R.id.your_email);
        password = findViewById(R.id.your_password);
        button = findViewById(R.id.regist);
        up = findViewById(R.id.imageView);
        mid = findViewById(R.id.imageView2);
        down = findViewById(R.id.imageView3);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

        public void sure(View view) {
        int name_length = name.getText().length();
        int password_length = password.getText().length();
        int email_length = email.getText().length();
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    check();
            }
        };
        if(name_length==0||password_length==0||email_length==0) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("註冊失敗")
                    .setMessage("資料不完整")
                    .setPositiveButton("OK",listener)
                    .show();
        }else{
            if (name_length < 3 && password_length < 8) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("註冊失敗")
                        .setMessage("your password: " + password.getText().toString() + "至少需要8個字" + "\n" +
                                "your name: " + name.getText().toString() + "至少需要3個字")
                        .setPositiveButton("Ok", listener)
                        .show();
            } else if (name_length < 3) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("註冊失敗")
                        .setMessage("your name: " + name.getText().toString() + "至少需要3個字")
                        .setPositiveButton("Ok", listener)
                        .show();
            } else if (password_length < 8) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("註冊失敗")
                        .setMessage("your password: " + password.getText().toString() + "至少需要8個字")
                        .setPositiveButton("Ok", listener)
                        .show();
            } else  {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("恭喜    註冊成功")
                        .setMessage("歡迎新的會員： " + name.getText().toString())
                        .setPositiveButton("OK", listener)
                        .show();
            }
        }

    }
    public void check() {
        /*
        String REGEX="^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        boolean i = email.getText().toString().matches(REGEX);
        if(i){
            mid.setImageResource(R.drawable.correct);
            mid.setVisibility(View.VISIBLE);
        }else{
            up.setImageResource(R.drawable.error);
            up.setVisibility(View.VISIBLE);
        }
        */
        if(email.getText().length()==0){
            mid.setImageResource(R.drawable.error);
            mid.setVisibility(View.VISIBLE);
        } else if(name.getText().length()!=0) {
            mid.setImageResource(R.drawable.correct);
            mid.setVisibility(View.VISIBLE);
        }
            if(name.getText().length()<3 ||name.getText().length()==0){
                up.setImageResource(R.drawable.error);
                up.setVisibility(View.VISIBLE);
            } else if(name.getText().length()>=3) {
                up.setImageResource(R.drawable.correct);
                up.setVisibility(View.VISIBLE);
            }
            if(password.getText().length()<8||password.getText().length()==0){
                down.setImageResource(R.drawable.error);
                down.setVisibility(View.VISIBLE);
            }else if(password.getText().length()>=8){
                down.setImageResource(R.drawable.correct);
                down.setVisibility(View.VISIBLE);
            }
        }





        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
