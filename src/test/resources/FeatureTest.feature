Feature: Get Vehicle Information

Scenario Outline: Get vehicle info and verify the details

Given open the DVLA Get Vehicle Information webpage
When enter the vehicle registration number "<regno>"
Then get the vehicle minimum information to confirm and get full details: "<regno>", "<make>", "<colour>"
And navigate to full vehicle information to verify the details:
|Make|<make>|
|FirstRegDate|<firstregdate>|
|YearManufacture|<year>|
|CylinderCapacity|<capacity>|
|CO2Emissions|<emission>| 
|FuelType|<fueltype>| 
|ExportMarker|<export>| 
|TaxStatus|<taxstatus>| 
|Colour|<colour>|
|TypeApproval|<typeapproval>|
|WheelPlan|<wheelplan>| 
|RevenueWeight|<revenueweight>| 

#Examples:
#|regno|make|colour|
#|DF51 FND|HONDA|BLUE|

Examples:
|regno|make|colour|firstregdate|year|capacity|emission|fueltype|export|taxstatus|typeapproval|wheelplan|revenueweight|
|DF51 FND|HONDA|BLUE|February 2002|2002|1396 cc|153 g/km|PETROL|No|Tax not due|M1|2 AXLE RIGID BODY|Not available|
|LT65 RWJ|NISSAN|SILVER|November 2015|2015|1198 cc|117 g/km|PETROL|No|Tax not due|M1|2 AXLE RIGID BODY|Not available|
