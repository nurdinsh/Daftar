package com.example.nurdiansyah.daftar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    EditText tbhNama, tbhDetail, tbhPrioritas;
    Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().setTitle("Add Todo");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        //if (extras == null)
        //{
        //  return;
        //}

        dataHelper = new DataHelper(this);
        tbhNama = (EditText)findViewById(R.id.edtNama);
        tbhDetail = (EditText)findViewById(R.id.edtDetail);
        tbhPrioritas = (EditText)findViewById(R.id.edtPrioritas);
        tambah = (Button)findViewById(R.id.btnTambah);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                db.execSQL("insert into biodata(nama, detail, priority)values('" +
                        tbhNama.getText().toString() + "','" +
                        tbhDetail.getText().toString() + "','" +
                        tbhPrioritas.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }*/
}

