package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class DataUser {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("level")
	private String level;

	@SerializedName("user_detail")
	private UserDetail userDetail;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("token")
	private String token;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
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

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"DataUser{" +
			"updated_at = '" + updatedAt + '\'' + 
			",level = '" + level + '\'' + 
			",user_detail = '" + userDetail + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}