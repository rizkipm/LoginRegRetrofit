package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class DataKota {

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_jenis")
	private int idJenis;

	@SerializedName("id")
	private int id;

	@SerializedName("id_prov")
	private String idProv;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdJenis(int idJenis){
		this.idJenis = idJenis;
	}

	public int getIdJenis(){
		return idJenis;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIdProv(String idProv){
		this.idProv = idProv;
	}

	public String getIdProv(){
		return idProv;
	}

	@Override
 	public String toString(){
		return 
			"DataKota{" +
			"nama = '" + nama + '\'' + 
			",id_jenis = '" + idJenis + '\'' + 
			",id = '" + id + '\'' + 
			",id_prov = '" + idProv + '\'' + 
			"}";
		}
}