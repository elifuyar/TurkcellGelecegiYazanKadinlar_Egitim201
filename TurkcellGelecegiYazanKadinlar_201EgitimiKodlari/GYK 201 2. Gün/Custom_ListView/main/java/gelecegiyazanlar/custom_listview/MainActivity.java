package gelecegiyazanlar.custom_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    final List<Kisi> kisiler=new ArrayList<Kisi>(); //Kişi listesi oluşturduk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kisiler.add(new Kisi("Ahmet Yılmaz", false)); //Listeye kişi ekledik
        kisiler.add(new Kisi("Ayşe Küçük", true));
        kisiler.add(new Kisi("Fatma Bulgurcu", true));
        kisiler.add(new Kisi("İzzet Altınmeşe", false));
        kisiler.add(new Kisi("Melek Subaşı", true));
        kisiler.add(new Kisi("Selim Serdilli",false));
        kisiler.add(new Kisi("Halil İbrahim",false));

        final ListView listemiz = (ListView) findViewById(R.id.liste);
        CustomAdapter adaptorumuz=new CustomAdapter(this, kisiler); //Custom Adapterımızı kişiler listesi ile bağladık
        listemiz.setAdapter(adaptorumuz); //listView e adapter ı set ettik

        listemiz.setOnItemClickListener(new OnItemClickListener() {//Listeye tıklanacağı zaman gerçekleşecek olaylar.
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {//
                Toast.makeText(getBaseContext(),
                        listemiz.getAdapter().getItem(position).toString(),//listemizdeki adapterın tıklanan pozisyonun getir.
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}