package com.example.jkim.navigation;

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

public class CircleFragment extends Fragment {

    private EditText editText_radius;
    private double   radius;

    private TextView textView_area;

    private Button   button_calcarea;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate( R.layout.fragment_circle, container, false) ;

        editText_radius  =  rootView.findViewById(R.id.editText_radius);
        button_calcarea  = rootView.findViewById(R.id.button_calcarea);
        textView_area    = rootView.findViewById(R.id.textView_area);


        button_calcarea.setOnClickListener( new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                String radiusString = editText_radius.getText().toString();

                radius = Double.parseDouble(radiusString);
                double Area = radius*radius*Math.PI;

                textView_area.setText(String.format("%.2f", Area) );

            }
        } );

        return rootView;

    } // END public View onCreateView

} // END  public class CircleFragment

