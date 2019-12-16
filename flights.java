import java.util.Random;


import javax.swing.JLabel;

public class flights {
	
		private String Airline;
		
		private String Departure;		
		private String Arrival;
		
		
		private date DepartureTime;		//string returns of arrival time
		private date ArrivalTime;
		
		private String  DepartureTimeS;
		private String ArrivalTimeS;
		
		private int Seats;
		private int price;
		
		
		
		public flights(String a, String x, String y, int z){
			this.Airline=a;
			this.Departure=x;
			this.Arrival=y;
			this.Seats=z;
			
		
		
		}
		
		public flights() {
			// TODO Auto-generated constructor stub
		}
		
		
		public String getAirline() {
			return Airline;
		
		}
		public String getDeparture() {
			return Departure;
		
		}
		
		public String getArrival() {
			return Arrival;
		
		}
		public date getDepartureTime() {
			return DepartureTime;
		}
		
		
		public date getArrivalTime() {
			return ArrivalTime;
		}
		
		public String getDepartureTimeS() {
			return DepartureTimeS;
		}
		
		
		public String getArrivalTimeS() {
			return ArrivalTimeS;
		}
		
		public int getSeats() {
			return Seats;
		
		}
		public int getPrice() {
			return price;
		
		}
		
		
		
		
		
		public void setSeats(int x) {
			Seats = x;
		}
		
		
		
		
		public void initalizer() {
			 
			int m,d,y,h,s;
			
			int temp;
			
			int Am,Ad,Ay,Ah,As;
			
			m=Global.CurrentDate.getMonth();
			d=Global.CurrentDate.getDay();
			y= Global.CurrentDate.getYear();
			
			Am=m;
			Ad=d;
			Ay=y;
			
			Random random = new Random();
			h = random.nextInt();
			h = h%24;
			if(h<=0) {
				h=h*(-1);
			}
			
			Ah = h + 4;
			
			
			
			Random random2 = new Random();
			s = random.nextInt();
			s = s%60;
			if(s<=0) {
				s=s*(-1);
			}
			if(s<10) {
				s=s+10;
			}
			
			As=s;
			As=As+16;
			As=As%59;
			if(As < 10) {
				As=As+11;
				
			}
			
			Random random3 = new Random();
			temp=d;
			d = random.nextInt();
			d = d%29;
			if(d<=0) {
				d=d*(-1);
			}
			if(d<temp) {
				d=temp;
			}
			
			Ad=d;
			
			int temp1= Ah%24;
			if (Ah>=24) {
				Ad=Ad+1;
				Ah=temp1;

			}
			
			
			
			date ddate = new date(m,d,y,h,s);
			date adate = new date(Am,Ad,Ay,Ah,As);

			DepartureTime = ddate;
			ArrivalTime= adate;
			
			String s1,s2,s3,s4,s5;
			String as1,as2,as3,as4,as5;
			
			s1=Integer.toString(m);
			s2=Integer.toString(d);
			s3=Integer.toString(y);
			s4=Integer.toString(h);
			s5=Integer.toString(s);
			
			
			as1=Integer.toString(Am);
			as2=Integer.toString(Ad);
			as3=Integer.toString(Ay);
			as4=Integer.toString(Ah);
			as5=Integer.toString(As);
			
			
			DepartureTimeS=s1+"/"+s2+"/"+s3+" "+s4+":"+s5;
			
			ArrivalTimeS=as1+"/"+as2+"/"+as3+" "+as4+":"+as5;
			
			Random rand = new Random();
		    int randomNum = rand.nextInt((805 - 350) + 1) + 350;
		    price= randomNum;
		
			
		//Random randomp = new Random();
	//	s = randomp.nextInt();
		//	s = s%860;
		//	if(s<0) {
		//		s=s*(-1);
		//	}
		//	if(s==0) {
		//		s=456;
		//	}
		//	price=100;



			
			
			
			
			
			
			
		}
		
		
		
		

		
		
		

}
