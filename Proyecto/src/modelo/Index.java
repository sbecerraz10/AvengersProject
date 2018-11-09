package modelo;

import java.util.ArrayList;

import exception.NicknameNotValid;

public class Index {
	//fffff
	private ArrayList<User> users;
	
	public void registrerUser(String nickname) throws NicknameNotValid {
		if(nickname.length()<4) {
			throw new NicknameNotValid();
		}users.add(new User(nickname));		
	}
	
	public ArrayList<User> ordenarCoachName() {	;
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
	

}


