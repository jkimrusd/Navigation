package com.example.jkim.navigation;


// 1. create a new java class (don't use the fragment wizard)
// Note: follow the naming scheme PurposeFragment (like MainActivity)
// 2. extend Fragment (THE SUPPORT VERSION)
// 3. With activities, we get an onCreate method already existing
// when we make them.
// With fragments, you have to do the Generate->Override Method to
// get onCreateView

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
import android.widget.Toast;

public class PythagFragment extends Fragment {

    private EditText editTextLegA;
    private EditText editTextLegB;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // the method comes with this return statement, but we get rid of it
        // because it defeats the purpose of what we're trying to do
        // we want to inflate our own layout and wire up its widgets
        // before returning it to whomever called onCreateView
        // return super.onCreateView(inflater, container, savedInstanceState);

        // inflate a view from our xml layout file
        View rootView = inflater.inflate(R.layout.fragment_pythag, container,
                false);
        // wire widgets
        editTextLegA = rootView.findViewById(R.id.edittext_leg_a);
        editTextLegB = rootView.findViewById(R.id.edittext_leg_b);
        buttonCalculate = rootView.findViewById(R.id.button_calculate);
        textViewResult = rootView.findViewById(R.id.textview_result);

        // TODO make a listener for the button to calculate the result
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String legAString = editTextLegA.getText().toString();
                String legBString = editTextLegB.getText().toString();

                // if(legAString.equals(""))
                // if(legAString.isEmpty())
//                if(legAString.length() == 0) {
//                    legAString = "0";
//                }
//                if(legBString.length() == 0) {
//                    legBString = "0";
//                }

                // check if the the string contains a legitimate double value
                if(legAString.isEmpty() || legBString.isEmpty() ||
                        legAString.equals(",") || legAString.equals(".") ||
                        legBString.equals(",") || legBString.equals(".")) {
                    Toast.makeText(getActivity(), "Please enter lengths for both legs",
                            Toast.LENGTH_LONG).show();
                } else {

                    double legA = Double.parseDouble(legAString);
                    double legB = Double.parseDouble(legBString);

                    // only convert positive doubles
                    if(legA <= 0 || legB <= 0) {
                        Toast.makeText(getActivity(), "Please enter a positive value", Toast.LENGTH_SHORT).show();
                    } else {
                        double hypotenuse = Math.sqrt(legA * legA + legB * legB);

                        // textViewResult.setText(""+hypotenuse);
                        textViewResult.setText(String.format("%.2f", hypotenuse));
                    }
                }
            }
        });



        // return the view we created
        return rootView;
    }
}