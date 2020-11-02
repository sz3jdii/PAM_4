package com.example.pam2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class f4 extends Fragment {

    private fData fData;
    private Observer<Integer> numObserver;

    private EditText edit;
    private TextWatcher watcher;
    private boolean watcherSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_f4, container, false);

        edit = view.findViewById(R.id.editTextNumber);

        fData = new ViewModelProvider(requireActivity()).get(fData.class);

        numObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newInteger) {
                watcherSwitch = true;
                edit.setText(newInteger.toString());
            }
        };

        fData.counter.observe(getViewLifecycleOwner(), numObserver);

        watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(!watcherSwitch){

                    Integer i;
                    try{
                        i = Integer.parseInt( s.toString() );
                    } catch (NumberFormatException e){
                        i = fData.counter.getValue();
                    }
                    fData.counter.setValue(i);

                } else {
                    watcherSwitch = !watcherSwitch;
                }
            }
        };

        edit.addTextChangedListener(watcher);

        return view;
    }
}