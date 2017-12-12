package imastudio.id.co.loginregretrofit.model;

public class ModelAddkontak{
	private String msg;
	private DataaddKontak data;
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(DataaddKontak data){
		this.data = data;
	}

	public DataaddKontak getData(){
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
			"ModelAddkontak{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
