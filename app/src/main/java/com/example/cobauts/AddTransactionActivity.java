package com.example.cobauts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddTransactionActivity extends AppCompatActivity {

    private EditText dateEditText, amountEditText, debitCreditEditText;
    private Button cancelButton, saveButton;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        dbHandler = new DbHandler(this);

        dateEditText = findViewById(R.id.dateEditText);
        amountEditText = findViewById(R.id.amountEditText);
        debitCreditEditText = findViewById(R.id.debitCreditEditText);
        cancelButton = findViewById(R.id.cancelButton);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTransaction();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void saveTransaction() {
        String date = dateEditText.getText().toString();
        String amount = amountEditText.getText().toString();
        String debitCredit = debitCreditEditText.getText().toString();

        // Create a Transaction object
        Transaction transaction = new Transaction(date, amount, debitCredit);

        // Add the transaction to the database
        dbHandler.addTransaction(transaction);

        // Show a toast message indicating success
        Context context = getApplicationContext();
        CharSequence text = "Transaction saved!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.d("SQLITE","Membaca isi database");
        List<Transaction> contacts = dbHandler.getAllTransactions();

        // Finish this activity and go back
        finish();
    }
}
