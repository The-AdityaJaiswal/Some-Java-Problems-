import java.util.Scanner;

public class TravelSolution {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int loopCount=sc.nextInt();sc.nextLine();
	TravelAgencies[] travelobjs=new TravelAgencies[loopCount];
	for (int i=0;i<loopCount;i++) {
		int a=sc.nextInt();sc.nextLine();
		String b=sc.nextLine();
		String c=sc.nextLine();
		int d=sc.nextInt();sc.nextLine();
		boolean e=sc.nextBoolean();sc.nextLine();
		travelobjs[i]= new TravelAgencies(a,b,c,d,e);
	}
	int reg=sc.nextInt();sc.nextLine();
	String type=sc.nextLine();
	sc.close();
	
	int result=findAgencyWithHighestPackagePrice(travelobjs);
    if (result==0) 
    	System.out.println("There is no TravelAgency with Highest Package");
    else
    	System.out.println(result); 
    
	TravelAgencies resultobj=agencyDetailsForGivenIdandType(travelobjs,reg,type);
	if (resultobj == null)
		System.out.println("NO travel Agency with such Id and type");
	else
	{
		System.out.println(resultobj.getAgencyname()+":"+resultobj.getPrice());
	}
}
public static int findAgencyWithHighestPackagePrice(TravelAgencies[] travelobjs){
	int price=0;
	for(TravelAgencies travelagency: travelobjs) {
		if(travelagency.getPrice()>price)
			price=travelagency.getPrice();
	}
	return price;
}
public static TravelAgencies agencyDetailsForGivenIdandType(TravelAgencies[] 
		travelobjs,int reg,String type) {
	for(TravelAgencies travelagency:travelobjs) {
		if(travelagency.getRegNo() == reg &&
				travelagency.getAgencyType().equalsIgnoreCase(type)
				  && travelagency.isFlightFacility())
		{
			return travelagency;
		}
	}
	return null;
}
}
class TravelAgencies{
	private int regNo;
	private String agencyname;
	private String agencyType;
	private int price;
	private boolean flightFacility;
	public TravelAgencies(int regNo, String agencyname, String agencyType, int price, boolean flightFacility) {
		this.regNo = regNo;
		this.agencyname = agencyname;
		this.agencyType = agencyType;
		this.price = price;
		this.flightFacility = flightFacility;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getAgencyname() {
		return agencyname;
	}
	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}
	public String getAgencyType() {
		return agencyType;
	}
	public void setAgencyType(String agencyType) {
		this.agencyType = agencyType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isFlightFacility() {
		return flightFacility;
	}
	public void setFlightFacility(boolean flightFacility) {
		this.flightFacility = flightFacility;
	}
}

//Test case 1
//4
//123
//A2Z Agency
//Platinum
//50000
//true
//345
//SSS Agency
//Gold
//30000
//false
//987
//Cox and Kings
//Diamond
//40000
//true
//888
//Global Tours
//Silver
//20000
//false
//987
//Diamond

// Test case 2
