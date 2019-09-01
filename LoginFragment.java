package com.kjhan.bharathdynamicslimited;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kjhan.bharathdynamicslimited.R;

import static com.kjhan.bharathdynamicslimited.R.layout.fragment_login;


public class LoginFragment extends Fragment {

    OnLoginVerificationListener loginVerificationListener;

    public interface OnLoginVerificationListener
    {
        public void onLoginVerify();
    }

     Button Login;
     EditText email;
     EditText password;
     FirebaseAuth mAuth;
     public LoginFragment()
     {

     }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(fragment_login, container, false);
        email=(EditText)view.findViewById(R.id.Email);
        password=(EditText)view.findViewById(R.id.Password);
        Login=(Button)view.findViewById(R.id.Loginbutton);
        mAuth=FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String emailverify=email.getText().toString();
                String passwordverify=password.getText().toString();
                if(emailverify.isEmpty()||passwordverify.isEmpty())
                    Toast.makeText(getActivity(),"The field(s)are empty.",Toast.LENGTH_SHORT).show();
                else {

                    mAuth.signInWithEmailAndPassword(emailverify, passwordverify)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        loginVerificationListener.onLoginVerify();
                                    } else {
                                        Toast.makeText(getActivity(), "Invalid email/password.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity=(Activity) context;
        try
        {
            loginVerificationListener = (OnLoginVerificationListener) activity;

        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"must implement OnLoginVerify...");
        }
    }
    @Override
    public void onResume()
    {
        super.onResume();
        email.setText("");
        password.setText("");
    }
}
