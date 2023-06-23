package lab9Model;

import java.util.Date;

public class PatientModel {
	static int idSeed = 1;
	private int id;
	private String patientName;
	private int vaccineId;
	private Date firstDose;
	private Date secondDose;
	
	public PatientModel(String patientName, int vaccineRecieved, Date firstDose, Date secondDose) {
		super();
		this.id = idSeed++;
		this.patientName = patientName;
		this.vaccineId = vaccineRecieved;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
	}
	public PatientModel() {
		this.id = idSeed++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getVaccineRecieved() {
		return vaccineId;
	}

	public void setVaccineRecieved(int vaccineRecieved) {
		this.vaccineId = vaccineRecieved;
	}

	public Date getFirstDose() {
		return firstDose;
	}

	public void setFirstDose(Date firstDose) {
		this.firstDose = firstDose;
	}

	public Date getSecondDose() {
		return secondDose;
	}

	public void setSecondDose(Date secondDose) {
		this.secondDose = secondDose;
	}
	
	

}
