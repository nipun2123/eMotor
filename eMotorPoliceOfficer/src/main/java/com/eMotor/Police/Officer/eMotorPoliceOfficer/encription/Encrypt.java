package com.eMotor.Police.Officer.eMotorPoliceOfficer.encription;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import org.apache.tomcat.util.codec.binary.Base64;

public class Encrypt {

	   private static final String algorithem = "AES";
	    private static final byte[] keyValue = new byte[]{'2', '8', '5', 'd', 'S', 'w', 'S', 'j', 'Q', '1', '6', 'L', 'K', 'g', 'z', 'T'};

	    public static String encript(String data) {
	        try {
	            String encriptedValue = "";
	            Key key = generateKey();
	            Cipher c;
	            c = Cipher.getInstance(algorithem);

	            c.init(Cipher.ENCRYPT_MODE, key);
	            byte[] encVal = c.doFinal(data.getBytes());
	            encriptedValue = new Base64().encodeToString(encVal);
	            return encriptedValue;
	        } catch (Exception ex) {
	            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return null;
	    }


	    private static Key generateKey() {
	        Key key = new SecretKeySpec(keyValue, algorithem);
	        return key;
	    }

	    public static void main(String[] args) {
	        
	    }
}