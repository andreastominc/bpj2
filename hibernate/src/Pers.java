

import java.io.Serializable;

public class Pers implements Serializable{
//implements Serializable fuer Multi-Threads
	
	private int id;
	private String first;
	private String last;
	
	public Pers()
	{
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	
}
