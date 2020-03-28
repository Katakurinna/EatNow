package me.cerratolabs.eatnow.server;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Pruebas {
    private Random random = new Random();
    private MessageDigest md5;
    private MessageDigest sha;

    public Pruebas() throws NoSuchAlgorithmException {
        md5 = MessageDigest.getInstance("MD5");
        sha = MessageDigest.getInstance("SHA-256");
    }

    public boolean isValidAccount(String username, String receivedPassword) {
        String databasePassword = "C5190CEF096DD034EF71B8A6822DE923B7E7454CA80505DBA966F51FCF75CA17"; //SQL.getPasswordFor(username);

        String salt = "CF479F1D11BB2C1730CDF05A593318B9"; //SQL.getSaltFor(username);

        String shaPassword = sha256(sha256(receivedPassword) + salt);
        return shaPassword.equals(databasePassword);
    }

    public String sha256(String text) {
        sha.update(text.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(sha.digest());
    }

    public String generateSalt() {
        md5.update((random.nextInt() + "").getBytes());
        return DatatypeConverter.printHexBinary(md5.digest());
    }

}
