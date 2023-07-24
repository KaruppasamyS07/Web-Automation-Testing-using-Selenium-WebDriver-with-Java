PROJECT DESCRIPTION:

Problem Statement : Finding Hospitals
1. open practo website
2. print hospital Names and cities
3. provide invalid details

  
Detailed Description: Main Project

1.open practo website
2.select a city name of bangalore in a drop-down box
3.select a hospital in bangalore in a drop-down box
4.print the hospital names which is having 24/7 open and with morethan 3.5 ratings
5.In home page, click diagnosis page
6.print the cities which are all presence in the page
7.In home page, click corporate wellness page
8.fill invalid details
9.Take screenshot 
10.close the website



Technology Used In the Project 
Selenium
Java
Maven
Apache POI
TestNG
Extend Report
POM - Page Object Model
  

Key Automation Scope:

Capturing the screenshot
Navigation to new page
Printing all the values in console


**********************************************************STEPS TO EXECUTE*************************************************************

-unzip the folder
-On eclipse, goto file->import->select the mavan->click on existing mavan project->next->browse the location where u unzip the folder-> click on finish
-Now go to the TestNG.xml file and run as TestNGSuite.
-Now the file will Execute and we get the expected output as shown below.

*******************************************************FILES DESCRIPTION**************************************************************

1.src/main/java - There are three packages present in this folder.
->   config.properties : In this File we have url.
    
-> Base:In this package we have Base.java is our main project file in which we Firstly invoke the selected browser and  format and Open the practo page (https://www.practo.com/) and fetching data from excel and closing the browser
     
->Pages:In this package we have hospitalNames.java which extends base.java where the methods are present which will print hospital Names and cities and fill invalid details.

2.src/test/java- There are two files in this folder.
->  TestSuites   :In this package, test cases.java calling all the method from this class only by creating object to the class, extend report, testNG concepts implemented.

->TestNG.xml - In this file, the test classes are defined

3.src/test/resources- In this folder, there is one invalid Details.xlsx, Which will fetch the datas from excel to fill invalid details

4.JRE System Library: In this File we have all dependencies of JAR.files.         

5.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,
Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.

7.Report: In this folder, the extend Report.html is present which is the report of the project

8.ScreenShot:In this folder, there is an screenshot name is corporate wellness.png, Hospital results.png, Popular Cities.png separately for chrome and edge

9.src: In this, there are two folders
	-main:It is an empty folder
	-test:It is an empty folder

10.target: It is an empty folder
 
11.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

 
***************************************************************************************************************************************

                                                        OUTPUT ON CONSOLE

***************************************************************************************************************************************

200 - Server response is good 

-----------------------
The 24/7 Hospitals are

Smiles Institute of Gastroenterology
Practo Hospitals - Neo
Manipal Hospitals Yeshwanthpur
Koshys Hospital
Apollo Cradle & Children’s Hospital
NU Hospitals
Cloudnine Hospital - Old Airport Road
Cloudnine Hospital
Jayashree Speciality Hospital
Ovum Woman & Child Specialty Hospital

Finding Hospitals Page Passed
----------------
The Popular Cities are :
Bangalore
Delhi
Mumbai
Chennai
Hyderabad
Kolkata
Pune

Book Diagnosis Page passed
-----------------------------
Corporate Wellness page passed
-----------------------------

Starting Microsoft Edge WebDriver 114.0.1823.18 (8b9609669814d9cfea3542ea61f14425e1212100) on port 16031
To submit feedback, report a bug, or suggest new features, please visit https://github.com/MicrosoftEdge/EdgeWebDriver

Only local connections are allowed.
Please see https://aka.ms/WebDriverSecurity for suggestions on keeping Microsoft Edge WebDriver safe.

Microsoft Edge WebDriver was started successfully.

-----------------------
The 24/7 Hospitals are

Dr. Mehta's Hospitals
Gleneagles Global Health City
MIOT International Hospital
Apollo Spectra Hospital
Cloudnine Hospital
VS Hospitals - Centre for Advanced Surgeries and Tertiary Care
SIMS Hospital
Bharathirajaa Hospital
KKR Hospital
Hande Hospital - Laser Piles Centre
Cloudnine Fertility - IVF Centre, T-Nagar

Finding Hospitals Page Passed
----------------
The Popular Cities are :
Bangalore
Delhi
Mumbai
Chennai
Hyderabad
Kolkata
Pune

Book Diagnosis Page passed
-----------------------------
Corporate Wellness page passed
-----------------------------


===============================================
Suite
Total tests run: 22, Passes: 22, Failures: 0, Skips: 0
===============================================
