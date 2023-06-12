package com.example.biblio_p3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class admin_del_books_frag extends Fragment implements View.OnClickListener{


    View view;

    Button btnRead,btnAdd;

    EditText etBook, etAuthor, etSummary;

    DBHelper dbHelper;

    public admin_del_books_frag() {
        super(R.layout.admin_del_books_fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_del_books_fragment, container, false);

        // Инициализация DBHelper с использованием контекста активности
        dbHelper = new DBHelper(getContext());

        // Инициализация кнопки и полей ввода
        btnAdd = view.findViewById(R.id.btnDelBook);
        etBook = view.findViewById(R.id.etBookName);
        etAuthor = view.findViewById(R.id.etAuthorName);
        etSummary = view.findViewById(R.id.etSummuru);

        btnAdd.setOnClickListener(this);


        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        List<Item> itemList = new ArrayList<Item>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_thi);


        Cursor cursor = database.query(DBHelper.TABLE_BOOKS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int BookIndex = cursor.getColumnIndex(DBHelper.KEY_BOOK_NAME);
            int AuthorIndex = cursor.getColumnIndex(DBHelper.KEY_AUTHOR);
            int SummaryIndex = cursor.getColumnIndex(DBHelper.KEY_SUMMARY);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", Book = " + cursor.getString(BookIndex) +
                        ", Author = " + cursor.getString(AuthorIndex) +
                        ", Summary = " + cursor.getString(SummaryIndex));

                itemList.add(new Item( R.drawable.ultra, "№ " + cursor.getInt(idIndex) +
                        ". Книга: " + cursor.getString(BookIndex) +
                        " Автор: " + cursor.getString(AuthorIndex) +
                        " Краткое содержание : " + cursor.getString(SummaryIndex)));
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
        view.findViewById(R.id.btnBackToAdminHome2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправляем
             /*   Bundle bundle = new Bundle();
                bundle.putString("mainText", String.valueOf(((EditText) view
                        .findViewById(R.id.EditFirst))
                        .getText()));*/

                Navigation.findNavController(view).navigate(R.id.action_admin_del_books_frag_to_admin_home_frag);
            }
        });

        return view;
    }
    @Override
    public void onClick(View v) {
        String Book = etBook.getText().toString();
        String Author = etAuthor.getText().toString();
        String Summary = etSummary.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.btnDelBook:
                Toast.makeText(getContext(), "В разработке", Toast.LENGTH_SHORT).show();
/*
                contentValues.put(DBHelper.KEY_BOOK_NAME, Book);
                contentValues.put(DBHelper.KEY_AUTHOR, Author);
                contentValues.put(DBHelper.KEY_SUMMARY, Summary);
                database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
                break;
*/

        }
    }
}

