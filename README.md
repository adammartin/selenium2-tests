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

How to Add Tests
----------------
Fundamentally this is a JUnit testing style project.  As a developer you simply need to do the following:

* Clone the project
* Enable/Disable the authentication in the selenium.properties file
	+ 'selenium.auth.active' activates the authentication mechanism.
    + 'selenium.auth.usergroup' sets the user id to authenticate.
    + 'selenium.auth.password' sets the password to authenticate.  This allows security to control the password actually used at runtime during deployment if necessary.  This is so that the security team can keep staging or prod passwords secure and not checked into SCM if necessary.  They can at deploy time swap the property file out or even set this one variable.
	+ 'selenium.auth.element.name.password' sets the name attribute when searching for the password field
	+ 'selenium.auth.element.name.user' sets the name attribute when searching for the user id field.
	+ 'selenium.auth.element.page.title' sets the title of the login page to assert we have the login page correct.
* Set the appropriate driver (html, chrome, and firefox are all currently supported).  I have plans to try and make this a comma seperated configuration so we can run the suite in multiple browsers.
* Finally extend your first test from BaseNavigationTest which bootstraps our testing framework.  I believe there is a more sophisticated way to handle this via annotations (perhaps a custom annotation or two) but this currently works.

How to Add PageObjects
----------------------
Coming Soon!

Changing Environments
---------------------
The environment settings are controlled in the pom.xml as part of the profile.  To change simply modify the following section of code:
<pre>
	<code>
		&lt;profiles&gt;
			&lt;profile&gt;
				&lt;id&gt;SeleniumTest&lt;/id&gt;
				&lt;activation&gt;
					&lt;activeByDefault&gt;true&lt;/activeByDefault&gt;
				&lt;/activation&gt;
				&lt;properties&gt;
					&lt;environment&gt;<b>qa</b>&lt;/environment&gt;
				&lt;/properties&gt;
			&lt;/profile&gt;
		&lt;/profiles&gt;
	</code>
</pre>

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
