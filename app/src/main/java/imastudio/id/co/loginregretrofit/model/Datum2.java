package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nandoseptianhusni on 9/9/17.
 */

public class Datum2 {


    @SerializedName("id_tracking")
    private String mIdTracking;
    @SerializedName("tracking_driver")
    private String mTrackingDriver;
    @SerializedName("tracking_lat")
    private String mTrackingLat;
    @SerializedName("tracking_lng")
    private String mTrackingLng;
    @SerializedName("tracking_status")
    private String mTrackingStatus;
    @SerializedName("tracking_waktu")
    private String mTrackingWaktu;

    public String getIdTracking() {
        return mIdTracking;
    }

    public void setIdTracking(String idTracking) {
        mIdTracking = idTracking;
    }

    public String getTrackingDriver() {
        return mTrackingDriver;
    }

    public void setTrackingDriver(String trackingDriver) {
        mTrackingDriver = trackingDriver;
    }

    public String getTrackingLat() {
        return mTrackingLat;
    }

    public void setTrackingLat(String trackingLat) {
        mTrackingLat = trackingLat;
    }

    public String getTrackingLng() {
        return mTrackingLng;
    }

    public void setTrackingLng(String trackingLng) {
        mTrackingLng = trackingLng;
    }

    public String getTrackingStatus() {
        return mTrackingStatus;
    }

    public void setTrackingStatus(String trackingStatus) {
        mTrackingStatus = trackingStatus;
    }

    public String getTrackingWaktu() {
        return mTrackingWaktu;
    }

    public void setTrackingWaktu(String trackingWaktu) {
        mTrackingWaktu = trackingWaktu;
    }
}
