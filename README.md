selenium2-tests
===============

This project is intended to be a reference project for selenium test suites.  It's based on the principles of the Page Object pattern.

The goal is to turn this project into a Maven Archetype to make UX Navigation Flow Tests easy to stand up for any given project.

Suggestion and contributions are welcome and feel free to use this code.  

Usage
=====

Execution
---------

From a command prompt type:

mvn clean verify

Changing Environments
---------------------
The environment settings are controlled in the pom.xml as part of the profile.  To change simply modify the following section of code:
'	<profiles>
		<profile>
			<id>SeleniumTest</id>
			<activation>
				<activeByDefault>true</activeByDefault>
			</activation>
			<properties>
				<environment>qa</environment>
			</properties>
		</profile>
	</profiles>'

Notes
=====

Google Chrome
-------------

Googles Chrome Web Driver is a special beast as it requires one additional piece of infrastructure to be installed on your machine.

You must have the Chrome Driver Server installed.  Documentation on this can be found at [Chrome Web Driver Documentation](https://code.google.com/p/selenium/wiki/ChromeDriver) and the downloads can be found at [Chrome Driver Server](https://code.google.com/p/chromedriver/downloads/list)

Logging
-------
log4j has been defaulted as the Logging framework for the test suite.  Each environment has it's own configuration so if in development you want to log output to an appropriate appender simply update the log4j.xml.

If you downgrade Selenium to version 2.33 be forewarned that it includes a defect that someone left a hardcoded System.err.println statement that will blow up your console output with HtmlUnit statements. 
