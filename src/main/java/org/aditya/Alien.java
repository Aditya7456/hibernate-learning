package org.aditya;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    //@OneToMany(mappedBy = "alien")
    /*
        @ManyToMany creating 2 more reference table for mapping
        because both class is thinking it is their responsibility
        to map the table.
        We have to tell them one of you map it, not both
     */
    //@ManyToMany
    /* if we have a collection in entity so by default
       it use lazy-fetch and don't load the entire object until it neeeded
       EAGER -> it fetches entire object even if it is not needed.
         */
    @OneToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public int getAid() {
        return aid;
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
