package com.example.biblio_p3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class people_home_frag extends Fragment {
    String TAG = "Life Cycle Fragments";
    View view;

    TextView loginText;

    public people_home_frag(){
        super(R.layout.people_home);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.people_home, container, false);

      /*  Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextSecond);
            textView.setText(bundle.getString("mainText"));
        }*/

        view.findViewById(R.id.btnBackToLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Bundle bundle = new Bundle();
                bundle.putString("loginText", String.valueOf(((EditText) view
                        .findViewById(R.id.login_text))
                        .getText()));*/
                 Navigation.findNavController(view).navigate(R.id.action_people_home_frag_to_log_in_frag4);
            }
        });

        //личный кабинет
        view.findViewById(R.id.btnPeopleCabinet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Вывод сообщения Toast
                Toast.makeText(getContext(), "В разработке", Toast.LENGTH_SHORT).show();

              /*  Bundle bundle = new Bundle();
                bundle.putString("loginText", String.valueOf(((EditText) view
                        .findViewById(R.id.login_text))
                        .getText()));*/
                //Navigation.findNavController(view).navigate(R.id.action_people_home_frag_to_log_in_frag4);
            }
        });
        //список прочитанного
        view.findViewById(R.id.btnPeopleListRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Вывод сообщения Toast
                Toast.makeText(getContext(), "В разработке", Toast.LENGTH_SHORT).show();

              /*  Bundle bundle = new Bundle();
                bundle.putString("loginText", String.valueOf(((EditText) view
                        .findViewById(R.id.login_text))
                        .getText()));*/
               // Navigation.findNavController(view).navigate(R.id.action_people_home_frag_to_log_in_frag4);
            }
        });

        //список доступной литературы
        view.findViewById(R.id.btnPeopleRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Вывод сообщения Toast
               // Toast.makeText(getContext(), "Литература", Toast.LENGTH_SHORT).show();

              /*  Bundle bundle = new Bundle();
                bundle.putString("loginText", String.valueOf(((EditText) view
                        .findViewById(R.id.login_text))
                        .getText()));*/
                 Navigation.findNavController(view).navigate(R.id.action_people_home_frag_to_people_book_list_frag);
            }
        });


        return view;
    }
}
