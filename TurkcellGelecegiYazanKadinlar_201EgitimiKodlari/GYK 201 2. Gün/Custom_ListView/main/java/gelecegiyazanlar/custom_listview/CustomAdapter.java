package gelecegiyazanlar.custom_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Kisi> mKisiListesi;

    //Yapılandırıcı metot
    public CustomAdapter(Activity activity, List<Kisi> kisiler) {
        //XML'i alıp View'a yani görünüme çevirecek inflater'ı örnekleyelim.
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mKisiListesi = kisiler;
    }

    @Override
    public int getCount() {//int değer döner.ListView da gösterilecek satır sayısını belirtir.
        return mKisiListesi.size();
    }

    @Override
    public Kisi getItem(int position) { //Object değer döner. position ile belirtilen satıra denk düşen nesneyi döndürür.
        //şöyle de olabilir: public Object getItem(int position)
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }//long değer döndürmelidir.
    // Veri listesinde position ile sırası belirtilen satırın kimlik numarasını (id) döndürür.
    //Veritabanı ile çalışacaksak kullanılır.

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View değer döner. position ile sırası belirtilen satır için bir View döndürür.


        convertView = mInflater.inflate(R.layout.line_layout, null);//Oluşturduğumuz layout u tanımladığımız kısım
        TextView textView =
                (TextView) convertView.findViewById(R.id.isimsoyisim);//İsim ve soyisim için textView
        ImageView imageView =
                (ImageView) convertView.findViewById(R.id.simge);//Kişi resmi için ImageView

        Kisi kisi = mKisiListesi.get(position); // belirtilen satır ve pozisyondaki kişiyi getir

        textView.setText(kisi.getIsim()); //TextView e bulunan kişiyi yaz

        if (kisi.isKadinMi()) { //Kadın mı kontrolunu yap
            imageView.setImageResource(R.drawable.kadin_simge); //Eğer kadınsa kadın resmini set et
        }
        else { //Eğer erkek ise erkek resmini set et
            imageView.setImageResource(R.drawable.erkek_simge);
        }
        return convertView; //satırı döndür
    }
}