package com.govdvla.getvehicledetail;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetVehicleInformationStepDef {
	
	GetVehicleInformation getVehicleInfo = new GetVehicleInformation();

	@Given("^open the DVLA Get Vehicle Information webpage$")
	public void open_the_DVLA_Get_Vehicle_Information_webpage() throws IOException {
		getVehicleInfo.openGetVehicleInfoForm();
	}

	@When("^enter the vehicle registration number \"([^\"]*)\"$")
	public void enter_the_vehicle_registration_number(String regno) throws Throwable {
		getVehicleInfo.clickOnStartNow();
		getVehicleInfo.enterVehicleNumber(regno);
		getVehicleInfo.clickOnContinue();
	}

	@Then("^get the vehicle minimum information to confirm and get full details: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void get_the_vehicle_minimum_information_to_confirm_and_get_full_details(String regno, 
																		String make, String colour) throws Throwable {
		if ((getVehicleInfo.getVehicleRegNumber()).equalsIgnoreCase(regno)
				&&
				(getVehicleInfo.getVehicleMake()).equalsIgnoreCase(make)
				&&
				(getVehicleInfo.getVehicleColour()).equalsIgnoreCase(colour)
				)
		{
			getVehicleInfo.clickOnYesToConfirm();
			getVehicleInfo.clickOnContinue();
		}
		
		else
		{
			System.out.println("Vehicle is not matching, please re-run the test with correct vehicle details.");
		}
		
	}

	
	@Then("^navigate to full vehicle information to verify the details:$")
	public void navigate_to_full_vehicle_information_to_verify_the_details(DataTable vehicleTable) throws Throwable {
	    
		List<List<String>> data = vehicleTable.raw();
				
		assertEquals(getVehicleInfo.getVehicleDetails().get(0),data.get(0).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(1),data.get(1).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(2),data.get(2).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(3),data.get(3).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(4),data.get(4).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(5),data.get(5).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(6),data.get(6).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(7),data.get(7).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(8),data.get(8).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(9),data.get(9).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(10),data.get(10).get(1));
		assertEquals(getVehicleInfo.getVehicleDetails().get(11),data.get(11).get(1));
		
	}
	
}
