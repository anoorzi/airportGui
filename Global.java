import javax.swing.JOptionPane;

public class Global {
	
	public static date CurrentDate;

	public void CGV() {
		
		String CurrentMonth = JOptionPane.showInputDialog("Enter Month in the format MM ");
		
		while(Integer.parseInt(CurrentMonth)>=13 || Integer.parseInt(CurrentMonth)<=0) {
			CurrentMonth = JOptionPane.showInputDialog("Enter Month in the numerical format  ");

		}
		
		String CurrentDay = JOptionPane.showInputDialog("Enter Day in the format DD");
		
		while(Integer.parseInt(CurrentDay)<=0 || Integer.parseInt(CurrentDay)>30) {
			CurrentDay = JOptionPane.showInputDialog("Enter Day in the numerical format ");

		}
		
		
		String CurrentYear = JOptionPane.showInputDialog("Enter Year in the format YYYY");
		
		date rep = new date();
		
		int num1 = Integer.parseInt(CurrentMonth);
		rep.setMonth(num1);
		int num2 = Integer.parseInt(CurrentDay);
		rep.setDay(num2);
		int num3 = Integer.parseInt(CurrentYear);
		rep.setYear(num3);
		
		CurrentDate = rep;
		
		
		
	}
	

}
