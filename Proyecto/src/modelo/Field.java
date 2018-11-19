package modelo;

import java.util.ArrayList;

public class Field {
	
	private Field next;
	
	private Field previous;
	
	private Gemma rootGemma;
	
	private String image;
	
	private ArrayList<Bomb> bombs;
	
	private ArrayList<Electricity> electricity;

	public Field() {
		bombs = new ArrayList<Bomb>();
		electricity = new ArrayList<Electricity>();
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

	public ArrayList<Bomb> getBombs() {
		return bombs;
	}
	
	public ArrayList<Electricity> getElectricity() {
		return electricity;
	}

	public void setBombs(ArrayList<Bomb> bombs) {
		this.bombs = bombs;
	}

	public void setTraps(ArrayList<Electricity> electricity) {
		this.electricity = electricity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public void generateTraps() {
		
	}
	
	public Field searchField(String id) {
		Field toReturn = null;
		if(this.image.equals(id)) {
			toReturn =  this;
		}else {
			toReturn = this.next.searchField(id);
		}
		return toReturn;
	}

}
