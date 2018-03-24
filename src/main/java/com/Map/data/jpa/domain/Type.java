package com.Map.data.jpa.domain;

import javax.persistence.*;

@Entity(name = "Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TYPE")
    private int idType;
    @Column(name = "TYPE_NAME")
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        typeName = typeName;
    }

    public int getIdType() {
        return idType;
    }


}
