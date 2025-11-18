/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factory;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Gustavo
 */
public class MongoConnectionFactory {

    private static final String URI = 
        "mongodb+srv://Gnferreira:admin123@petplacebd.82fyloi.mongodb.net/?appName=PetPlaceBD";

    private static MongoClient client;

    public static MongoDatabase getDatabase() {
        if (client == null) {
            client = MongoClients.create(URI);
        }
        return client.getDatabase("PetPlaceBD");
    }
}

    

