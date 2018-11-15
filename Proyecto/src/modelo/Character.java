package modelo;

public class Character {

	private int life;
	
	private String nickname;
	
	private String image;
	
	private Character next;
	
	private Gemma rootGemma;

	private int posx;
	
	private int posy;
	
	public Character(int life, String nickname, String image) {
		super();
		this.life = life;
		this.nickname = nickname;
		this.image = image;
		this.next = null;
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
	
	
	
	
	
	

}
