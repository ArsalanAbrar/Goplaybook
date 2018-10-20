package com.example.c_arsalanabrar.goplaybook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
LoginButton loginButton;
TextView textView;
CallbackManager callbackManager;
private ProfileTracker profileTracker;
private String firstName,lastName, email,birthday,gender;
private URL profilePicture;
    private String userId;
    private String TAG = "LoginActivity";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

context=this.getApplicationContext();
        loginButton=(LoginButton)findViewById(R.id.login_button);

        boolean loggedOut = AccessToken.getCurrentAccessToken() == null;
         if(!loggedOut){
             getcredentials(AccessToken.getCurrentAccessToken());
         }

        textView=(TextView)findViewById(R.id.text);
    callbackManager=CallbackManager.Factory.create();
        loginButton.setReadPermissions("email", "public_profile");
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    Log.e(TAG,object.toString());
                    Log.e(TAG,response.toString());

                    try {
                        userId = object.getString("id");
                        profilePicture = new URL("https://graph.facebook.com/" + userId + "/picture?width=500&height=500");
                        if(object.has("first_name"))
                            firstName = object.getString("first_name");
                        if(object.has("last_name"))
                            lastName = object.getString("last_name");
                        if (object.has("email"))
                            email = object.getString("email");
                        if (object.has("birthday"))
                            birthday = object.getString("birthday");
                        if (object.has("gender"))
                            gender = object.getString("gender");
                        Credentials.getInstance(context).Userid(userId);
                        Credentials.getInstance(context).email(email);
                        Credentials.getInstance(context).firstname(firstName);
                        Credentials.getInstance(getApplicationContext()).lastname(lastName);
                       Credentials.getInstance(getApplicationContext()).SaveprofileUrl(profilePicture.toString());
                        Intent main = new Intent(MainActivity.this,ProfileActivity.class);
                        main.putExtra("id",userId);
                        main.putExtra("birthday",birthday);
                        main.putExtra("gender",gender);
                        main.putExtra("email",email);
                        main.putExtra("name",firstName);
                        main.putExtra("surname",lastName);
                        main.putExtra("imageUrl",profilePicture.toString());
                        startActivity(main);
                        finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id, first_name, last_name, email, birthday, gender , location");
            request.setParameters(parameters);
            request.executeAsync();

        }

        @Override
        public void onCancel() {
textView.setText("login canceled");
        }

        @Override
        public void onError(FacebookException error) {
textView.setText("error");
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);

    }
    private void getcredentials(AccessToken currentAccessToken){
        GraphRequest request = GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.e(TAG,object.toString());
                Log.e(TAG,response.toString());

                try {
                    userId = object.getString("id");
                    profilePicture = new URL("https://graph.facebook.com/" + userId + "/picture?width=500&height=500");
                    if(object.has("first_name"))
                        firstName = object.getString("first_name");
                    if(object.has("last_name"))
                        lastName = object.getString("last_name");
                    if (object.has("email"))
                        email = object.getString("email");
                    if (object.has("birthday"))
                        birthday = object.getString("birthday");
                    if (object.has("gender"))
                        gender = object.getString("gender");

                    Intent main = new Intent(MainActivity.this,ProfileActivity.class);
                    main.putExtra("id",userId);
                    main.putExtra("birthday",birthday);
                    main.putExtra("gender",gender);
                    main.putExtra("email",email);
                    main.putExtra("name",firstName);
                    main.putExtra("surname",lastName);
                    main.putExtra("imageUrl",profilePicture.toString());
                    startActivity(main);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, first_name, last_name, email, birthday, gender , location");
        request.setParameters(parameters);
        request.executeAsync();

    }
}
