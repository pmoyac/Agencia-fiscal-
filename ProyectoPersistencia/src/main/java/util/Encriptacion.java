package util;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Esta clase proporciona métodos estáticos para encriptar y desencriptar datos, 
 * utilizando el algoritmo AES con cifrado en bloque y modo CBC.
 * @author Adriana
 */
public class Encriptacion {
    
    /**
     * Generador de números aleatorios seguro.
     */
    public static SecureRandom sr = new SecureRandom();
    
    /**
     * Encripta un número de teléfono utilizando AES.
     * @param value El número de teléfono a encriptar.
     * @return El número de teléfono encriptado como una cadena codificada en Base64.
     */
    public static String encriptarTelefono(String value){
        String clave = "pruebaencripta04";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sk = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, sk, new IvParameterSpec(new byte[16]));
            
            byte[] encriptado = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encriptado);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Desencripta un número de teléfono previamente encriptado con AES.
     * @param value El número de teléfono encriptado.
     * @return El número de teléfono desencriptado.
     */
    public static String desencriptarTelefono(String value){
        String clave = "pruebaencripta04";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sk = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.DECRYPT_MODE, sk, new IvParameterSpec(new byte[16]));
                        
            byte[] encriptados = Base64.getDecoder().decode(value);
            byte[] desencriptado = cipher.doFinal(encriptados);
            
            return new String(desencriptado);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
