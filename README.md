selenium2-tests
===============

This project is intended to be a reference project for selenium test suites.  It's based on the principles of the Page Object pattern.

The goal is to turn this project into a Maven Archetype to make UX Navigation Flow Tests easy to stand up for any given project.

Suggestion and contributions are welcome and feel free to use this code.  

Currently I could use help with the HtmlUnit excessive logging.

Usage
=====

From a command prompt type:

mvn clean verify

Notes
=====

Googles Chrome Web Driver is a special beast as it requires one additional piece of infrastructure to be installed on your machine.

You must have the Chrome Driver Server installed.  Documentation on this can be found at [Chrome Web Driver Documentation](https://code.google.com/p/selenium/wiki/ChromeDriver) and the downloads can be found at [Chrome Driver Server](https://code.google.com/p/chromedriver/downloads/list) 
