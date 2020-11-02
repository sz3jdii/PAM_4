package com.example.pam2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class f3 extends Fragment {
    private fData fData;
    private Observer<Integer> numObserver;

    private TextView text;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f3, container, false);

        text = (TextView) view.findViewById(R.id.current);
        button = (Button) view.findViewById(R.id.decrease);

        fData = new ViewModelProvider(requireActivity()).get(fData.class);

        numObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                text.setText(integer.toString());
            }
        };

        fData.counter.observe(getViewLifecycleOwner(), numObserver);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer i = fData.counter.getValue();
                fData.counter.setValue(--i);
            }
        });

        return view;
    }
}