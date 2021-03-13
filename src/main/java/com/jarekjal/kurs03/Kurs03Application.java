package com.jarekjal.kurs03;

import com.jarekjal.kurs03.model.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Kurs03Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Kurs03Application.class, args);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Bonzo"));
        dogs.add(new Dog("Pikuś"));

        List<Dog> newDogs = dogs.stream()
                .filter(dog -> "Bonzo".equals(dog.getName()))
                .peek(dog -> dog.setName("Rex"))
                .collect(Collectors.toList());

    }

}
