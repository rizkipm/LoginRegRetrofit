
package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseHistory {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("msg")
    private String mMsg;
    @SerializedName("result")
    private String mResult;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
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

}
