package imastudio.id.co.parsingdataandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowData extends AppCompatActivity {

    TextView txtNama, txtEmail, txtPekerjaan, txtAlamat;

    String nNama, nEmail, nPekerjaan, nAlamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        settingView();

        //mengambil data yg sudah d put sebelumnya
        Intent b = getIntent();

        nNama = b.getStringExtra("nama");
        nEmail = b.getStringExtra("email");
        nPekerjaan = b.getStringExtra("pekerjaan");
        nAlamat = b.getStringExtra("alamat");

        //menampilkan data ke label
        txtNama.setText("Nama : " + nNama);
        txtEmail.setText("Email : " + nEmail);
        txtPekerjaan.setText("Pekerjaan : " + nPekerjaan);
        txtAlamat.setText("Alamat : " + nAlamat);


    }

    public void settingView(){
        txtNama = (TextView)findViewById(R.id.labelNama);
        txtEmail = (TextView)findViewById(R.id.labelEmail);
        txtPekerjaan = (TextView)findViewById(R.id.labelPekerjaan);
        txtAlamat = (TextView)findViewById(R.id.labelAlamat);
    }

}
