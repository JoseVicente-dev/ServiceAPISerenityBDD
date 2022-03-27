package co.com.sofka.stepdefinitions.common;

import org.apache.log4j.PropertyConfigurator;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;

public class ServiceSetUp {
    protected static final String BASE_URI = "https://reqres.in/api";
    protected static final String RESOURCE_SINGLE_USER = "/users/2";
    protected static final String RESOURCE_SINGLE_USER_NOT_FOUND = "/users/23";
    protected static final String RESOURCE_CREATE ="/users";

    protected void generalSetUp(){
        setUpLog4j2();
    }

    private void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.getValue()  + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
