package imastudio.id.co.loginregretrofit.model;

import com.google.gson.annotations.SerializedName;

public class DataProvinsi {

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_prov")
	private String idProv;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
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
			"DataProvinsi{" +
			"nama = '" + nama + '\'' + 
			",id_prov = '" + idProv + '\'' + 
			"}";
		}
}