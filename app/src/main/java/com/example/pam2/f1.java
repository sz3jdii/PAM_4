package com.example.pam2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class f1 extends Fragment {

    public interface onButtonClickListener {
        public void Shuffle();
        public void Clockwise();
        public void Hide();
        public void Restore();
    }

    private onButtonClickListener callback = null;

    public void setOnButtonClickListener(onButtonClickListener callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f1, container, false);

        Button shuffle = (Button) view.findViewById(R.id.shuffle);
        Button clockwise = (Button) view.findViewById(R.id.clockwise);
        Button hide = (Button) view.findViewById(R.id.hide);
        Button restore = (Button) view.findViewById(R.id.restore);

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) callback.Shuffle();
            }
        });

        clockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) callback.Clockwise();
            }
        });

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) callback.Hide();
            }
        });

        restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) callback.Restore();
            }
        });

        return view;
    }
}