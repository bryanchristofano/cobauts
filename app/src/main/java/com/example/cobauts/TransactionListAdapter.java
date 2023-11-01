package com.example.cobauts;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.util.List;

public class TransactionListAdapter extends BaseAdapter {
    private Context context;
    private List<Transaction> transactionList;

    public TransactionListAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    @Override
    public int getCount() {
        return transactionList.size();
    }

    @Override
    public Object getItem(int position) {
        return transactionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Jika convertView belum ada, inflate layout item kustom
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_transaction_list_item, parent, false);
        }

        // Dapatkan objek Transaction yang sesuai dengan posisi saat ini
        Transaction transaction = transactionList.get(position);

        // Isi tampilan item dengan data dari objek Transaction
        TextView dateTextView = convertView.findViewById(R.id.dateTextView);
        TextView amountTextView = convertView.findViewById(R.id.amountTextView);
        TextView debitCreditTextView = convertView.findViewById(R.id.debitCreditTextView);

        dateTextView.setText("Tanggal: " + transaction.getDate());
        amountTextView.setText("Jumlah: " + transaction.getAmount());
        debitCreditTextView.setText("Debet/Kredit: " + transaction.getDebitCredit());

        return convertView;
    }
}