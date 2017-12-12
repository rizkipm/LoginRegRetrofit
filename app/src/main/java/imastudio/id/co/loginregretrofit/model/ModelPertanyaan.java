package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ModelPertanyaan{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private DataPertanyaan data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(DataPertanyaan data){
		this.data = data;
	}

	public DataPertanyaan getData(){
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
			"ModelPertanyaan{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}