package com.kjhan.bharathdynamicslimited;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kjhan.bharathdynamicslimited.R;


public class CareersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_careers,container,false);
        TextView t1 = (TextView)view.findViewById(R.id.careerlink1);
        t1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t2 = (TextView)view.findViewById(R.id.careerlink2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t3 = (TextView)view.findViewById(R.id.careerlink3);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t4 = (TextView)view.findViewById(R.id.careerlink4);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t5 = (TextView)view.findViewById(R.id.careerlink5);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t6 = (TextView)view.findViewById(R.id.careerlink6);
        t6.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t7 = (TextView)view.findViewById(R.id.careerlink7);
        t7.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t8 = (TextView)view.findViewById(R.id.careerlink8);
        t8.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t9 = (TextView)view.findViewById(R.id.careerlink9);
        t9.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t10 = (TextView)view.findViewById(R.id.careerlink10);
        t10.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}
