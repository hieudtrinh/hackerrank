package practice.sha256;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sha256 {
    static String byteToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(sc.nextLine().getBytes());
        System.out.println(byteToHexString(md.digest()));
    }
}
