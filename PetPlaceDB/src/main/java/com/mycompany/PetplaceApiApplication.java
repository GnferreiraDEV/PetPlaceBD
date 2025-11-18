package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetplaceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplaceApiApplication.class, args);

        System.out.println("SERVIDOR API DO PETPLACE INICIADO!");
        System.out.println("Acesse em: http://localhost:8080");
    }

}