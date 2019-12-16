import java.util.Random;

public class date {
	private int month;
	private int day;
	private int year;
	private int hour;
	private int seconds;
	
	public date(int x, int y, int z){
		this.month=x;
		this.day=y;
		this.year=z;
	}
	public date(int x, int y, int z,int h, int s){
		this.month=x;
		this.day=y;
		this.year=z;
		this.hour=h;
		this.seconds=s;
	}
	public date() {
		// TODO Auto-generated constructor stub
	}
	public int getMonth() {
		return month;
	
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public int getHour() {
		return hour;
	}
	public int getSec() {
		return seconds;
	}
	
	public String getString() {
		String s,a,b,c;
		a=Integer.toString(month);
		b=Integer.toString(day);
		c=Integer.toString(year);
		s=a+"/"+b+"/"+c;
		return s;


		
	}
	
	
	
	
	public void setMonth(int x) {
		month = x;
	}
	public void setDay(int x) {
		day=x;
	}
	public void setYear(int x) {
		year= x;
	}
	public void setHour(int x) {
		hour=x;
	}
	public void setSec(int x) {
		seconds=x;
	}
	
}
