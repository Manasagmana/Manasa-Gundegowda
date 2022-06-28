# Manasa-Gundegowda

Instruction on the test suite:

Setup:
1.Java version 15 or lower. I have used java 15.02
2.TestNg plugin added in eclipse.
3.Appium server

How to run:

1.Start the server
2.Right click on the testng.xml file and click Run as "TestNGsuite"

TestNg framework is used with appium in the Project.

Reasons for chosing Testng:
1. Parameterising test cases is supported.
2. Parallel execution of test methods.
3. Priority to test methods
4. Grouping of test methods into test groups.
5. Open source and is widely used.

Test cases for automation:

1. Verifying if the home page is displayed successfully.
2. Verifying if Income is added successfully.
3. Verifying  the  amount of incomes added in the list with the income account displayed in the pie graph.
4. Verifying if the expense is added successfully.
5. Verifying  the  amount of expenses added in the list with the expense account displayed in the pie graph.
6. Verifying if different payment methods chosen are updated in the pie graph.
7. Verifying if the  budget is divided awith respect to different time period chosen 
8. Verifying if the transfer is successfull.
9. Verifying if the budget is added successfully and displayed in the pie graph
10. Verifying if the selected currency is displayed.
11. Verifying if the export file is sent.
12. Verifying if synchronisation is achieved.
13. Verifying if data backup is achieved by all the 3 methods.
14. Verifying the balance with respect to Income and expense.

Device used: Redmi note pro.

I was unable to write all the test cases mentioned above as Appium inspector was not navigating to next pages with the device connected. Was unable to use UI automator viewer as the device has issues in connecting to UI Automator.

