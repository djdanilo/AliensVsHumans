Aliens vs. Humans Junit Codecademy Project
In this Codecademy project we were supposed to make a skeleton for a game called Aliens vs. Humans doing so in a TDD type manner. The parameters we were given were that we had to have at leaset one Human class and one Alien class and that the Aliens had to have different functionality than the Humans. We also had to test everything that we wrote in Junit tests. I chose to go with an Aliens vs Predator movie type theme here giving different functionality to the Aliens, Humans, and Predators.

Intended Use
This code is not intended to be used in any actual game project and is only for educational purposes to learn about Test Driven Development. The code is here to showcase that I completed the Aliens vs. Humans project at Codecademy. The code can be pulled from my GitHub so you can examine the functionality of it on your own computer. I provided a .sh bash file for everyone's convienience to run the tests in a Linux terminal. To execute the tests all you need to do is type ./runTest.sh in your terminal. IMPORTANT Always carefully inspect any .sh shell file or .bat bat file you are executing from another source to make sure you are not running malicious code. If you don't know what that means then learn about .sh and .bat shell scripts before trusting anyone else's.

Quick Note For Windows Users
I only included a .sh file with this Java package. If you wish to run it you will need to do download a linux terminal that will run in Windows if you don't already have one. Otherwise just examine the .sh file contents and execute the commands inside the file in the file directory where you downloaded the Aliens vs. Humans project.

Codebase Contents
The project has the following files in the codebse:

Alien.java - Child class of the Character super class
AvhTest.java - The file containing all the Junit tests.
Character.java - The main parent class from which all other child classes extend.
Communicate.java - Communication interface which the Character class implements.
Compass.java - Class which controls compass functionality which each character in the game has.
Grey.java - Child class of the Alien subclass.
Hugger.java - Child class of the Alien subclass.
Human.java - Child class of the Character super class.
junit-jupiter-api-5.9.3.jar - Jar file which allows the JVM access to tests which the Junit console understands. This file was obtained from https://repo1.maven.org/maven2/org/junit/jupiter/junit-jupiter-api
junit-platform-console-standalone-1.9.3.jar - Jar file which allows you to compile and run junit tests from the command line. This file was obtained from https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/
Predator.java - Child class of the Alien subclass.
README.md - The file you are reading right now.
runTest.sh - Holds the linux commands to run the Junit tests for this codebase.
TranslatorObjects.java - Enum which holds all the TranslatorObjects constants in the game.
Translators.java - Class which allows you to easily create a dictionary mapping Character Species to TranslatorObjects needed to communicate with them.
Weapon.java - Enum which holds all the weapon constants and the Species that can yield them.
Xenomorph.java - child class of the Alien subclass.
Requirements
The two .jar files that come with this project are required in order to run the Junit 5 tests. These are vanilla Junit 5 tests that can be run in any linux terminal without installing any special terminal interfaces like Maven for example.

Quick note about runTest.sh
The runTest.sh file is only here for your convienience so you can easily run the tests via the terminal. Every time you want to compile and run your tests again you need to enter two somewhat verbose terminal commands which can get very annoying. If you already have a different way of running your Junit 5 tests such as through an IDE or a different terminal interface using pom.xml files and the like totally disregard the runTest.sh file and use that instead. The two commands in this .sh file are a javac -cp command and a java -jar command. These commands are the easiest way to run Junit 5 tests in your terminal without installing a third party IDE or command line interface.

What I Learned From This Project
This project taught me that TDD was a lot less scary than I had first imagined it to be. I felt like CodeCademy threw us to the wolves on this one. The course work prior to this project was very anemic and that was based on Junit 4. It took me some work to find how to do Junit 5 tests in the command line due to me using NVIM as my go to editor. Once I managed to find the proper requirement files and terminal commands I needed I could quickly see the power in TDD with Junit 5. Not only did it provide me with a framework to be able to write the code I wrote the tests for that I had not yet written it gave me documentation of what my code did and at what version of your codebase your code did it. I noticed that I could write larger chunks of code at once because I didn't have to stop and test everything in an intermittant fasion. I would just write a couple of tests in advance then write the code to make those tests pass and everything just worked out. I am definitely going to take a more in depth TDD course soon in the future.
