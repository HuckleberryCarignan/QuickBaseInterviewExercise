# QuickBaseInterviewExercise

API Automation Exercise

* Coding Exercise 1:

Build a Java Class that returns the a list containing the Largest and Second Largest Number from a static List of Integers
Call the method twice and pass in different lists as arguments

Use the following lists:  *{ 5,100,10,125,15,150,20,175,25,0 }*,  *{ 25,93,97,18,71,114,52,48 }*

Result: The method returns both the largest and second largest number in each list

* Coding Exercise 2:

Given the Java class implemented from exercise 1:
Add a size limit check to the implementation from exercise1 that throws an IllegalArgumentException if size of the list less than two.
Create the test cases and class(s) needed to validate the implementation from exercise1

Result: Test class and associated framework implemented


Note to the reviewers:

I implemented the TestNG framework using @dataProvider.  This allowed me to more easily create additional test cases now (and down the road).  In the future I would merge the two @Test and pull out the testing objects and methods into an @BeforeTest
