package com.mycompany; // O pacote raiz

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // <-- A mágica acontece aqui
public class PetplaceApiApplication {

    public static void main(String[] args) {
        // Esta linha inicia o servidor web e toda a sua aplicação
        SpringApplication.run(PetplaceApiApplication.class, args);

        System.out.println("SERVIDOR API DO PETPLACE INICIADO!");
        System.out.println("Acesse em: http://localhost:8080");
    }

}