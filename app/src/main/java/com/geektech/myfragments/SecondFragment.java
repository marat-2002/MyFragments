package com.geektech.myfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SecondFragment extends Fragment {

private TextView second_textView;
private Button second_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        second_textView = view.findViewById(R.id.tv_second);
        Bundle bundle = getArguments();
        String data4 = bundle.getString("text");
        second_textView.setText(data4);
        second_button = view.findViewById(R.id.btn_second);
        second_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text",second_textView.getText().toString());
                Fragment fragment = new ThirdFragment();
                fragment.setArguments(bundle2);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.first_container,fragment).addToBackStack(null).commit();

            }
        });
    }
}