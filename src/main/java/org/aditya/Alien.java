package org.aditya;

import jakarta.persistence.*;

// if i add the name property in @Entity then it will change the entity and table name both
// but if i use the @Table property then it will change the table name only
//@Entity(name = "alien_details")
@Entity
//@Table(name = "alien_details")
public class Alien {
    @Id
    private int aid;
    //@Column(name="alien_name") to change the column name in database
    private String aname;
    //@Transient // if we don't want this variable to store in database then we can use this annotation
    private String tech;
    @OneToOne // one alient having one laptop so using OneToONe mapping
    private Laptop laptop;

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

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
