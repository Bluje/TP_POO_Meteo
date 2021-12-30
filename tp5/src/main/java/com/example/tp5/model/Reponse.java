package com.example.tp5.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Reponse {


    @Id
    @GeneratedValue
    private Long id ;
    private float coordinate1 ;
    private float coordinate2 ;
    private String content ;
    private String auteur ;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getCoordinate1() {
        return coordinate1;
    }
    public void setCoordinate1(float creation) {
        this.coordinate1 = coordinate1;
    }
    public float getCoordinate2() {
        return coordinate2;
    }
    public void setCoordinate2(float creation) {
        this.coordinate2 = coordinate2;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuteur(){ return auteur;}
    public void setAuteur(String auteur) { this.auteur = auteur;}

}
