package net.sf.memoranda.psp;

import java.util.HashMap;

import net.sf.memoranda.date.CurrentDate;

public class Planning implements Psp {
	
	Psp pspValues;
	
	float estTime;
	int locHr;
	int estSize;
	int estDefect;
	String filename;
	HashMap <String, Integer> projectDescription;
	
	
	public Planning() {
		// TODO Auto-generated constructor stub
		float estTime = 0;
		int locHr = 0;
		int estSize = 0; 
		int estDefect = 0;
		String filename = "";
		HashMap <String, Integer> projectDescription = null;
	}
	
	public Planning(float estimatedTime, int linesOfCodePerHour, int estimatedSize, int estimatedDefect, 
			String nameOfFile, HashMap <String, Integer> projDesc) {
		// TODO Auto-generated constructor stub
		float estTime = estimatedTime;
		int locHr = linesOfCodePerHour;
		int estSize = estimatedSize; 
		int estDefect = estimatedDefect;
		String filename = nameOfFile;
		HashMap <String, Integer> projectDescription = projDesc;
	}

	public float getEstTime() {
		return estTime;
	}

	public void setEstTime(float estTime) {
		this.estTime = estTime;
	}

	public int getLocHr() {
		return locHr;
	}

	public void setLocHr(int locHr) {
		this.locHr = locHr;
	}

	public int getEstSize() {
		return estSize;
	}

	public void setEstSize(int estSize) {
		this.estSize = estSize;
	}

	public int getEstDefect() {
		return estDefect;
	}

	public void setEstDefect(int estDefect) {
		this.estDefect = estDefect;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public HashMap<String, Integer> getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(HashMap<String, Integer> projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Override
	public CurrentDate getStDate() {
		return pspValues.getStDate();
	}

	@Override
	public void setStDate(CurrentDate stDate) {
		CurrentDate startDate = pspValues.getStDate();
		startDate = stDate; 
		
	}

	@Override
	public String getName() {
		return pspValues.getName();
	}

	@Override
	public void setName(String name) {
		String projectName = pspValues.getName();
		projectName = name; 

	}

	@Override
	public String getDescription() {
		return pspValues.getDescription();
	}

	@Override
	public void setDescription(String description) {
		String projDesc = pspValues.getDescription();
		projDesc = description;
	}

	@Override
	public String toString() {
		return "Planning:\n"
				+ "Estimated Time = " + this.getEstTime() + ", Lines of Code = " + this.getLocHr() + 
				", Estimated Size = " + this.getEstSize() + ", Estimated Defects = " + this.getEstDefect() + 
				", Filename=" + this.getFilename() + ", projectDescription=" + this.getProjectDescription();
	}

}
