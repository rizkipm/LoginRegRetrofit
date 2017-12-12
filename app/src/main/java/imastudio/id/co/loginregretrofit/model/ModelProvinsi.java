package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelProvinsi{

	@SerializedName("data")
	private List<DataProvinsi> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<DataProvinsi> data){
		this.data = data;
	}

	public List<DataProvinsi> getData(){
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
			"ModelProvinsi{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}