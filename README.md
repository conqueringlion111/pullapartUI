UI test automation framework for pullapart.com using Selenium Java, testNG and Maven.

To run the suite from the command line run the following, open testconfig.properties file, set runFromSuite = true then run the following command:  mvn  test -Dsurefire.suiteXmlFiles=testsuite.xml -Dtest.env=https://www.pullapart.com/ -Dgroups=regression

To view the test results cd into the project, cd into the following path: /home/sando1/workspace/pullapartUI/target/surefire-reports   next open the emailable.html and extentReport.html with a browser of your choice
