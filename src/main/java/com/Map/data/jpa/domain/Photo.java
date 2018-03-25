package com.Map.data.jpa.domain;

import javax.persistence.*;

/**
 * Created by easyw on 25-Mar-18.
 */
@Entity(name = "PHOTO")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PHOTO")
    private int idPhoto;
    @Column(name = "ID_PIN")
    private int idPin;
    @Column(name = "base64photo")
    private String base64photo;
    @Column(name = "STATE")
    private int state;
    @Column(name = "USER_NAME")
    private String userName;

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public int getIdPin() {
        return idPin;
    }

    public void setIdPin(int idPin) {
        this.idPin = idPin;
    }

    public String getBase64photo() {
        return base64photo;
    }

    public void setBase64photo(String base64photo) {
        this.base64photo = base64photo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
