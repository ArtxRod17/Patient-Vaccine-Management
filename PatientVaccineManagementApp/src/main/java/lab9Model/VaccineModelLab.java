package lab9Model;

public class VaccineModelLab {
	static int idSeed = 1;
	private int id;
	private String vaccineName;
	private int dosesRequired;
	private int daysBetweenDoses;
	private int dosesRecieved;
	private int dosesLeft;
	
	public VaccineModelLab(String vaccineName, int dosesRequired, int daysBetweenDoses, int dosesRecieved, int dosesLeft) {
		this.id = idSeed++;
		this.vaccineName = vaccineName;
		this.dosesRequired = dosesRequired;
		this.daysBetweenDoses = daysBetweenDoses;
		this.dosesRecieved = dosesRecieved;
		this.dosesLeft = dosesLeft;
		
	}
	public VaccineModelLab() {
		this.id = idSeed++;
	}
	//GET AND SET METHODS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public int getDosesRequired() {
		return dosesRequired;
	}
	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}
	public int getDaysBetweenDoses() {
		return daysBetweenDoses;
	}
	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}
	public int getDosesRecieved() {
		return dosesRecieved;
	}
	public void setDosesRecieved(int dosesRecieved) {
		this.dosesRecieved = dosesRecieved;
	}
	public int getDosesLeft() {
		return dosesLeft;
	}
	public void setDosesLeft(int dosesLeft) {
		this.dosesLeft = dosesLeft;
	}

}
