package me.cerratolabs.eatnow.server;

import java.security.NoSuchAlgorithmException;

public class MClass {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Pruebas pruebas = new Pruebas();
        System.out.println(pruebas.isValidAccount("pepe","jose"));
        System.out.println(pruebas.isValidAccount("pepe","miguel"));
    }
}
