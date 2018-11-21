package modelo;

public class Cronometro {
		
	private int dMinuto;
	private int minuto;
	private int dSegundo;
	private int segundo;
	
	public Cronometro() {
		reiniciar();
	}
	
	public void reiniciar() {
		dMinuto=0;
		minuto=0;
		dSegundo=0;
		segundo=0;
	}
		
	public String darTiempo() {
		return dMinuto+""+minuto+":"+dSegundo+""+segundo;
	}
	
	public int calcularSegundos() {
		int segundos= segundo+(dSegundo*10)+(minuto*60)+(dMinuto*600);
	    return segundos;
   	}

	public int getdMinuto() {
		return dMinuto;
	}
	
	public void iniciar() {
		if(segundo<=8) {
			segundo+=1;
		}else {
			segundo=0;
			if(dSegundo<5) {
				dSegundo+=1;
			}else {
				dSegundo=0;
				if(minuto<=8) {
					minuto+=1;
				}else {
					minuto=0;
					if(dMinuto<5) {
						dMinuto+=1;
					}
				}
			}
		}		
	}
	
	public void setdMinuto(int dMinuto) {
		this.dMinuto = dMinuto;
	}
	
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getdSegundo() {
		return dSegundo;
	}
	public void setdSegundo(int dSegundo) {
		this.dSegundo = dSegundo;
	}
	public int getSegundo() {
		return segundo;
	}
	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}	
}
