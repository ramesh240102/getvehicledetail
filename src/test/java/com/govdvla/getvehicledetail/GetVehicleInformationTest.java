package com.govdvla.getvehicledetail;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.govdvla.utilities.FileReader;

public class GetVehicleInformationTest 
{
	GetVehicleInformation getVehicleInfo = new GetVehicleInformation();
	FileReader fileReader = new FileReader();

	@BeforeSuite
	public void openWebPage() throws IOException
	{
		getVehicleInfo.openGetVehicleInfoForm();
	}

	@Test
	public void verifyVehicleInformation() throws IOException, InterruptedException
	{
		/*
		 * Entering the vehicle registration number and get the initial information
		 */
		getVehicleInfo.clickOnStartNow();
		getVehicleInfo.enterVehicleNumber(fileReader.fetchPropValue("RegNo"));
		getVehicleInfo.clickOnContinue();
		
		/*
		 * Verify the initial information and confirm to continue to fetch more complete details of vehicles
		 */
		assertEquals(getVehicleInfo.getVehicleRegNumber(),fileReader.fetchPropValue("RegNo"));
		assertEquals(getVehicleInfo.getVehicleMake(),fileReader.fetchPropValue("Make"));
		assertEquals(getVehicleInfo.getVehicleColour(),fileReader.fetchPropValue("Colour"));
		
		getVehicleInfo.clickOnYesToConfirm();
		getVehicleInfo.clickOnContinue();
					
		/*
		 * Asserting the complete vehicle details
		 */
		assertEquals(getVehicleInfo.getVehicleDetails().get(0),fileReader.fetchPropValue("Make"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(1),fileReader.fetchPropValue("FirstRegDate"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(2),fileReader.fetchPropValue("YearManufacture"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(3),fileReader.fetchPropValue("CylinderCapacity"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(4),fileReader.fetchPropValue("CO2Emissions"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(5),fileReader.fetchPropValue("FuelType"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(6),fileReader.fetchPropValue("ExportMarker"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(7),fileReader.fetchPropValue("TaxStatus"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(8),fileReader.fetchPropValue("Colour"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(9),fileReader.fetchPropValue("TypeApproval"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(10),fileReader.fetchPropValue("WheelPlan"));
		assertEquals(getVehicleInfo.getVehicleDetails().get(11),fileReader.fetchPropValue("RevenueWeight"));
		

	}

	@AfterSuite
	public void closeWebPage() throws IOException
	{
		getVehicleInfo.closeWebPage();
	}
}
