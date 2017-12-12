package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ModelCariPertolongan{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private DataCariPertolongan data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(DataCariPertolongan data){
		this.data = data;
	}

	public DataCariPertolongan getData(){
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
			"ModelCariPertolongan{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}