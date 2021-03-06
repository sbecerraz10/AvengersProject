package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exception.CharacterDoesNotExist;
import exception.CharacterNotChoosen;
import exception.FieldNotChoosen;
import exception.NicknameNotValid;
import exception.PlayerDoesNotExist;

public class Index {
	
	private ArrayList<User> users;
	
	private Field headField;
	
	private Character headCharacter;
	
	private Character characterChoose;
	
	private Field fieldChoose;
	
	private User userChoose;
	
	
	public Index() {
		File file = new File("data/Coachs.txt");
		if(file.exists() == false) {
			users = new ArrayList<User>();
		}else {
			users = recuperarUsers();
		}	
		loadCharacters();
		loadFields();
		circularListField();
		circularListCharacter();
		characterChoose = headCharacter;
		fieldChoose = headField;
//		writeCharacter();
	}
	
	public void registrerUser(String nickname) throws NicknameNotValid {
		if(nickname.length()<4) {
			throw new NicknameNotValid();
		}users.add(new User(nickname,0));		
	}
	
	public void choosenUser(String data) {
		String[] info = data.split("\t");
		String name = info[0];
		int score = Integer.parseInt(info[1]);
		userChoose = new User(name,score);
	}
	
	public void ordenarUserName() {	
		int in;
		for (int i = 1 ; i < users.size(); i++) {
			User aux = users.get(i);
			in = i;             
			while (in > 0 && users.get(in - 1).compareName(aux)>0) {
				users.set(in, users.get(in-1));
				--in;
			} 
			users.set(in, aux);
		}
	}
	
//	public void ordenarCharacterPower() {
//		noCircular();
//		Character aux = headCharacter;
//		while(aux != null) {
//			if(aux.comparePower(aux.getNext())<=0) {
//				aux.setNext(aux.getNext().getNext());
//				aux.getNext().setNext(aux);
//				headCharacter = aux.getNext();
//			}
//			aux = aux.getNext();
//		}
//	}
	
	public String writeUsers() {
		String cadena = "";
		for(int i = 0;i<users.size();i++) {
			cadena += users.get(i).getName()+"\t"+users.get(i).getScore()+",";
		}
		return cadena;
    }
	
	public void noCircular(){
		headCharacter.getPrevious().setNext(null);
		headCharacter.setPrevious(null);
	}
	
//	public void ordenarCharacterLife(){
//		
//	}
	
	public Character searchCharacter(String nombre) throws CharacterDoesNotExist {
		noCircular();
		Character ch = null;
		if(headCharacter != null) {
			ch = headCharacter.searchCharacter(nombre);
		}else{
			ch = null;
		}
		circularListCharacter();
		if(ch == null) {
			throw new CharacterDoesNotExist();
		}
		return ch;
	}
	
