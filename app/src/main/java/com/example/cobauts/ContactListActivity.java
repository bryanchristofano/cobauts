package com.example.cobauts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        // Retrieve username from intent
        String username = getIntent().getStringExtra("username");

        // Display the contact list (ListView) and implement functionality to add transactions
        // TODO: Implement displaying contact list and adding transactions

        Button addTransactionButton = findViewById(R.id.addTransactionButton);
        addTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When "Tambah Transaksi" button is clicked, start AddTransactionActivity
                Intent intent = new Intent(ContactListActivity.this, AddTransactionActivity.class);
                startActivity(intent);
            }
        });
    }
}

