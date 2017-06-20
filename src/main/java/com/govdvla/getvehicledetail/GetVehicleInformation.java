package com.govdvla.getvehicledetail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.govdvla.utilities.DriverInstance;


public class GetVehicleInformation extends DriverInstance 
{

	public void openGetVehicleInfoForm() throws IOException
	{
		getDriver().navigate().to("https://www.gov.uk/get-vehicle-information-from-dvla");
	}

	public void clickOnStartNow() throws IOException
	{
		getDriver().findElement(By.xpath("//p[@id='get-started']/a")).click();
	}

	public void enterVehicleNumber(String vehicleNumber) throws IOException
	{
		getDriver().findElement(By.id("Vrm")).sendKeys(vehicleNumber);
	}

	public void clickOnContinue() throws IOException
	{
		getDriver().findElement(By.name("Continue")).submit();
	}

	public String getVehicleRegNumber() throws IOException
	{
		String vehicleRegNum = getDriver().findElement(By.xpath("//ul//li[@class='list-summary-item']"
				+ "/span[contains(text(),'Registration')]/following-sibling::span")).getText();

		return vehicleRegNum;
	}

	public String getVehicleMake() throws IOException
	{
		String vehicleMake = getDriver().findElement(By.xpath("//ul//li[@class='list-summary-item']"
				+ "/span[contains(text(),'Make')]/following-sibling::span/strong")).getText();
		return vehicleMake;
	}

	public String getVehicleColour() throws IOException
	{
		String vehicleColour = getDriver().findElement(By.xpath("//ul//li[@class='list-summary-item']"
				+ "/span[contains(text(),'Colour')]/following-sibling::span/strong")).getText();

		return vehicleColour;
	}

	public void clickOnYesToConfirm() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//div//fieldset[@class='inline']"
				+ "//label[@for='Correct_True']")).click();;		
	}

	public ArrayList<String> getVehicleDetails() throws IOException
	{
		ArrayList<String> vehicleInfo = new ArrayList<String>();
		List<WebElement> vehiclesDetails = getDriver().findElements(By.xpath("//ul[@class='list-summary']"
				+ "//li[@class='list-summary-item']//span//strong"));
		for(WebElement vehiclesDetail : vehiclesDetails){
			vehicleInfo.add(vehiclesDetail.getText());
		}
		return vehicleInfo;  
	}

	public void closeWebPage() throws IOException
	{
		getDriver().quit();
	}


}
