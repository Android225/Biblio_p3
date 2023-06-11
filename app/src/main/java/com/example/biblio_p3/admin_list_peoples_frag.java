package com.example.biblio_p3;
import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class admin_list_peoples_frag extends Fragment {

    View view;
    public admin_list_peoples_frag() {
        super(R.layout.admin_list_peoples_fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_list_peoples_fragment, container, false);

        List<Item> itemList = new ArrayList<Item>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_thi);

        for(int i = 0; i < 200; i++) {
            itemList.add(new Item( R.drawable.book, "book " + i));
        }

        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(getContext(), itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRecyclerView);

        //возвращаемся в admin_home
        view.findViewById(R.id.btnBackToAdminHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправляем
             /*   Bundle bundle = new Bundle();
                bundle.putString("mainText", String.valueOf(((EditText) view
                        .findViewById(R.id.EditFirst))
                        .getText()));*/

                Navigation.findNavController(view).navigate(R.id.action_admin_list_peoples_frag_to_admin_home_frag);
            }
        });


        return view;
    }
}