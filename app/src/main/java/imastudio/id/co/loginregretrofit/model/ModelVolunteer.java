package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelVolunteer{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataVolunteer> data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<DataVolunteer> data){
		this.data = data;
	}

	public List<DataVolunteer> getData(){
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
			"ModelVolunteer{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}