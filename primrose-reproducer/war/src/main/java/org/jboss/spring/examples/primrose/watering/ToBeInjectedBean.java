package org.jboss.spring.examples.primrose.watering;

public class ToBeInjectedBean {

    private String message = "I am to be injected into EJB";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
