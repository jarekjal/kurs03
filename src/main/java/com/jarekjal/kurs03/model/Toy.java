package com.jarekjal.kurs03.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Toy {
    private Integer id;
    private String name;

    public Toy() {
        System.out.println("Constructor dla " + this.getClass().getSimpleName()
                + " (o: " + LocalDateTime.now() + ")");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println("I bawimy się!");
    }
}
