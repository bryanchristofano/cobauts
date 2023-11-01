package com.example.cobauts;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.ArrayList;



public class ContactListActivity extends AppCompatActivity {
    private ListView contactListView;
    private Button addTransactionButton;
    private String username;
    private String password;
    private List<Transaction> transactionList;
    private TransactionListAdapter transactionListAdapter;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");

        contactListView = findViewById(R.id.contactListView);
        addTransactionButton = findViewById(R.id.addTransactionButton);

        dbHandler = new DbHandler(ContactListActivity.this);

        transactionList = new ArrayList<>();

        // Mengambil data transaksi dari database
        transactionList = dbHandler.getAllTransactions();

        transactionListAdapter = new TransactionListAdapter(this, transactionList);
        contactListView.setAdapter(transactionListAdapter);

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

