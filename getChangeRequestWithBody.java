package Incident;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getChangeRequestWithBody {

	@DataProvider(name = "changerequest")
	public String[] fetchData()
	{
	String[] filePath = new String[2];
	filePath[0] = "./data/createIncident.json";
	filePath[1] = "./data/createIncident.json";
	return filePath;
    }
	
	@Test(dataProvider = "changerequest")
	public void createIncidentWithBody(String filePath)
	{
		
	}
} 