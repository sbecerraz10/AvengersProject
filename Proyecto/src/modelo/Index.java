package modelo;

import java.util.ArrayList;

import exception.NicknameNotValid;

public class Index {
	
	private ArrayList<User> users;
	
	private Field headField;
	
	private Character headCharacter;
	
	
	public Index() {
		users = new ArrayList<User>();	
		loadCharacters();
	}
	
	
	public void registrerUser(String nickname) throws NicknameNotValid {
		if(nickname.length()<4) {
			throw new NicknameNotValid();
		}users.add(new User(nickname));		
	}
	
	public ArrayList<User> ordenarUserName() {	
		int in;
		for (int i = 1 ; i < users.size(); i++) {
			User aux = users.get(i);
			in = i;             
			while (in > 0 && users.get(in - 1).compareTo(aux)>0) {
				users.set(in, users.get(in-1));
				--in;
			} 
			users.set(in, aux);
		}
		return users;
	}
	
	
	public void loadFields() {
		
	}
	
	
	public void loadCharacters() {
		Character thor = new Character(1000,100000,"thor","/images/thor.png");
		Character spiderman = new Character(1000,10000,"spiderman","/images/thor.png");
		Character ironman = new Character(1000,1000,"iron man","/images/thor.png");
		saveCharacters(ironman,this.headCharacter,null);
		saveCharacters(spiderman,this.headCharacter,null);
		saveCharacters(thor,this.headCharacter,null);
	}
	
	public void saveCharacters(Character character, Character actual, Character previous) {
		if(this.headCharacter==null) {
			this.headCharacter = character;
		}else {
			if(this.headCharacter.compareTo(character) <= 0) {
				character.setNext(headCharacter);
				headCharacter.setPrevious(character);
				headCharacter = character;
			}
			else if(actual.compareTo(character) <= 0) {
				if(previous!=null)previous.setNext(character);
				actual.setPrevious(character);
				character.setNext(actual);
				character.setPrevious(previous);
			}else {
				previous = actual;
				actual = actual.getNext();
				saveCharacters(character,actual,previous);
			}
		}
	}


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public Field getHeadField() {
		return headField;
	}


	public void setHeadField(Field headField) {
		this.headField = headField;
	}


	public Character getHeadCharacter() {
		return headCharacter;
	}


	public void setHeadCharacter(Character headCharacter) {
		this.headCharacter = headCharacter;
	}
	

}


