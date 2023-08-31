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
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class register_frag extends Fragment implements View.OnClickListener{
    View view;
    Button btnRead,btnAdd;
    EditText etName, etEmail, etPassword;
    DBHelper dbHelper;
    public register_frag(){
        super(R.layout.register_fragment);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.register_fragment, container, false);

        // Инициализация DBHelper с использованием контекста активности
        dbHelper = new DBHelper(getContext());

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextFirst);
            textView.setText(bundle.getString("getDepositMoneyKey"));
        }

        // Инициализация кнопки и полей ввода
        btnAdd = view.findViewById(R.id.btnAdd);
        btnRead = view.findViewById(R.id.btnRead);
        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);

        // Установка обработчика кликов
        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);

        view.findViewById(R.id.btn_back_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Bundle bundle = new Bundle();
                bundle.putString("mainText", String.valueOf(((EditText) view
                        .findViewById(R.id.EditFirst))
                        .getText()));
*/
                Navigation.findNavController(view).navigate(R.id.action_register_frag4_to_log_in_frag4);
            }
        });

        return view;
    }
    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_MAIL, email);
                contentValues.put(DBHelper.KEY_PASSWORD, password);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                    int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex) +
                                ", password = " + cursor.getString(passwordIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
                break;
        }
    }
}
