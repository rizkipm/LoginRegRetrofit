package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ModelUser{

	@SerializedName("isLogin")
	private boolean isLogin;

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean login) {
		isLogin = login;
	}

	@SerializedName("data")
	private DataUser data;


	public void setData(DataUser data){
		this.data = data;
	}

	public DataUser getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ModelUser{" + 
			"isLogin = '" + isLogin + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}