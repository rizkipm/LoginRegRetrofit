package imastudio.id.co.loginregretrofit.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import imastudio.id.co.loginregretrofit.R;
import imastudio.id.co.loginregretrofit.helper.MyConstant;
import imastudio.id.co.loginregretrofit.helper.MyFuction;
import imastudio.id.co.loginregretrofit.model.DataKota;
import imastudio.id.co.loginregretrofit.model.DataProvinsi;
import imastudio.id.co.loginregretrofit.model.ModelKota;
import imastudio.id.co.loginregretrofit.model.ModelProvinsi;
import imastudio.id.co.loginregretrofit.model.ModelRegisterUser;
import imastudio.id.co.loginregretrofit.network.MyRetrofitClient;
import imastudio.id.co.loginregretrofit.network.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends MyFuction {

    private static final int STORAGE_PERMISSION_CODE = 22;
    @BindView(R.id.imgupload)
    ImageView imgupload;
    @BindView(R.id.edtidpolisi)
    EditText edtidpolisi;
    @BindView(R.id.edtnama)
    EditText edtnama;
    @BindView(R.id.edtalamat)
    EditText edtalamat;
    @BindView(R.id.edttgllahir)
    EditText edttgllahir;
    @BindView(R.id.spinagama)
    Spinner spinagama;
    @BindView(R.id.edtnotelp)
    EditText edtnotelp;
    @BindView(R.id.edtnoktp)
    EditText edtnoktp;
    @BindView(R.id.spinprovinsi)
    Spinner spinprovinsi;
    @BindView(R.id.spinkota)
    Spinner spinkota;
    @BindView(R.id.edtusername)
    EditText edtusername;
    @BindView(R.id.edtpassword)
    EditText edtpassword;
    @BindView(R.id.edtpasswordconfirm)
    EditText edtpasswordconfirm;
    @BindView(R.id.btnregister)
    Button btnregister;
    String stremail, strpassword, strconpassword, strlevel, strnama, strno_ktp, stralamat, strjk, strtgl_lhr, strno_hp, stragama, strfoto, strkota_id, strprov_id;
    String jenkel[] = {"laki-laki", "perempuan"};
    String agama[] = {"ISLAM", "KRISTEN", "KATHOLIK", "BUDHA", "Lainnya"};
    @BindView(R.id.spinjenkel)
    Spinner spinjenkel;
    private List<DataProvinsi> lstdataprov;
    private List<DataKota> lstdatakota;
    String[] vhurufawal;
    String strpath;
    Uri filepath;
    String striduser;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        strlevel = "register_volentir";
        strfoto = "rizki.jpg";
        requeststoragepermission();
        ArrayAdapter adapter = new ArrayAdapter(c, android.R.layout.simple_spinner_item, jenkel);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinjenkel.setAdapter(adapter);
        spinjenkel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strjk = jenkel[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter adapteragama = new ArrayAdapter(c, android.R.layout.simple_spinner_item, agama);
        adapteragama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinagama.setAdapter(adapteragama);
        spinagama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stragama = agama[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getdataprovinsi();

    }

    private void requeststoragepermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                myToast("Permission granted now you can read the storage");
            } else {
                //Displaying another toast if permission is not granted
                myToast("Oops you just denied the permission");
            }
        }


    }

    private void getdataprovinsi() {
//        final ProgressDialog dialog =ProgressDialog.show(c,
//                "process getdata kecematan user","harap bersabar");

        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        Call<ModelProvinsi> modelprovinsi = api.getProvinsi();
        modelprovinsi.enqueue(new Callback<ModelProvinsi>() {
            @Override
            public void onResponse(Call<ModelProvinsi> call, Response<ModelProvinsi> response) {
                lstdataprov = new ArrayList<DataProvinsi>();

                lstdataprov = response.body().getData();
                final String[] items = new String[lstdataprov.size()];
                final String[] itemsnama = new String[lstdataprov.size()];

                //      Toast.makeText(getApplicationContext(), " banyak button" + Integer.toString(lstdatabutton.size()), Toast.LENGTH_LONG).show();

                for (int i = 0; i < lstdataprov.size(); i++) {
                    //Storing names to string array
                    items[i] = lstdataprov.get(i).getIdProv().toString();
                    itemsnama[i] = lstdataprov.get(i).getNama().toString();
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, itemsnama);
                spinprovinsi.setAdapter(adapter);

                strprov_id = items[0].toString();
                //   getDatakelurahan();
                spinprovinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //cara 1 untuk menampilakan brdasarkan nama
                        strprov_id = parent.getItemAtPosition(position).toString();
                        //tvhargajual.setText("");
                        //cara 2 untuk menampilkan brdasarkan posisi
                        strprov_id = items[position];

                        getDatakota();
                        //  if(selectedItem.equals("Add new category"))
                        // {
                        // do your stuff
                        // }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });

            }

            @Override
            public void onFailure(Call<ModelProvinsi> call, Throwable t) {

            }
        });
    }

    private void getDatakota() {
//        final ProgressDialog dialog =ProgressDialog.show(c,
//                "process getdata kecematan user","harap bersabar");

        String idprov = strprov_id.toString();

        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        Call<ModelKota> modelkota = api.getKota(idprov);
        modelkota.enqueue(new Callback<ModelKota>() {
            @Override
            public void onResponse(Call<ModelKota> call, Response<ModelKota> response) {
                lstdatakota = response.body().getData();

                String[] items = new String[lstdatakota.size()];
                vhurufawal = new String[lstdatakota.size()];

                //          Toast.makeText(getApplicationContext(), "sub button banyak " + Integer.toString(lstdatasubbutton.size()), Toast.LENGTH_LONG).show();

                for (int i = 0; i < lstdatakota.size(); i++) {
                    //Storing names to string array
                    // items[i] = lstdatagamesnilai.get(i).getnamabarang().toString();
                    items[i] = String.valueOf(lstdatakota.get(i).getId());
                    vhurufawal[i] = lstdatakota.get(i).getNama().toString();

                }

                Toast.makeText(RegisterActivity.this, "" + items, Toast.LENGTH_SHORT).show();
                strkota_id = items[0].toString();

                /// getDataGamesNilai();

                ArrayAdapter adapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, vhurufawal);
                spinkota.setAdapter(adapter);
                spinkota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //strnamagames = parent.getItemAtPosition(position).toString();
                        strkota_id = String.valueOf(lstdatakota.get(position).getId());
                        //informasi.setText(lstdatakota.get(position).getNama().toString());
                        //  strnilaigames = lstdatagamesnilai.get(position).gethargabeli().toString();
                        //  strbayar = lstdatagamesnilai.get(position).gethargajual().toString();
                        //  tvbayardeposit.setText("IDR " + strbayar + "  ");

                        // tvhargajual.setText("Rp " + strbayar);
                        //  if(selectedItem.equals("Add new category"))
                        // {
                        // do your stuff
                        // }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<ModelKota> call, Throwable t) {

            }
        });
    }

    @OnClick({R.id.imgupload, R.id.btnregister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgupload:
                showfilechooser(MyConstant.REQ_FILE_CHOOSE);
                break;
            case R.id.btnregister:
                strnama = edtnama.getText().toString();
                stralamat = edtalamat.getText().toString();
                strno_hp = edtnotelp.getText().toString();
                strno_ktp = edtnotelp.getText().toString();
                strtgl_lhr = edttgllahir.getText().toString();
                stremail = edtusername.getText().toString();
                strpassword = edtpassword.getText().toString();
                strconpassword = edtpasswordconfirm.getText().toString();
                if (TextUtils.isEmpty(strnama)) {
                    edtnama.setError("nama tidak boleh kosong");
                    edtnama.requestFocus();
                    myanimation(edtnama);
                } else if (TextUtils.isEmpty(stralamat)) {
                    edtalamat.requestFocus();
                    edtalamat.setError("alamt tidak boleh kosong");
                    myanimation(edtalamat);
                } else if (TextUtils.isEmpty(strno_hp)) {
                    edtnotelp.requestFocus();
                    myanimation(edtnotelp);
                    edtnotelp.setError("no hp tidak boleh kosong");
                } else if (TextUtils.isEmpty(stremail)) {
                    edtusername.requestFocus();
                    myanimation(edtusername);
                    edtusername.setError("email tidak boleh kosong");
                } else if (TextUtils.isEmpty(strpassword)) {
                    edtpassword.requestFocus();
                    myanimation(edtpassword);
                    edtpassword.setError("password tidak boleh kosong");
                } else if (strpassword.length() < 6) {
                    myanimation(edtpassword);
                    edtpassword.setError("password minimal 6 karakter");
                } else if (TextUtils.isEmpty(strconpassword)) {
                    edtpasswordconfirm.requestFocus();
                    myanimation(edtpasswordconfirm);
                    edtpasswordconfirm.setError("password confirm tidak boleh kosong");
                } else if (!strpassword.equals(strconpassword)) {
                    edtpasswordconfirm.requestFocus();
                    myanimation(edtpasswordconfirm);
                    edtpasswordconfirm.setError("password tidak sama");
                } else if (imgupload.getDrawable() == null) {
                    myToast("gambar harus dipilih");
                } else {

                    registeruser();
//                    insertphotouser();
                }

                break;
        }
    }

    private void insertphotouser() {
        //mengambil path dari gmbar yang d i upload
        try {
            strpath = getPath(filepath);
            ModelRegisterUser registerUser = new ModelRegisterUser();
            striduser = String.valueOf(registerUser.getData().getId());
//            MaxSizeImage(strpath);
            Toast.makeText(this, "strpath" + strpath, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            myToast("gambar terlalu besar \n silahkan pilih gambar yang lebih kecil");
            e.printStackTrace();
        }
        /**
         * Sets the maximum time to wait in milliseconds between two upload attempts.
         * This is useful because every time an upload fails, the wait time gets multiplied by
         * {@link UploadService#BACKOFF_MULTIPLIER} and it's not convenient that the value grows
         * indefinitely.
         */
        //strtime = currentDate();
//        try {
//            new MultipartUploadRequest(c, MyConstant.BASE_URL+"set-user-photo")
//                    .addFileToUpload(strpath, "photo")
//                    .addParameter("user_id", striduser)
//
//                    .setNotificationConfig(new UploadNotificationConfig())
//                    .setMaxRetries(2)
//                    .startUpload();
//
//           // getDataMakanan(strkategorimakanan);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            myToast(e.getMessage());
//        } catch (FileNotFoundException e) {
//            myToast(e.getMessage());
//            e.printStackTrace();
//        }
    }

    private String getPath(Uri filepath) {
        Cursor cursor = getContentResolver().query(filepath, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    private void showfilechooser(int reqFileChoose) {
        Intent intentgalery = new Intent();
        intentgalery.setType("image/*");
        intentgalery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intentgalery, "select Pictures"), reqFileChoose);

    }

    private void registeruser() {
        final ProgressDialog dialog = ProgressDialog.show(c,
                "process register", "harap bersabar");

        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        String jenkel = null;
        if (strjk == "laki-laki") {
            jenkel = "L";
        } else {
            jenkel = "P";
        }
        Call<ModelRegisterUser> modeluser = api.registerUser(
                stremail, strpassword, strlevel, strnama, strno_ktp, stralamat, jenkel, strtgl_lhr, strno_hp, stragama,
                strfoto, strkota_id, strprov_id);

        modeluser.enqueue(new Callback<ModelRegisterUser>() {
            @Override
            public void onResponse(Call<ModelRegisterUser> call, Response<ModelRegisterUser> response) {
                dialog.dismiss();
                boolean result = response.body().isStatus();
                String r = String.valueOf(result);
                Toast.makeText(RegisterActivity.this, "result :" + r, Toast.LENGTH_SHORT).show();
                String msg = response.body().getMsg();
                if (r.equals("true")) {
                    myToast(msg);
                    myIntent(LoginActivity.class);
                    finish();
                } else {
                    myToast(msg);
                }
            }

            @Override
            public void onFailure(Call<ModelRegisterUser> call, Throwable t) {
                dialog.dismiss();
                myToast("gagal koneksi :" + t.getMessage());
            }
        });

    }
}