	public User searchUser(String nombre) throws PlayerDoesNotExist {
		ordenarUserName();
		User user = null;
		boolean encontro = false;
		int inicio = 0;
		int ultimo = users.size()-1;
		int centro;
		while(inicio<=ultimo && !encontro) {
			centro = (inicio+ultimo)/2;
			if(users.get(centro).getName().compareToIgnoreCase(nombre)==0) {
				user = users.get(centro);
				encontro = true;
			}else if(users.get(centro).getName().compareToIgnoreCase(nombre)<0) {
				inicio = centro+1;
			}else {
				ultimo = centro-1;
			}
		}
		if(user == null) {
			throw new PlayerDoesNotExist();
		}
		
		return user;
	}
	
	
	public void loadCharacters() {
		try {
			FileReader fr = new FileReader("files/Characters.txt");
			BufferedReader br = new BufferedReader(fr);
			String cadena = "";
			while((cadena= br.readLine())!= null) {
				String[] character = cadena.split(";");
				int healt = Integer.parseInt(character[0]);
				int power = Integer.parseInt(character[1]);
				String name = character[2];
				String image = character[3];
				Character ch = new Character(healt,power,name,image);
				saveCharacters(ch,this.headCharacter,null);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFields() {
		try {
			FileReader fr = new FileReader("files/Fields.txt");
			BufferedReader br = new BufferedReader(fr);
			String cadena="";
			while((cadena=br.readLine())!=null) {
				String[] field = cadena.split(";");
				String nombre = field[0];
				String image = field[1];
				Field fd = new Field(nombre,image);
				saveField(fd,this.headField,null);
			}
			br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveField(Field field, Field actual, Field previous) {
		if(this.headField==null) {
			this.headField = field;
		}else {
			if(actual==null) {
				previous.setNext(field);
			}else {
				if(this.headField.compareTo(field) <= 0) {
					field.setNext(headField);
					headField.setPrevious(field);
					headField = field;
				}
				else if(actual.compareTo(field) <= 0) {
					if(previous!=null)previous.setNext(field);
					actual.setPrevious(field);
					field.setNext(actual);
					field.setPrevious(previous);
				}else {
					previous = actual;
					actual = actual.getNext();
					saveField(field,actual,previous);
				}
			}		
					
		}
	}
	
	public void saveCharacters(Character character, Character actual, Character previous) {
		if(this.headCharacter==null) {
			this.headCharacter = character;
		}else {
			if(actual==null) {
				previous.setNext(character);
			}else {
				if(this.headCharacter.compareName(character) <= 0) {
				character.setNext(headCharacter);
				headCharacter.setPrevious(character);
				headCharacter = character;
				}else if(actual.compareName(character) <= 0) {
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
	}
	
	public void circularListCharacter() {
		Character actual = headCharacter;
		Character previous = null;
		while(actual!= null) {
			previous = actual;
			actual = actual.getNext();
		}
		previous.setNext(headCharacter);
		headCharacter.setPrevious(previous);
	}
	
	public void circularListField() {
		Field actual = headField;
		Field previous = null;
		while(actual!= null) {
			previous = actual;
			actual = actual.getNext();
		}
		previous.setNext(headField);
		headField.setPrevious(previous);
	}
	
	public Character showNextCharacter(Character actual) {
		return actual.getNext();
	}
	
	public Field showNextField(Field actual) {
		return actual.getNext();
	}
	
	public Character showPreviousCharacter(Character actual) {
		return actual.getPrevious();
	}
	
	public Field showPreviosField(Field actual) {
		return actual.getPrevious();
	}
	
	public void showNextCharacter() {
		this.characterChoose = this.characterChoose.getNext();
	}
	
	public void showPreviousCharacter() {
		this.characterChoose = this.characterChoose.getPrevious();
	}
	
	public void showNextField() {
		this.fieldChoose = this.fieldChoose.getNext();
	}
	
	public void showPreviousField() {
		this.fieldChoose = this.fieldChoose.getPrevious();
	}
	
	public void electedCharacter(boolean elected) throws CharacterNotChoosen {
		if(elected == false) {
			throw new CharacterNotChoosen();
		}
	}
	
	public void electedField(boolean elected) throws FieldNotChoosen {
		if(elected == false) {
			throw new FieldNotChoosen();
		}
	}
	
	public void serializarUsers()  {
		try {
			File file = new File("files/Users.txt");
			if(file.exists()== false) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(users);
				oos.close();	
			}else {
				FileWriter fl = new FileWriter(file);
				BufferedWriter bf = new BufferedWriter(fl);
				bf.write("");
				bf.close();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(users);
				oos.close();	
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> recuperarUsers() {
		ArrayList<User> clon = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/Coachs.txt"));
			clon = (ArrayList<User>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clon;
	}
	
	public Character getCharacterChoose() {
		return characterChoose;
	}

	public void setCharacterChoose(Character characterChoose) {
		this.characterChoose = characterChoose;
	}

	public Field getFieldChoose() {
		return fieldChoose;
	}

	public void setFieldChoose(Field fieldChoose) {
		this.fieldChoose = fieldChoose;
	}

	public User serachUser(String criterio) { 
		return users.get(0);
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
