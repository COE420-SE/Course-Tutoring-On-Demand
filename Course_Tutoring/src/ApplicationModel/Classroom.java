package ApplicationModel;

public class Classroom {
	
	String CLASSROOM_ID;
	String BUILDING;
	String TOTAL_SEATS;
	
	public Classroom(String cLASSROOM_ID, String bUILDING, String tOTAL_SEATS) {
		super();
		CLASSROOM_ID = cLASSROOM_ID;
		BUILDING = bUILDING;
		TOTAL_SEATS = tOTAL_SEATS;
	}
	public String getCLASSROOM_ID() {
		return CLASSROOM_ID;
	}
	public void setCLASSROOM_ID(String cLASSROOM_ID) {
		CLASSROOM_ID = cLASSROOM_ID;
	}
	public String getBUILDING() {
		return BUILDING;
	}
	public void setBUILDING(String bUILDING) {
		BUILDING = bUILDING;
	}
	public String getTOTAL_SEATS() {
		return TOTAL_SEATS;
	}
	public void setTOTAL_SEATS(String tOTAL_SEATS) {
		TOTAL_SEATS = tOTAL_SEATS;
	}


}
