package imastudio.id.co.loginregretrofit.model;

/**
 * Created by imastudio on 12/10/17.
 */

public class KontakEmergency {
    String id,namakontak,nohp;

    public KontakEmergency() {
    }

    public KontakEmergency(String id, String namakontak, String nohp) {
        this.id = id;
        this.namakontak = namakontak;
        this.nohp = nohp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamakontak() {
        return namakontak;
    }

    public void setNamakontak(String namakontak) {
        this.namakontak = namakontak;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
