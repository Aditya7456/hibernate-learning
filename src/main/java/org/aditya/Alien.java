package org.aditya;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int aid;
    //@Column(name="alien_name") to change the column name in database
    private String aname;
    //@Transient // if we don't want this variable to store in database then we can use this annotation
    private String tech;
    //@OneToOne // one alient having one laptop so using OneToONe mapping
    // one alien having mulitple laptops
    /*
    By this mappedBy we are telling to Alient class that you don't create any
    new table to keep the reference, let it handle by the mappedBy variable or
    other class;
    here "alien" is the variable name used in Laptop class
     */
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
