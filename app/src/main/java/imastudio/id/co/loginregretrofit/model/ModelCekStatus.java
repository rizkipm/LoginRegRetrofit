package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ModelCekStatus{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private DataCekStatus data;

	@SerializedName("status")
	private String status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(DataCekStatus data){
		this.data = data;
	}

	public DataCekStatus getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ModelCekStatus{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}