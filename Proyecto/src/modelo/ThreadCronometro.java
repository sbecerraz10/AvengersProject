package modelo;

import javafx.scene.control.TextField;

public class ThreadCronometro extends Thread{
		
	private Field field;
	private TextField textField;
	
	public ThreadCronometro(Field field,TextField textField) {
		this.field= field;
		this.textField = textField;
	}
	
	@Override
	public void run() {
		while (true) {		
			field.getCronometro().iniciar();
			System.out.println(field.getCronometro().darTiempo());
			String time = field.getCronometro().darTiempo();
			textField.setText(time);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}									
		}					
	}			
}