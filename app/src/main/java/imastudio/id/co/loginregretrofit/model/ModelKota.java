package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelKota{

	@SerializedName("data")
	private List<DataKota> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<DataKota> data){
		this.data = data;
	}

	public List<DataKota> getData(){
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
			"ModelKota{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}