package cn.lysoy.myblog.util;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.redis.cache.RedisCache;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class SessionUtil {
    private static final int SESSION_ID_BYTES = 16;
    private static MessageDigest getDigest() throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
        }
    public static String generateSessionId(Long userId) throws NoSuchAlgorithmException {
        Random random = new SecureRandom();
        byte[] bytes = new byte[SESSION_ID_BYTES];
        random.nextBytes(bytes);
        bytes = getDigest().digest(bytes);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            byte b1 = (byte) ((bytes[i] & 0xf0) >> 4);
            byte b2 = (byte) (bytes[i] & 0x0f);
            if (b1 < 10) {
                result.append((char) ('0' + b1));
            } else {
                result.append((char) ('A' + (b1 - 10)));
            }
            if (b2 < 10) {
                result.append((char) ('0' + b2));
            } else {
                result.append((char) ('A' + (b2 - 10)));
            }
        }
        return (result.toString());
    }
    public static HttpSession setSessionAndCookie(HttpSession session, Object object, String sessionid){
        session.setAttribute(sessionid, object);
        session.setMaxInactiveInterval(1800);
        return session;
    }

}
