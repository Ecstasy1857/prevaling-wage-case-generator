# prevaling-wage-case-generator
Generates prevailing wage case numbers based on supplied the criteria. This is useful to search your pwd case number if not already known. This still involves trial and error but with this tool it becomes easier narrow down your search

# How To use this tool?
You can use this tool as a command line jar or  import the maven project in eclipse (requires java 1.8).

Usage: 

**java -jar pwd.jar startingSequence=123456 julianDate=21184 increment=10 randomIncrement=true upperBound=150 lowerBound=50**

Required parameters:  julianDate, startingSequence

Default values:
  increment=20
  randomIncrement=false
  upperBound=150
  lowerBound=20
  
  # How to approach your search?
  
  PWD numbers has format P-100-21184-333444 where P-100 is static,  21184 is the date your request was submitted in julian calendar, 333444 is the random number.
  1. You need to first identify the date on which your request was submitted. If possible get the approxiate time like morning, evening, etc.
  2. Get any existing PWD number nearer to your date. With this it will become easier to search your case number. 
  3. 
  
  
