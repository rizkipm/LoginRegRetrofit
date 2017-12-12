package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelDeleteKontak{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<Object> data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<Object> data){
		this.data = data;
	}

	public List<Object> getData(){
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
			"ModelDeleteKontak{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}