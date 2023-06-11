package com.example.biblio_p3;
import android.content.ClipData;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class admin_list_peoples_frag extends Fragment{


    View view;

    Button btnRead,btnAdd;

    EditText etName, etEmail, etPassword;

    DBHelper dbHelper;

    public admin_list_peoples_frag() {
        super(R.layout.admin_list_peoples_fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_list_peoples_fragment, container, false);

        // Инициализация DBHelper с использованием контекста активности
        dbHelper = new DBHelper(getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();




        List<Item> itemList = new ArrayList<Item>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_thi);





        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", email = " + cursor.getString(emailIndex));

                itemList.add(new Item( R.drawable.ultra, "Пользователь " + cursor.getInt(idIndex) + ". Имя: " + cursor.getString(nameIndex) + " Почта: " + cursor.getString(emailIndex)));
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(getContext(), "Отсутствуют записи", Toast.LENGTH_SHORT).show();
            Log.d("mLog", "0 rows");
        }
        cursor.close();

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

