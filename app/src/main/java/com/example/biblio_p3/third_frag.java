package com.example.biblio_p3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class third_frag extends Fragment {

    View view;

    public third_frag(){
        super(R.layout.third_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.third_fragment, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.text_third);
            textView.setText(bundle.getString("loginText"));
        }

        view.findViewById(R.id.button123).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("getDepositMoneyKey", String.valueOf(((EditText) view
                        .findViewById(R.id.depositmoney))
                        .getText()));
             //   Navigation.findNavController(view).navigate(R.id.action_third_frag_to_first_frag,bundle);
            }
        });

        return view;
    }
}