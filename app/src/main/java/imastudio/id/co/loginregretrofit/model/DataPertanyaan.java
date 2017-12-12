package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;



public class DataPertanyaan {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_detail")
	private UserDetail userDetail;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("judul")
	private String judul;

	@SerializedName("volentir_id")
	private String volentirId;

	@SerializedName("pertanyaan")
	private String pertanyaan;

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

	public void setUserDetail(UserDetail userDetail){
		this.userDetail = userDetail;
	}

	public UserDetail getUserDetail(){
		return userDetail;
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

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setVolentirId(String volentirId){
		this.volentirId = volentirId;
	}

	public String getVolentirId(){
		return volentirId;
	}

	public void setPertanyaan(String pertanyaan){
		this.pertanyaan = pertanyaan;
	}

	public String getPertanyaan(){
		return pertanyaan;
	}

	@Override
 	public String toString(){
		return 
			"DataPertanyaan{" +
			"updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_detail = '" + userDetail + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",judul = '" + judul + '\'' + 
			",volentir_id = '" + volentirId + '\'' + 
			",pertanyaan = '" + pertanyaan + '\'' + 
			"}";
		}
}