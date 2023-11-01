package com.example.cobauts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Anda dapat menambahkan logika otentikasi di sini jika diperlukan
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Jika kedua input tidak kosong, lanjutkan ke aktivitas berikutnya
                    Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                } else {
                    // Tampilkan pesan kesalahan jika salah satu atau kedua input kosong
                    if (username.isEmpty()) {
                        usernameEditText.setError("Username Harap Diisi!");
                    }
                    if (password.isEmpty()) {
                        passwordEditText.setError("Harap Password Diisi!");
                    }
                }
            }
        });




    }
}
