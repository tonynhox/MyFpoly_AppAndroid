package com.example.myfpolyapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfpolyapp.MainActivity;
import com.example.myfpolyapp.R;
import com.example.myfpolyapp.apis.APIInterfaces;
import com.example.myfpolyapp.apis.RetrofitClient;
import com.example.myfpolyapp.constants.BaseUrl;
import com.example.myfpolyapp.models.UserAPIModel;
import com.example.myfpolyapp.models.UserModel;
import com.example.myfpolyapp.models.UserRequestBody;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int RC_SIGN_IN = 9001;

    public static UserModel data;
    public static FirebaseAuth mAuth;
    public static GoogleSignInClient mGoogleSignInClient;

    private Button btnGoogle,btnCSDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnGoogle = findViewById(R.id.btnSignIn);
        btnCSDT = findViewById(R.id.edtCoSoSelect);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });

        btnCSDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                signOut();
            }
        });
    }


    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                Toast.makeText(this, "Google sign in failed", Toast.LENGTH_SHORT).show();
            }
        }
    }



    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // Get the ID token from the GoogleSignInAccount object and exchange it for a Firebase credential
        // using the GoogleAuthProvider class.
        mAuth.signInWithCredential(GoogleAuthProvider.getCredential(acct.getIdToken(), null))
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        String displayName = user.getDisplayName();
                        String avatarUrl = user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : "";
                        String userEmail = user.getEmail();
                        Toast.makeText(LoginActivity.this, displayName+"", Toast.LENGTH_SHORT).show();
                        fetchUser(userEmail,displayName,avatarUrl);

                        // Continue with your logic to handle the user data
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void fetchUser(String email,String name,String avatar) {
        String BASE_URL = BaseUrl.BASE_URL; // Replace with your actual base URL
        Retrofit retrofit = RetrofitClient.getClient(BASE_URL);
        UserRequestBody requestBody = new UserRequestBody(email, name, avatar);

        APIInterfaces apiService = retrofit.create(APIInterfaces.class);
        Call<UserAPIModel> call = apiService.createUser(requestBody);
        call.enqueue(new Callback<UserAPIModel>() {
            @Override
            public void onResponse(Call<UserAPIModel> call, Response<UserAPIModel> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
//                    LichHocAPIModel lichHocAPIModel = response.body();
//                    List<LichHocModel> lichHocList = lichHocAPIModel.getData();
                        UserAPIModel userAPIModel = response.body();
                        UserModel user = userAPIModel.getUserModel();
                        data = user; //?????????????????? bi nguuu à th lol android
                        Toast.makeText(LoginActivity.this, "User ID: " + data.getName(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                } else {
                    // Handle the error response here
                    Log.d("ok",response.toString());

                }

                }catch (Exception e){
                    Log.d("loi roi",e.toString());

                }


            }

            @Override
            public void onFailure(Call<UserAPIModel> call, Throwable t) {
                // Handle the failure
                Log.e("errorr: ", t.toString());
            }
        });
    }

}
