package com.example.biblio_p3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class admin_home_frag extends Fragment {
    String TAG = "Life Cycle Fragments";
    View view;

    TextView loginText;

    public admin_home_frag(){
        super(R.layout.admin_home);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.admin_home, container, false);

      /*  Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextSecond);
            textView.setText(bundle.getString("mainText"));
        }*/

        view.findViewById(R.id.btnAdminHomeToLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Bundle bundle = new Bundle();
                bundle.putString("loginText", String.valueOf(((EditText) view
                        .findViewById(R.id.login_text))
                        .getText()));*/
                Navigation.findNavController(view).navigate(R.id.action_admin_home_frag_to_log_in_frag4);
            }
        });

        return view;
    }
}