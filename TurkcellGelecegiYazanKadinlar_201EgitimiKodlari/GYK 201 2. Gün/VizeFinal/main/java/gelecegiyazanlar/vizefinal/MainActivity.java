package gelecegiyazanlar.vizefinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText vize_notu, final_notu;
    Button hesaplama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vize_notu = (EditText)findViewById(R.id.editText_vize);
        final_notu = (EditText)findViewById(R.id.editText_final);
        hesaplama = (Button)findViewById(R.id.button_Hesapla);

        hesaplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vize_sinavi  = (int) (Integer.parseInt(vize_notu.getText().toString()) * 0.4);
                int final_sinavi = (int) (Integer.parseInt(final_notu.getText().toString()) * 0.6);

                int sonuc = vize_sinavi + final_sinavi;

                if(sonuc >=90)
                {
                    Toast.makeText(getApplicationContext(),"Notunuz: AA-"+sonuc, Toast.LENGTH_LONG).show();
                }
                else if(sonuc<90 && sonuc>=85 )
                {
                    Toast.makeText(getApplicationContext(),"Notunuz: BA-"+sonuc, Toast.LENGTH_LONG).show();
                }
                else if(sonuc<85 && sonuc>=75)
                {
                    Toast.makeText(getApplicationContext(),"Notunuz: BB-"+sonuc, Toast.LENGTH_LONG).show();
                }
                else if(sonuc<75 && sonuc>=60)
                {
                    Toast.makeText(getApplicationContext(),"Notunuz: CC-"+sonuc, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Notunuz: FF-"+sonuc +" KALDINIZ", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
