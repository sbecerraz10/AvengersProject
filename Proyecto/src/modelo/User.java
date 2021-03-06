package modelo;

import java.io.Serializable;

public class User implements Serializable{
	
	private String name;
	private int score;
	
	public String getName() {
		return name;
	}

	public void setName(String name, int score) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User(String name,int score) {
		this.name = name;
		this.score = score;
	}

	public int compareName(User user) {
		int result = 0;
		if(this.name.compareToIgnoreCase(user.getName())==0) {
			result = 0;
		}else if(this.name.compareToIgnoreCase(user.getName())<0) {
			result = -1;
		}else if(this.name.compareToIgnoreCase(user.getName())>0) {
			result = 1;
		}
		
		return result;
	}
	
	public int compareScore(User user) {
		int result = 0;
		if(this.score == user.getScore()) {
			result = 0;
		}else if(this.score < user.getScore()){
			result = -1;
		}else if(this.score > user.getScore()) {
			result = 1;
		}
		
		return result;		
	}

	@Override
	public String toString() {
		return "User [name=" + name + "- score=" + score + "]";
	}
	
	

}
