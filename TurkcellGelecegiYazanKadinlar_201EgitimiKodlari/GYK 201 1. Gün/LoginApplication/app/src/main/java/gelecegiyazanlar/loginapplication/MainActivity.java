package gelecegiyazanlar.loginapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText kullaniciAdi, sifre;
    Button giris;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullaniciAdi = (EditText)findViewById(R.id.editTextKullanciadi);
        sifre = (EditText)findViewById(R.id.editTextSifre);
        giris = (Button)findViewById(R.id.buttonGiris);

        final String kullaniciadi = "kelebek";
        final String Ksifre = "efsane";

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(kullaniciAdi.getText().toString().equals("") && sifre.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Bütün alanları doldurun!", Toast.LENGTH_LONG).show();

                }
                else
                {
                    if(kullaniciAdi.getText().toString().equals(kullaniciadi) &&
                            sifre.getText().toString().equals(Ksifre))
                    {
                        Toast.makeText(MainActivity.this, "Tebrikler giriş yaptınız!", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,GirisActivity.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Kullanici adi veya şifre yanlış!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}
