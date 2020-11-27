
# README - (Written by Caroline Wang)

## Implementation Details:

Below are the software design principles I aimed to include in this implementation:

  *  <h3>Modularity & Cohesion </h3> Coffee and Tea subclasses are organized into clearly defined packages that are separate from where the MenuOrder and Beverage classes are - an example of implemented modularity. If a developer needs to add a new type of coffee or tea, its clear where they would add this class. These classes are also grouped based on similarity of concepts and data - an example of Cohesion.
   
  *  <h3>Inheritance</h3> The 6 types of coffee & tea (Green Tea, Yellow Tea, Americano, Latte etc...) are child clsases that extend from a Tea and a Coffee abstract class. Additionally, both Tea and Coffee also extend from an abstract class of Beverage. Inheritance allows the sugar and milk count attributes to be assigned on the Coffee parent class but then extended to all 3 types of Coffee subclasses. All three of these child classes will need to contain the customer's customized milk / sugar counts - so they automatically keep this inherited property. In the future, if we wanted to add a property such as "iced" or "hot" - Inheritance allows us to assign this property at the Beverage parent level. This way, any Coffee or Tea object extended from this Beverage class will maintain the iced or hot specification. We do not need to repeatedly assign this at every subsequent child class level. 
   
  *  <h3>Encapsulation</h3> All attributes are declared as private and only retrieved via public getters and edited via public setters.

  *  <h3>Robustness</h3> The ability to handle multiple user-inputs was the main challenge of the MenuOrder class. The "Menu" portion of the code prompts the user to enter inputs to select their choices. In order to handle multiple input errors and maintain "Robust" code, try / catch blocks were added to handle incorrect data types, switch statements and if/else statements were added with default options to handle inputs that were not listed as menu options. 
  
Other notes:

  *  <b>How flexible is the implementation? </b> If a future developer needed to add a new tea or coffee type, they can follow the existing templates of the 6 subclasses and create a new subclass that extends either coffee or tea. What will be harder to modify is the main menu. If more options are added, this main menu will need to be separated into its own smaller class components.
  
  *  <b>How is the simplicity and understandability of your implementation? </b> The class names and methods are very readable. The area for improvement for simplicity would be the menu order and handling different inputs. Additionally, future release should revisit the way objects are created. Right now, a large case switch statement controls which subclass is created for the 6 types of drinks. A design pattern could potentially simplify this. 
  
  *  <b>How did you avoid duplicate code? </b> The program uses inheritance to avoid duplicate property assignment. Assignment of object properties based on menuOrder properties is also wrapped in a method that is called whenever the drink is being created - avoiding assignig properties many times. However, code is still duplicated largely in the menu order class. Code is duplicated when the logic splits into Coffee and Tea. A future release should revisit these blocks of code. If the requirement for Tea is changed so that it also accepts milk and sugar, this code redundancy can be removed. 
    
    
   


### Assumptions:

Below are the Developer's Assumptions from the Business Requirements. These are listed to be revisited and clarified by users and clients - or to spur discussions for future releases. 

1) Requirements specify that "coffee machine" adds sugar and milk. We assume then the functionality to add sugar and milk is provided only for coffee - NOT tea.

2) We assume that included in the scope of this project, we are creating a Java object to represent the actual beverage item. This object is passed back to the client application    with all the data provided on beverage customization. 

3) We assume that the customer will be able to see what we System.out.print for menu options. 
   The customer will need to interact with the main menu and this main menu is currently programmed as print lines in the console. We assume customer can view and access this. 
   
4) We assume that per one order session, we only order one beverage. We do not have the option to order multiple beverages in this release. 

3) We assume the only options are Tea and Coffee - we do not provide cold beverages in this release.

4) We assume there is no requirement for this release to cancel the order or return back to the main menu to modify details. 








# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

We recommand the above command for running the project. 

Alternativly, you can run the following command. It will generate a single jar file with all of the dependencies. 

```bash
mvn clean compile assembly:single

java -Dlog4j.configuration=file:log4j.properties -classpath ./target/JavaProjectTemplate-1.0-SNAPSHOT-jar-with-dependencies.jar  edu.bu.met.cs665.Main
```


# Run all the unit test classes.


```bash
mvn clean compile test

```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```


For more info about FindBugs see 

http://findbugs.sourceforge.net/

And about Maven Findbug plugin see 
https://gleclaire.github.io/findbugs-maven-plugin/index.html


You can install Findbugs Eclipse Plugin 

http://findbugs.sourceforge.net/manual/eclipse.html



SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

You can find more info about coveralls 

https://coveralls.io/

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


