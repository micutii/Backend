package com.Map.data.jpa.domain;

import javax.persistence.*;

@Entity(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EVENT")
    private int idEvent;
    @Column(name = "ID_PIN")
    private int idPin;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DETAILS")
    private String details;
    @Column(name = "STATE")
    private int state;

    public int getIdPin() {
        return idPin;
    }

    public void setIdPin(int idPin) {
        this.idPin = idPin;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
