package imastudio.id.co.parsingdataandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etEmail, etPekerjaan, etAlamat;
    Button btnKirimData, btnHapusData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memanggil method settingview
        settingView();

        btnKirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kirimData();
            }
        });

        btnHapusData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusData();
            }
        });

    }

    public void settingView(){
        etAlamat = (EditText)findViewById(R.id.etAlamat);
        etNama = (EditText)findViewById(R.id.etNamaLengkap);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPekerjaan = (EditText)findViewById(R.id.etPekerjaan);
        btnHapusData = (Button) findViewById(R.id.btnHapus);
        btnKirimData = (Button) findViewById(R.id.btnKrimData);
    }

    public void hapusData(){
        etAlamat.setText("");
        etEmail.setText("");
        etPekerjaan.setText("");
        etNama.setText("");
    }

    public void kirimData(){

        //mengambil nilai dari widget
        String nEmail = etEmail.getText().toString();
        String nNama = etNama.getText().toString();
        String nPekerjaan = etPekerjaan.getText().toString();
        String nAlamat = etAlamat.getText().toString();


        //pengecekan nilai kosong atau tidak
        if (nEmail.isEmpty()){
            etEmail.setError("Required");
        }else if(nNama.isEmpty()){
            etNama.setError("Required");
        }else if(nPekerjaan.isEmpty()){
            etPekerjaan.setError("required");
        }else if(nAlamat.isEmpty()){
            etAlamat.setError("Required");
        }else{
            //kondisi kalau widget tidak kosong
            Intent nData = new Intent(getApplicationContext(), ShowData.class);
            //proses penyimpanan nilai pada saat akan di krim ke kelas lain
            nData.putExtra("nama", etNama.getText().toString());
            nData.putExtra("email", etEmail.getText().toString());
            nData.putExtra("alamat", etAlamat.getText().toString());
            nData.putExtra("pekerjaan", etPekerjaan.getText().toString());
            startActivity(nData);
        }

    }

}
