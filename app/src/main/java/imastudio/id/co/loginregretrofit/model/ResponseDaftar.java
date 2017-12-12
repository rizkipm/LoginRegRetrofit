
package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;


public class ResponseDaftar {

    @SerializedName("msg")
    private String mMsg;
    @SerializedName("result")
    private String mResult;

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

}
