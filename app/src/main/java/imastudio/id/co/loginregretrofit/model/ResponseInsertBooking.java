
package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;


public class ResponseInsertBooking {

    @SerializedName("id_booking")
    private long mIdBooking;
    @SerializedName("msg")
    private String mMsg;
    @SerializedName("result")
    private String mResult;
    @SerializedName("tarif")
    private String mTarif;
    @SerializedName("waktu")
    private String mWaktu;

    public long getIdBooking() {
        return mIdBooking;
    }

    public void setIdBooking(long idBooking) {
        mIdBooking = idBooking;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public String getResult() {
        return mResult;
    }

    public void setResult(String result) {
        mResult = result;
    }

    public String getTarif() {
        return mTarif;
    }

    public void setTarif(String tarif) {
        mTarif = tarif;
    }

    public String getWaktu() {
        return mWaktu;
    }

    public void setWaktu(String waktu) {
        mWaktu = waktu;
    }

}
