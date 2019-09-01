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


public class SuppliersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_suppliers,container,false);
        TextView t2 = (TextView)view.findViewById(R.id.t1_link);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t3 = (TextView)view.findViewById(R.id.t2_link);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}
