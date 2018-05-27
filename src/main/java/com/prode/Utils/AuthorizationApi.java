package com.prode.Utils;

import com.prode.enums.AuthoApiEnum;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthorizationApi {

    private static String generateHash(String pass, String clientId, String clientSecret) throws NoSuchAlgorithmException {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(clientId.concat(pass).concat(clientSecret).getBytes(Charset.forName("UTF8")));
        final byte[] resultByte = messageDigest.digest();
        final String result = new String(Hex.encodeHex(resultByte));
        return result;
    }


    public static boolean ifUserIsAuthenticate(String pass, String clientId, String clientSecret) throws NoSuchAlgorithmException {
        String hash = generateHash(pass, clientId, clientSecret);
        return AuthoApiEnum.isAutheticathed(hash);
    }
}
