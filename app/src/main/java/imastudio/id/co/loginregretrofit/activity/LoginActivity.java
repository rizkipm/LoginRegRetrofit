package imastudio.id.co.loginregretrofit.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import imastudio.id.co.loginregretrofit.MainActivity;
import imastudio.id.co.loginregretrofit.R;
import imastudio.id.co.loginregretrofit.helper.MyFuction;
import imastudio.id.co.loginregretrofit.helper.SessionManager;
import imastudio.id.co.loginregretrofit.model.DataUser;
import imastudio.id.co.loginregretrofit.model.ModelUser;
import imastudio.id.co.loginregretrofit.network.MyRetrofitClient;
import imastudio.id.co.loginregretrofit.network.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends MyFuction {

    @BindView(R.id.edtusername)
    TextInputEditText edtusername;
    @BindView(R.id.edtpassword)
    TextInputEditText edtpassword;
    @BindView(R.id.regWonder)
    RadioButton regWonder;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.regBtnRegister)
    Button regBtnRegister;
    Dialog dialog;
    EditText nohp, nama;
    Button btnsimpan;
    String no_hp;
    String strlevel, strusername, strpassword;
    SessionManager sesi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //inisialisasi untuk alias sesi
        sesi = new SessionManager(LoginActivity.this);
        if (regWonder.isChecked()) {
            strlevel = "user";
        }
         }

    @OnClick({R.id.regWonder, R.id.btnLogin, R.id.regBtnRegister})
    public void onViewClicked(View view) {
        strusername =edtusername.getText().toString();
        strpassword =edtpassword.getText().toString();
        switch (view.getId()) {
            case R.id.regWonder:
                strlevel ="user";
                break;
            case R.id.btnLogin:
                if (TextUtils.isEmpty(strusername)) {
                    edtusername.setError("username tidak boleh kosong");
                } else if (TextUtils.isEmpty(strpassword)) {
                    edtpassword.setError("password tidak boleh kosong");
                } else if (strpassword.length() < 6) {
                    edtpassword.setError("minimal password 6 karakter");
                } else {
                    loginuser();
                }


                break;
            case R.id.regBtnRegister:
                myIntent(RegisterActivity.class);
                break;
        }
    }

    private void  loginuser() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                    && checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED
                  ) {
                requestPermissions(
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        110);


            }
          return;
        }
        final String deviceId = ((TelephonyManager) c
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        String id =null;
        if (deviceId != null) {
            id = deviceId;
        } else {
             id= Build.SERIAL;
        }
        showProgressDialog("proses login user");
        //String tampungdevice = HeroHelper.getDeviceId(LoginActivity.this);
        Toast.makeText(LoginActivity.this, "token"+id, Toast.LENGTH_SHORT).show();

        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        Call<ModelUser> modelUserCall = api.loginuser(
                strusername, strpassword ,id);
        modelUserCall.enqueue(new Callback<ModelUser>() {
            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                hideProgressDialog();
                boolean result =response.body().isLogin();
                String r =String.valueOf(result);
                if (r.equals("true")){
                    myToast("selamat anda berhasil login");
                    myIntent(MainActivity.class);
                    String iduser = String.valueOf(response.body().getData().getId());


                    //get token
                    //String token = response.body().getToken();
                    //get class data untuk ambil semua informasi user yang login
                    DataUser data = response.body().getData();
                    String tampungiduser = String.valueOf(response.body().getData().getId());
                 //   String tampungnamauser = response.body().getData().getEmail();
                    String tampungemail2 = data.getEmail();
                   // String tampunghp = data.ge();

                    //kita masukkan class sessionmanager biar kesimpan ke chace

                   // sesi.cerateLoginSession(token);
                    sesi.setIdUser(tampungiduser);
                    sesi.setEmail(tampungemail2);
//                    sesi.setNama(tampungnamauser);
//                    sesi.setPhone(tampunghp);



                    finish();
                }else{
                    myToast("maaf anda gagal login");
                }

            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                hideProgressDialog();
             //   myToast("gagal koneksi :");
                myToast("maaf anda gagal login");

            }
        });

    }

}
