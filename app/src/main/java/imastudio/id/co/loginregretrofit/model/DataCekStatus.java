package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class DataCekStatus {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("lattitude")
	private String lattitude;

	@SerializedName("catatan")
	private String catatan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("volentir_id")
	private String volentirId;

	@SerializedName("longitude")
	private String longitude;

	@SerializedName("status")
	private String status;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setLattitude(String lattitude){
		this.lattitude = lattitude;
	}

	public String getLattitude(){
		return lattitude;
	}

	public void setCatatan(String catatan){
		this.catatan = catatan;
	}

	public String getCatatan(){
		return catatan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setVolentirId(String volentirId){
		this.volentirId = volentirId;
	}

	public String getVolentirId(){
		return volentirId;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
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
			"DataCekStatus{" +
			"updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",lattitude = '" + lattitude + '\'' + 
			",catatan = '" + catatan + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",volentir_id = '" + volentirId + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}