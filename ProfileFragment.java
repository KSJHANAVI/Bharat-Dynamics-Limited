package com.kjhan.bharathdynamicslimited;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class ProfileFragment extends Fragment {
    TextView textView,empname,empcontact,empadd,empdoj,empdep,empdes,empeid,empext,emploc,empema;
    ImageView Empimg;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase fdb;
   // String img;
   // URI uri;
    OnLogoutVerificationListener logoutVerificationListener;

    public interface OnLogoutVerificationListener
    {
        public void onLogoutVerify();
    }

    public ProfileFragment() {
        // Required empty public constructor
    }
    private Button Logout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        textView=view.findViewById(R.id.loginverify);
        Logout=view.findViewById(R.id.logoutbutton);
        empname=view.findViewById(R.id.dbname);
        empadd=view.findViewById(R.id.dbadd);
        empdes=view.findViewById(R.id.dbdes);
        empdep=view.findViewById(R.id.dbdep);
        empdoj=view.findViewById(R.id.dbdoj);
        empcontact=view.findViewById(R.id.dbcnt);
        empext=view.findViewById(R.id.dbext);
        empema=view.findViewById(R.id.dbema);
        empeid=view.findViewById(R.id.dbeid);
        emploc=view.findViewById(R.id.dbloc);
        Empimg=view.findViewById(R.id.empimg);

       // Empimg=view.findViewById(R.id.empimg);

        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        fdb=FirebaseDatabase.getInstance();
        DatabaseReference dataref=fdb.getReference().child("EmployeeProfiles").child(user.getUid());
       // textView.setText("Your UserID : "+user.getUid());
        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              String name=dataSnapshot.child("Name").getValue().toString();
              String UserID=dataSnapshot.child("UserID").getValue().toString();
              String eid=dataSnapshot.child("EmployeeId").getValue().toString();
               String des=dataSnapshot.child("Designation").getValue().toString();
               String dep=dataSnapshot.child("Department").getValue().toString();
               String loc =dataSnapshot.child("Location").getValue().toString();
               String doj=dataSnapshot.child("DOJ(ddmmyyyy)").getValue().toString();
               String ext=dataSnapshot.child("Extension").getValue().toString();
               String cnt=dataSnapshot.child("Contact").getValue().toString();
               String ema=dataSnapshot.child("Email").getValue().toString();
               String add=dataSnapshot.child("Address").getValue().toString();
               String img=dataSnapshot.child("picurl").getValue().toString();
              empname.setText(name);
              empeid.setText(eid);
              empdes.setText(des);
              empdep.setText(dep);
              emploc.setText(loc);
              empdoj.setText(doj);
              empext.setText(ext);
              empcontact.setText(cnt);
              empema.setText(ema);
              empadd.setText(add);
              textView.setText("User ID : "+ UserID);
           Picasso.with(getActivity()).load(img).into(Empimg);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(),"Unable to access data.",Toast.LENGTH_SHORT).show();
            }
        });



        Logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                FirebaseAuth.getInstance().signOut();
                logoutVerificationListener.onLogoutVerify();
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
            logoutVerificationListener = (OnLogoutVerificationListener) activity;

        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"must implement OnLogoutVerify...");
        }
    }
    @Override
    public void onResume()
    {
        super.onResume();
    }
}
