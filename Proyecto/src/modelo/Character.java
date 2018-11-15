package modelo;

public class Character implements Comparable<Character> {

	private int life;
	
	private int power;
	
	private String nickname;
	
	private String image;
	
	private Character next;
	
	private Character previous;
	
	private Gemma rootGemma;
	

	private int posx;
	
	private int posy;
	
	public Character(int life,int power, String nickname, String image) {
		super();
		this.life = life;
		this.power = power;
		this.nickname = nickname;
		this.image = image;
		this.next = null;
		this.previous = null;
	}

	public Gemma getRootGemma() {
		return rootGemma;
	}

	public void setRootGemma(Gemma rootGemma) {
		this.rootGemma = rootGemma;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

	public Character getPrevious() {
		return previous;
	}

	public void setPrevious(Character previous) {
		this.previous = previous;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public int compareTo(Character character2) {
		int toReturn = 0;
		
		if(this.power < character2.getPower() ) {
			toReturn = -1;
		}else if(this.power > character2.getPower()) {
			toReturn = 1;
		}
		
		return toReturn;
	
	}
	
	
	
	
	
	

}
