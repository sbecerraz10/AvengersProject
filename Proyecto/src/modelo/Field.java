package modelo;

import java.util.ArrayList;

public class Field {
	
	
	private Field next;
	
	private Field previous;
	
	private Gemma rootGemma;
	
	private String image;
	
	private ArrayList<Trap> traps;

	public Field() {
		traps = new ArrayList<Trap>();
	}
	
	
	

	public Field getNext() {
		return next;
	}

	public void setNext(Field next) {
		this.next = next;
	}

	public Field getPrevious() {
		return previous;
	}




	public void setPrevious(Field previous) {
		this.previous = previous;
	}




	public Gemma getRootGemma() {
		return rootGemma;
	}

	public void setRootGemma(Gemma rootGemma) {
		this.rootGemma = rootGemma;
	}

	public ArrayList<Trap> getTraps() {
		return traps;
	}

	public void setTraps(ArrayList<Trap> traps) {
		this.traps = traps;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

}
