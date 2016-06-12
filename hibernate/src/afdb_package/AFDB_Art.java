package afdb_package;

public class AFDB_Art {
	private int art_id;
	private String art_benennung;
	

	public AFDB_Art(int art_id, String art_benennung) {
		super();
		this.art_id = art_id;
		this.art_benennung = art_benennung;
	}

	public AFDB_Art() {
		super();
	}



	public int getArt_id() {
		return art_id;
	}
	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}
	public String getArt_benennung() {
		return art_benennung;
	}
	public void setArt_benennung(String art_benennung) {
		this.art_benennung = art_benennung;
	}

	@Override
	public String toString() {
		return "AFDB_Art [art_id=" + art_id + ", art_benennung=" + art_benennung + "]";
	}
	
	
	
	
	
}
