package com.jarekjal.kurs03.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Dog {
    private Integer id;
    private String name;
    @Autowired
    private Toy toy;

    public Dog() {
       System.out.println("Constructor dla " + this.getClass().getSimpleName()
        + " (o: " + LocalDateTime.now() + ")");
    }

    public Dog(String name){
        this.name = name;
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

    public void sayHallo(){
        System.out.println("Hello, I am " + name);
        toy.play();
    }
}
