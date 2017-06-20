package gelecegiyazanlar.custom_listview;

public class Kisi {
    private String  isim;
    private boolean kadinMi;


    //Yapılandırıcıların (constructor) görevi, oluşturulan nesneyi ilk kullanıma hazırlamasıdır.
    public Kisi(String isim, boolean kadinMi) {
        super();
        this.isim = isim;
        this.kadinMi = kadinMi;
    }

    @Override
    public String toString() {
        return isim;
}

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public boolean isKadinMi() {
        return kadinMi;
    }

    public void setKadinMi(boolean kadinMi) {
        this.kadinMi = kadinMi;
    }
}
