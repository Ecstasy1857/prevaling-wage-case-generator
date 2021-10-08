# prevaling-wage-case-generator
Generates prevailing wage case numbers based on the supplied criteria. This is useful to search your pwd case number if not already known. This still involves trial and error but with this tool it becomes easier to narrow down your search. This tool will output a url with case numbers that you can paste in the browser to get all the results.

# How To use this tool?
You can use this tool as a command line jar or  import the maven project in eclipse (requires java 1.8).

PWD numbers has format P-100-21184-333444 where P-100 is static, 21184 is the date your request was submitted in julian calendar, 333444 is the random number.

Usage: 

**java -jar pwd.jar startingSequence=123456 julianDate=21184 increment=10**

or

**java -jar pwd.jar startingSequence=123456 julianDate=21184 randomIncrement=true upperBound=150 lowerBound=50**

or

**java -jar pwd.jar startingSequence=123456 julianDate=21184  randomIncrement=true** 

or

**java -jar pwd.jar startingSequence=123456 julianDate=21184** 

Required parameters:  julianDate, startingSequence

**julianDate** =  Date on which your request is submitted in julian calender.  http://www.longpelaexpertise.com/toolsJulian.php

**startingSequence** -  6 digit random number you want to start searching from. See "How to approach your search?" for determining starting Sequence

**increment** -  this number will be added to case number to determine the next case number and so on..

**randomIncrement** -true/false value,   Use this to add any random number between give upperBound and lowerBound, increment paramter will be ignored

**upperbound/ lowerBound** -  a random number will be generated between upperBound and lowerBound and will be added to the case number number to generate the next case number.


Default values:

  increment=20,
  randomIncrement=false.
  upperBound=150,
  lowerBound=20
  
  **This will ouput a url that you can hit in browser to search for the cases. You can search upto 200 at a time.**
  
  # How to approach your search?
  
  PWD numbers has format P-100-21184-333444 where P-100 is static,  21184 is the date your request was submitted in julian calendar, 333444 is the random number.
  1. You need to first identify the date on which your request was submitted. If possible get the approxiate time like morning, evening, etc.
  2. Get any existing PWD number nearer to your date. With this it will become easier to search your case number. For example: July 9 pwd is P-100-21187-222333 and your pwd was submitted on July 11 then your 6 digit random number would be after 222333 and probably between 23XXXX and 25XXXX.  
  3. First Use randomIncrement to generate case numbers and see if you find any valid cases for your date. You might need to do mulitple times using different starting sequence number.
  4. Once you have identifed any case for your date, now if you know the time at which your case was submitted you can pick 2 case numbers that encompasses your submit time and then use increment option to generate all cases between that time. For example:  your case was submitted in morning at around 10 am and you find a case number P-100-21184-222222 at 9 am and another case P-100-21184-222233 at 11 am, then your 6 digit random number can be between 222233 and 222222. You would use increment of 1 and starting sequence 222222 and generate all case numbers between these 2 numbers to find your case.
  5. If you dont know the time then you have to generate all cases for the day (12 am to 11:29 PM) to find out your case number.
  
  
