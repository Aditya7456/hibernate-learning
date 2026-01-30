package org.aditya;

import jakarta.persistence.*;

import java.util.List;

//@Embeddable // so that we can embed in alien table without creating a new laptop table
@Entity
public class Laptop{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;
    private String brand;
    private String model;
    private int ram;
    //@ManyToOne
    @ManyToMany(mappedBy = "laptops") // it will not do its mapping
    private List<Alien> aliens;

    public int getLid() {
        return lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
