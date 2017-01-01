package com.example.hasee.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactsMessageActivity extends AppCompatActivity {
    private TextView nameEditText;
    private TextView mobileEdiText;
    private TextView qqEdiText;
    private TextView danweiEditText;
    private TextView addressEditText;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        //setTitle("联系人信息");
        nameEditText= (TextView) findViewById(R.id.name);
        mobileEdiText = (TextView) findViewById(R.id.mobile);
        qqEdiText= (TextView) findViewById(R.id.qq);
        danweiEditText = (TextView) findViewById(R.id.danwei);
        addressEditText= (TextView) findViewById(R.id.address);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserByID(id);
        nameEditText.setText("姓名："+user.getName());
        mobileEdiText.setText("电话："+user.getMobile());
        qqEdiText.setText("qq:"+user.getQq());
        danweiEditText.setText("单位："+user.getDanwei());
        addressEditText.setText("地址："+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

