package modelo;

public class ThreadCronometro extends Thread{
		
	private Field field;
	
	public ThreadCronometro(Field field) {
		this.field= field;
	}
	
	@Override
	public void run() {
		while (true) {		
			field.getCronometro().iniciar();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}									
		}					
	}			
}