package imastudio.id.co.loginregretrofit.network;

import com.imastudio.wonder.model.ModelAddkontak;
import com.imastudio.wonder.model.ModelCariPertolongan;
import com.imastudio.wonder.model.ModelCekStatus;
import com.imastudio.wonder.model.ModelDeleteKontak;
import com.imastudio.wonder.model.ModelKontak;
import com.imastudio.wonder.model.ModelKota;
import com.imastudio.wonder.model.ModelPertanyaan;
import com.imastudio.wonder.model.ModelProvinsi;
import com.imastudio.wonder.model.ModelRegisterUser;
import com.imastudio.wonder.model.ModelUpdateKontak;
import com.imastudio.wonder.model.ModelUser;
import com.imastudio.wonder.model.ModelVolunteer;
import com.imastudio.wonder.model.ResponseDaftar;
import com.imastudio.wonder.model.ResponseHistory;
import com.imastudio.wonder.model.ResponseInsertBooking;
import com.imastudio.wonder.model.ResponseRoute;
import com.imastudio.wonder.model.ResponseTracking;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Blackswan on 9/12/2017.
 */

public interface RestApi {


    @FormUrlEncoded
    @POST("add-contact")
    Call<ModelAddkontak> tambahkontaks(
            @Field("telp") String strtelp,
            @Field("nama") String strnama,
            @Field("user_id") String iduser

    );

    @FormUrlEncoded
    @POST("update-contact")
    Call<ModelUpdateKontak> updatekontaks(
            @Field("telp") String strtelp,
            @Field("nama") String strnama,
            @Field("kontak_id") String idkontak

    );

    @FormUrlEncoded
    @POST("delete-contact")
    Call<ModelDeleteKontak> deletekontaks(
            @Field("kontak_id") String idkontak

    );

    @FormUrlEncoded
    @POST("show-contact")
    Call<ModelKontak> getdatakontak(
            @Field("user_id") String struserid);


    @GET("get-prov")
    Call<ModelProvinsi> getProvinsi();

    @GET("get-kota")
    Call<ModelKota> getKota(@Query("prov_id") String provid);

    @FormUrlEncoded
    @POST("register")
    Call<ModelRegisterUser> registerUser(
            @Field("email") String stremail,
            @Field("password") String strpassword,
            @Field("level") String strlevel,
            @Field("nama") String strnama,
            @Field("no_ktp") String strnoktp,
            @Field("alamat") String stralamat,
            @Field("jk") String strjk,
            @Field("tgl_lahir") String strtgllahir,
            @Field("no_hp") String strnohp,
            @Field("agama") String stragama,
            @Field("foto") String strfoto,
            @Field("kota_id") String strkotaid,
            @Field("prov_id") String strprovid
    );

    @FormUrlEncoded
    @POST("login")
    Call<ModelUser> loginuser(
            @Field("email") String stremail,
            @Field("password") String strpassword,
            @Field("uuid") String struuid);

    @FormUrlEncoded
    @POST("find-rescue")
    Call<ModelCariPertolongan> caripertolongan(
            @Field("user_id") String struserid,
            @Field("lat") String strlat,
            @Field("lon") String strlon,
            @Field("catatan") String strcatatan);

    @FormUrlEncoded
    @POST("check-rescue")
    Call<ModelCekStatus> cekstatus(
            @Field("rescue_id") String strrescueid
    );


    @FormUrlEncoded
    @POST("cancel-rescue")
    Call<ResponseDaftar> cancelcaripertolongan(
            @Field("user_id") String user_id,
            @Field("rescue_id") String rescue_id);


    @FormUrlEncoded
    @POST("insert_booking")
    Call<ResponseInsertBooking> request_insertbooking(
            @Field("f_token") String token,
            @Field("f_device") String device,
            @Field("f_idUser") String iduser,
            @Field("f_latAwal") String latwal,
            @Field("f_lngAwal") String lattujuan,
            @Field("f_awal") String awal,
            @Field("f_latAkhir") String latakhir,
            @Field("f_lngAkhir") String lonakhir,
            @Field("f_akhir") String akhir,
            @Field("f_jarak") String jarak,
            @Field("f_tarif") String tarif


    );

    @FormUrlEncoded
    @POST("check_booking")
    Call<ResponseHistory> request_check(
            @Field("id_booking") String idbooking,
            @Field("f_token") String token,
            @Field("f_device") String device


    );


    @FormUrlEncoded
    @POST("cancel_booking")
    Call<ResponseDaftar> request_cancel(
            @Field("id_booking") String idbooking,
            @Field("f_token") String token,
            @Field("f_device") String device
    );

    @FormUrlEncoded
    @POST("post-pertanyaan")
    Call<ModelPertanyaan> request_pertanyaan(
            @Field("user_id") String userid,
            @Field("pertanyaan") String pertanyaan,
            @Field("judul") String judul,
            @Field("volentir_id") String volunteerid
    );


    @FormUrlEncoded
    @POST("get-volentir")
    Call<ModelVolunteer> getdatavolunteer(
            @Field("jenis_profesi") String idjenisprofesi
    );

    //tambhan request get posisi driver
    @FormUrlEncoded
    @POST("get_driver")
    Call<ResponseTracking> request_tracking(
            @Field("id") String iduser

    );

    @GET("json")
    Call<ResponseRoute> request_route(
            @Query("origin") String orgin,
            @Query("destination") String desti


    );

    @FormUrlEncoded
    @POST("get_booking")
    Call<ResponseHistory> request_history(
            @Field("f_idUser") String iduser,
            @Field("status") String status
    );


}
