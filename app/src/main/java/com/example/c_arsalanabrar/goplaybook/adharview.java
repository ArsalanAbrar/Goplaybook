package com.example.c_arsalanabrar.goplaybook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class adharview extends AppCompatActivity {
TextView pname,field,dob,gender,blood,phonenum,emai,state,goplaybookid;
ImageView pic,viewscreen;
Button goback,share;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adharview);
        viewscreen=(ImageView)findViewById(R.id.imageshare);
        cardView = (CardView) findViewById(R.id.cardview);
        goback = (Button) findViewById(R.id.button2);
        share = (Button) findViewById(R.id.button5);
        pic = (ImageView) findViewById(R.id.imageprofile);
        pname = (TextView) findViewById(R.id.textView3);
        field = (TextView) findViewById(R.id.field);
        blood = (TextView) findViewById(R.id.blood);
        dob = (TextView) findViewById(R.id.dob);
        gender = (TextView) findViewById(R.id.gender);
        phonenum = (TextView) findViewById(R.id.phone);
        emai = (TextView) findViewById(R.id.email);
        state = (TextView) findViewById(R.id.state);
        goplaybookid = (TextView) findViewById(R.id.aadhar);
        Bundle inBundle = getIntent().getExtras();
        final String userid=inBundle.getString("userid");
        final String fname = Credentials.getInstance(getApplicationContext()).getfname();
        final String lname = Credentials.getInstance(getApplicationContext()).getlname();
        final String profileurl = Credentials.getInstance(getApplicationContext()).getprofileUrl();

        final String email = Credentials.email();
        pname.setText("" + fname + " " + lname);
        emai.setText(email);
        Picasso.with(adharview.this).load(profileurl).into(pic);
        field.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().field(userid));
        dob.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().age(userid));
        gender.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().genter(userid));
        blood.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().blood(userid));
        phonenum.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().number(userid));
        state.setText(MyAppDatabse.getInstance(getApplicationContext()).dao().state(userid));
        goplaybookid.setText("" + MyAppDatabse.getInstance(getApplicationContext()).dao().adhar(userid));

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adharview.this, ProfileActivity.class);
                i.putExtra("id", userid);
                i.putExtra("email", email);
                i.putExtra("name", fname);
                i.putExtra("surname", lname);
                i.putExtra("imageUrl", profileurl);
                startActivity(i);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Bitmap b = null;
                share.setVisibility(View.INVISIBLE);
                goback.setVisibility(View.INVISIBLE);
                b = ScreenshotUtils.getScreenShot(cardView);
                share.setVisibility(View.VISIBLE);
                goback.setVisibility(View.VISIBLE);
                viewscreen.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.INVISIBLE);
                if (b != null) {
                    showScreenShotImage(b);
                    File saveFile = ScreenshotUtils.getMainDirectoryName(adharview.this);
                    File file = ScreenshotUtils.store(b, "screenshot" + ".jpg", saveFile);
                    shareScreenshot(file);//finally share screenshot
                } else {
                    //If bitmap is null show toast message
                    Toast.makeText(adharview.this, "failed", Toast.LENGTH_SHORT).show();

                }
*/         String n=pname.getText().toString();
           String f=field.getText().toString();
           String d=dob.getText().toString();
           String g=gender.getText().toString();
           String s=state.getText().toString();
           String p=phonenum.getText().toString();
           String b=blood.getText().toString();
           String i=String.valueOf(goplaybookid.getText().toString());
           String data=n+"\r\n"+f+"\r\n"+d+"\r\n"+g+"\r\n"+s+"\r\n"+p+"\r\n"+b+"\r\n"+i;
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, data);
                startActivity(Intent.createChooser(sharingIntent, "Share Text Using"));
                }

        });
    }
    private void showScreenShotImage(Bitmap b) {
        viewscreen.setImageBitmap(b);
    }

    private void shareScreenshot(File file) {
        Uri uri = Uri.fromFile(file);//Convert file path into Uri for sharing
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "adhar");
        intent.putExtra(Intent.EXTRA_STREAM, uri);//pass uri here
        startActivity(Intent.createChooser(intent, "screenshot"));





    }
}
