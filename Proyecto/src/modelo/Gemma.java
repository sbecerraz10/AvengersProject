package modelo;

public class Gemma {

	private Gemma left;
	
	private Gemma rigth;
	
	private int power;
	
	
	
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
