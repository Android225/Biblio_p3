package com.example.biblio_p3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class second_frag extends Fragment {

    String TAG = "Life Cycle Fragments";
    View view;

    TextView loginText;

    public second_frag(){
        super(R.layout.second_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.second_fragment, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextSecond);
            textView.setText(bundle.getString("mainText"));
        }

        view.findViewById(R.id.contacts_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("loginText", String.valueOf(((EditText) view
                        .findViewById(R.id.login_text))
                        .getText()));
               // Navigation.findNavController(view).navigate(R.id.action_second_frag_to_third_frag, bundle);
            }
        });

        return view;
    }
}
