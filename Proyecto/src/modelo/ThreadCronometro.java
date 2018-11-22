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
			field.getCronometro().initiate();
			System.out.println(field.getCronometro().getTime());
			String time = field.getCronometro().getTime();
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