package modelo;

public class Gemma {

	public static int LIMITY = 243;
	
	private Gemma left;
	
	private Gemma rigth;
	
	private int power;
	
	private int posy;
	
	private int posx;
	
	int dy = 3;
	
	public void moveGemma() {
		if(this.posy >243) {
			this.posy = 0;
		}
		
		this.posy += dy;
	}
	
	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public Gemma(int power) {
		this.power = power;
	}



	public Gemma getLeft() {
		return left;
	}



	public void setLeft(Gemma left) {
		this.left = left;
	}



	public Gemma getRigth() {
		return rigth;
	}



	public void setRigth(Gemma rigth) {
		this.rigth = rigth;
	}



	public int getPower() {
		return power;
	}



	public void setPower(int power) {
		this.power = power;
	}

}
