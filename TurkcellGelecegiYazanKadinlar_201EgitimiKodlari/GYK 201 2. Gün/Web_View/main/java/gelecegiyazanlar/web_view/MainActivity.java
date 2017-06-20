package gelecegiyazanlar.web_view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView) findViewById(R.id.webview);//WebView tanımlamasını yapıyoruz
        webview.getSettings().setJavaScriptEnabled(true);//setJavaScriptEnable ile WebView üzerinden görüntülenecek
        // sayfalardaki Javascript kodlarının çalıştırılmasını onaylıyoruz.
        webview.loadUrl("https://gelecegiyazanlar.org"); //WebView de hangi adresi çalıştırmak istediğimizi belirtiyoruz.

        //webview.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; rv:15.0) Gecko/20120716 Firefox/15.0a2");

        final ProgressDialog progress = ProgressDialog.show(this, "Geleceği Yazanlar", "Yükleniyor...", true);
        progress.show();//Progres diyalog kullanıcıya sayfanın yüklenmesi anında bilgi vermek amacıyla kullanılır

        webview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {//onPageFinished metodu WebView
                // sayfayı yüklemeyi tamamladığında harekete geçen metot
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), "Sayfa yüklendi\n" + url, Toast.LENGTH_SHORT).show();//Sayfanın yüklendiğini
                // kullanıcıya bildiriyoruz
                progress.dismiss(); //Progress barın çalışmasını durdur anlamında
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                //Sayfa yüklenmesi sırasında bir hata oluşursa bu metod çalışıyor.
                //errorCode ve description parametreleri ile hatayının ne olduğunu görebiliriz.
                Toast.makeText(getApplicationContext(), "Bir hata oluştu\n" + description, Toast.LENGTH_SHORT).show();
                progress.dismiss(); //Progresbar ın çalışmasını durduruyoruz.
            }

        }




        );

    }

}
