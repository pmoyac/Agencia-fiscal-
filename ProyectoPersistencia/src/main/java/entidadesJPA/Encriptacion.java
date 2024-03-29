package entidadesJPA;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author adria
 */
public class Encriptacion {
    
    public static SecureRandom sr = new SecureRandom();
    
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
