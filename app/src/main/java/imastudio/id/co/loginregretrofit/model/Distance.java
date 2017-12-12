
package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Distance {

    @SerializedName("text")
    private String mText;
    @SerializedName("value")
    private Long mValue;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Long getValue() {
        return mValue;
    }

    public void setValue(Long value) {
        mValue = value;
    }

}
