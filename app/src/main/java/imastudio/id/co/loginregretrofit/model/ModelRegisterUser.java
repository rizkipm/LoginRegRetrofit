package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ModelRegisterUser{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private DataRegisterUser data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(DataRegisterUser data){
		this.data = data;
	}

	public DataRegisterUser getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ModelRegisterUser{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}