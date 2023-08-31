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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class log_in_frag extends Fragment /*implements View.OnClickListener*/ {
    View view;

   // Button btnAdd;

    public static final String administrator_login = "admin";
    public static final String administrator_password = "admin123";
    EditText log_in_etLogin, log_int_etPassword;

    DBHelper dbHelper;

    public log_in_frag() {
        super(R.layout.log_in_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.log_in_fragment, container, false);

        // Инициализация DBHelper с использованием контекста активности
        dbHelper = new DBHelper(getContext());

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextFirst);
            textView.setText(bundle.getString("getDepositMoneyKey"));
        }

        // Инициализация кнопки и полей ввода
       // btnAdd = view.findViewById(R.id.btnAdd);
        log_in_etLogin = view.findViewById(R.id.log_in_etLogin);
        log_int_etPassword = view.findViewById(R.id.log_int_etPassword);
       // etPassword = view.findViewById(R.id.etPassword);

        // Установка обработчика кликов
       // btnAdd.setOnClickListener(this);

        //регистрация
        view.findViewById(R.id.log_in_btn_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_log_in_frag4_to_register_frag4);
            }
        });

        //вход в аккаунт
        view.findViewById(R.id.log_in_btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String login = log_in_etLogin.getText().toString();
                String password = log_int_etPassword.getText().toString();
                if (login.equals(administrator_login) && password.equals(administrator_password)) {
                    //вход в акк админа
                    Log.d("mLog","Админ топ кб ");
                    Log.d("mLog","Админ топ кб ");
                    Log.d("mLog","Админ топ кб ");
                    Log.d("mLog","Админ топ кб ");


                    Navigation.findNavController(view).navigate(R.id.action_log_in_frag4_to_admin_home_frag);

                } else {
                    //вход в акк пользователя
                    SQLiteDatabase database = dbHelper.getWritableDatabase();
                    Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                        int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                        int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                        int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
                        do {
                            //Поиск пользователя в бд
                            String name = cursor.getString(nameIndex);
                            String passwordDb = cursor.getString(passwordIndex);

                            if(login.equals(name) && password.equals(passwordDb)) {
                                Log.d("mLog", "Пользователь найден");
                                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                        ", name = " + cursor.getString(nameIndex) +
                                        ", email = " + cursor.getString(emailIndex) +
                                        ", password = " + cursor.getString(passwordIndex));

                                Log.d("mLog","холопы ");
                                Log.d("mLog","холопы ");
                                Log.d("mLog","холопы ");
                                Log.d("mLog","холопы ");
                                Navigation.findNavController(view).navigate(R.id.action_log_in_frag4_to_people_home_frag);

                            }
                        } while (cursor.moveToNext());
                    } else
                        Toast.makeText(getContext(), "Неправильный логин или пароль!", Toast.LENGTH_SHORT).show();

                        Log.d("mLog","Пользователь не найден");

                    cursor.close();

                    }


            }
        });



        return view;
    }

  /*  @Override
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
    */
}
