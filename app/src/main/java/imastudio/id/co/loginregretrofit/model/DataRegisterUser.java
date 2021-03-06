package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class DataRegisterUser {

	@SerializedName("jk")
	private String jk;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("prov_id")
	private String provId;

	@SerializedName("agama")
	private String agama;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("tgl_lahir")
	private String tglLahir;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("nama")
	private String nama;

	@SerializedName("foto")
	private String foto;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("no_ktp")
	private String noKtp;

	@SerializedName("id")
	private int id;

	@SerializedName("kota_id")
	private String kotaId;

	@SerializedName("email")
	private Object email;

	public void setJk(String jk){
		this.jk = jk;
	}

	public String getJk(){
		return jk;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setProvId(String provId){
		this.provId = provId;
	}

	public String getProvId(){
		return provId;
	}

	public void setAgama(String agama){
		this.agama = agama;
	}

	public String getAgama(){
		return agama;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTglLahir(String tglLahir){
		this.tglLahir = tglLahir;
	}

	public String getTglLahir(){
		return tglLahir;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setNoKtp(String noKtp){
		this.noKtp = noKtp;
	}

	public String getNoKtp(){
		return noKtp;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKotaId(String kotaId){
		this.kotaId = kotaId;
	}

	public String getKotaId(){
		return kotaId;
	}

	public void setEmail(Object email){
		this.email = email;
	}

	public Object getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"DataRegisterUser{" +
			"jk = '" + jk + '\'' + 
			",no_hp = '" + noHp + '\'' + 
			",prov_id = '" + provId + '\'' + 
			",agama = '" + agama + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",tgl_lahir = '" + tglLahir + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",no_ktp = '" + noKtp + '\'' + 
			",id = '" + id + '\'' + 
			",kota_id = '" + kotaId + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}