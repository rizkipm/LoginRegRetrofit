package imastudio.id.co.loginregretrofit.network;


import com.imastudio.wonder.helper.MyConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Blackswan on 9/12/2017.
 */

public class MyRetrofitClient {
    private static Retrofit getRetrofit(){
        //insialisasi retrofit 2
        Retrofit r = new Retrofit.Builder()
                .baseUrl(MyConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return r;
    }
    public static Retrofit setInit2() {

        return new Retrofit.Builder().baseUrl(MyConstant.GOOGLEMAP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static RestApi getInstaceRetrofit(){
        return getRetrofit().create(RestApi.class);
    }

    public static RestApi getInstaceRetrofit2(){
        return setInit2().create(RestApi.class);
    }

}
