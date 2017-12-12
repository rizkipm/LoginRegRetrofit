package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelKontak{

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataKontak> data;

	@SerializedName("total_rows")
	private int totalRows;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<DataKontak> data){
		this.data = data;
	}

	public List<DataKontak> getData(){
		return data;
	}

	public void setTotalRows(int totalRows){
		this.totalRows = totalRows;
	}

	public int getTotalRows(){
		return totalRows;
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
			"ModelKontak{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",total_rows = '" + totalRows + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}