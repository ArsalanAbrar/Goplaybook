package com.example.c_arsalanabrar.goplaybook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProfileActivity extends AppCompatActivity {
    private String name, surname, imageUrl,userid,email;
    Button save,share,update;
    Intent shareintent;
    TextView vgender,vfield,vblood,vage,vnum,vstate,vemail,vadhar,sport,dob,gen,ph,bl,state;
    EditText gender,field,blood,age,num,stat;
    PlayerData playerData=new PlayerData();
    List<PlayerData>playerDataList=new ArrayList<PlayerData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView profileview=(ImageView)findViewById(R.id.profileImage);

        Bundle inBundle = getIntent().getExtras();
      //userid=Credentials.getuserid();
        userid=inBundle.getString("id");
   email=inBundle.getString("email");
        //   email=Credentials.email();
        name=inBundle.getString("name");
        surname=inBundle.getString("surname");
        imageUrl=inBundle.getString("imageUrl");
   //   name=Credentials.getfname();
    // surname=Credentials.getlname();
    //imageUrl=Credentials.getprofileUrl();
        update=(Button)findViewById(R.id.button6);
        Button logout=(Button)findViewById(R.id.logout);
        share=(Button)findViewById(R.id.button4);
        field=(EditText)findViewById(R.id.editText19);
        age=(EditText)findViewById(R.id.editText20);
        gender=(EditText)findViewById(R.id.editText21);
        num=(EditText)findViewById(R.id.editText22);
        blood=(EditText)findViewById(R.id.editText23);
        stat=(EditText)findViewById(R.id.editText24);
        vfield=(TextView)findViewById(R.id.textView5);
        vage=(TextView)findViewById(R.id.textView6);
        vgender=(TextView)findViewById(R.id.textView7);
        vblood=(TextView)findViewById(R.id.textView8);
        vnum=(TextView)findViewById(R.id.textView9);
        vstate=(TextView)findViewById(R.id.textView17);
        vemail=(TextView)findViewById(R.id.textView18);
        vadhar=(TextView)findViewById(R.id.textView);
        sport=(TextView)findViewById(R.id.textView19);
        dob=(TextView)findViewById(R.id.textView20);
        gen=(TextView)findViewById(R.id.textView21);
        ph=(TextView)findViewById(R.id.textView22);
        bl=(TextView)findViewById(R.id.textView23);
        state=(TextView)findViewById(R.id.textView24);
        save=(Button)findViewById(R.id.button3);

        String check=MyAppDatabse.getInstance(getApplicationContext()).dao().age(userid);
        if (check != null && !check.isEmpty()){
            ChangeInUi();

          }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num.getText().toString().length()==10){

                    savecredentials();
                    savedata();
                    save.setVisibility(View.GONE);
                    share.setVisibility(View.VISIBLE);
                    update.setVisibility(View.VISIBLE);
                    ChangeInUi();
                        }
                else{
Toast.makeText(ProfileActivity.this,"Please enter 10 digit number",Toast.LENGTH_SHORT).show();
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(ProfileActivity.this,adharview.class);
            i.putExtra("userid",userid);
            startActivity(i);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginManager.getInstance().logOut();
                    Intent login = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(login);
                    finish();

            }
        });

        TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
        nameView.setText("" + name + " " + surname);
        Picasso.with(ProfileActivity.this).load(imageUrl).into(profileview);

    }
    private void savecredentials(){
         String gen=gender.getText().toString().toUpperCase();
         String spo=field.getText().toString().toUpperCase();
         String blo=blood.getText().toString().toUpperCase();
         String  ag=age.getText().toString();
         String number=num.getText().toString();
         String address=stat.getText().toString().toUpperCase();
        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;
         playerData.setId(userid);
         playerData.setEmail(email);
         playerData.setAge(ag);
         playerData.setNum(number);
         playerData.setGender(gen);
         playerData.setField(spo);
         playerData.setAdharid(num);
         playerData.setBld(blo);
         playerData.setState(address);
         playerData.setFname(name);
         playerData.setSurname(surname);
         playerDataList.add(playerData);
    }
    private void savedata(){
        MyAppDatabse.getInstance(getApplicationContext()).dao().insertdata(playerDataList);
        Toast.makeText(this.getApplicationContext(),"save successfully",Toast.LENGTH_LONG).show();

    }
    private void ChangeInUi(){
        save.setVisibility(View.GONE);
        share.setVisibility(View.VISIBLE);
        update.setVisibility(View.VISIBLE);
        field.setVisibility(View.GONE);
        age.setVisibility(View.GONE);
        blood.setVisibility(View.GONE);
        num.setVisibility(View.GONE);
        stat.setVisibility(View.GONE);
        gender.setVisibility(View.GONE);
        sport.setVisibility(View.GONE);
        state.setVisibility(View.GONE);
        dob.setVisibility(View.GONE);
        ph.setVisibility(View.GONE);
        gen.setVisibility(View.GONE);
        bl.setVisibility(View.GONE);
        vnum.setVisibility(View.VISIBLE);
        vage.setVisibility(View.VISIBLE);
        vblood.setVisibility(View.VISIBLE);
        vgender.setVisibility(View.VISIBLE);
        vfield.setVisibility(View.VISIBLE);
        vstate.setVisibility(View.VISIBLE);
        vemail.setVisibility(View.VISIBLE);
        vadhar.setVisibility(View.VISIBLE);
        vfield.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().field(userid));
        vgender.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().genter(userid));
        vblood.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().blood(userid));
        vage.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().age(userid));
        vnum.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().number(userid));
        vstate.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().state(userid));
        vemail.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().email(userid));
        vadhar.setText(""+MyAppDatabse.getInstance(getApplicationContext()).dao().adhar(userid));
    }
}
