package imastudio.id.co.loginregretrofit.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;



import imastudio.id.co.loginregretrofit.MainActivity;
import imastudio.id.co.loginregretrofit.activity.LoginActivity;


public class SessionManager extends MyFuction {
    @VisibleForTesting

    /*variable sharepreference*/
            SharedPreferences pref;

    private static final String KEY_TOKEN = "tokenLogin";

    public SharedPreferences.Editor editor;
    public SessionManager sessionManager;

    /*mode share preference*/
    int mode = 0;

    /*nama dari share preference*/
    private static final String pref_name = "crudpref";

    /*kunci share preference*/
    private static final String is_login = "islogin";
    public static final String kunci_email = "keyemail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(getApplicationContext());
     //   setTheme(R.style.MyAppTheme);

    }
    public SessionManager(){

    }

    /*construktor*/
    public SessionManager(Context context) {
        /*mengakses class ini*/
        c = context;
        /*share preference dari class ini*/ /*(nama, mode)*/
        pref = context.getSharedPreferences(pref_name, mode);
        editor = pref.edit();
    }

    /*methode membuat session*/
    public void createSession(String email){
        /*login value menjadi true*/
        editor.putBoolean(is_login, true);
        /*memasukkan email ke dalam variable kunci email*/
        editor.putString(kunci_email, email);
        editor.commit();
    }



    public void checkLogin(){
        /*jika is_login = false*/
        if (!this.islogin()){
            /*pergi ke loginactivity*/
            Intent i = new Intent(c, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(i);
        }else {
            /*jika true, pergi ke mainactivity*/
            Intent i = new Intent(c, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(i);
        }
    }

    /*set is_login menjadi false*/
    public boolean islogin() {
        return pref.getBoolean(is_login, false);
    }





    public void logout(){

        /*hapus semua data dan kunci*/
        editor.clear();
        editor.commit();

        //gmail logout


        /*pergi ke loginactivity*/
        Intent i = new Intent(c, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(i);
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }



    public void setNama(String nama){
        editor.putString("user_name", nama);
        editor.commit();
    }
    public String getNama(){
        return pref.getString("user_name", "");
    }

    public void setIdRescue(String idRescue){
        editor.putString("id_rescue", idRescue);
        editor.commit();
    }
    public String getIdRescue(){
        return pref.getString("id_rescue", "");
    }
    public void setEmail(String email){
        editor.putString("user_email", email);
        editor.commit();
    }
    public String getEmail(){
        return pref.getString("user_email", "");
    }
    public void setPhone(String phone){
        editor.putString("user_phone", phone);
        editor.commit();
    }
    public String getPhone(){
        return pref.getString("user_phone", "");
    }
    public void setAlamat(String user_alamat){
        editor.putString("user_alamat", user_alamat);
        editor.commit();
    }
    public String getAlamat(){
        return pref.getString("user_alamat", "");
    }
    public void setIdUser(String iduser) {
        editor.putBoolean(is_login, true);
        editor.putString("iduser", iduser);
        editor.commit();
    }

    public String getIdUser() {
        return pref.getString("iduser", "");
    }


    public void setGcm(String gcm){
        editor.putString("gcm", gcm);
        editor.commit();
    }

    public void setUserTenant(String user_tenant){
        editor.putString("user_tenant", user_tenant);
        editor.commit();
    }
    public String getUserTenant(){
        return pref.getString("user_tenant", "");
    }

    public String getGcm(){
        return pref.getString("gcm", "");
    }

    //mendapatkan token
    public String getToken(){
        return pref.getString(KEY_TOKEN, "");
    }


}
