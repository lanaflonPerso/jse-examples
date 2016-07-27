/**
 * ZULA Development Team, MBRDI
 * File      : HastyPuddingCipher.Java
 * Project   : ZulaCommons
 * Date      : Jan 07, 2014
 * Release   : 14.2
 */
package core.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HastyPuddingCipher {

    private static final Long PRIMARY_KEY = 1000000000L;
    private static final String KEY = "Zulassungstool";

    private static final long ROUNDS = 12;

    private final static long halfNumBits;
    private final static long numBitsSubHalfNumBits;
    private final static byte[] block;
    private final static MessageDigest messageDigestSHA;
    public static HastyPuddingCipher hpc = new HastyPuddingCipher();

    static {
        if (PRIMARY_KEY <= 0)
            throw new IllegalArgumentException("max must be positive: " + PRIMARY_KEY);
        long numBits = hpc.ceiling(PRIMARY_KEY);
        halfNumBits = numBits / 2;
        numBitsSubHalfNumBits = numBits - halfNumBits;
        block = KEY.getBytes();
        hpc = new HastyPuddingCipher();
        try {
            messageDigestSHA = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("violation Java Cryptography Architecture API Specification - Appendix A", e);
        }
    }

    private HastyPuddingCipher() {

    }

    public static long encrypt(long plainMessage) {
        if (plainMessage >= PRIMARY_KEY)
            throw new IllegalArgumentException("plainMessage must be less than max: " + PRIMARY_KEY);
        do {
            for (long round = 0; round < ROUNDS; ++round) {
                long l = (plainMessage >> numBitsSubHalfNumBits);
                long r = plainMessage & hpc.mask(numBitsSubHalfNumBits);
                l = (l + hpc.f(round, r)) & hpc.mask(halfNumBits);
                plainMessage = (r << halfNumBits) + l;
            }
        } while (plainMessage >= PRIMARY_KEY);
        return plainMessage;
    }

    public static long decrypt(long encryptMessage) {
        if (encryptMessage >= PRIMARY_KEY)
            throw new IllegalArgumentException("encryptMessage must be less than max: " + PRIMARY_KEY);
        do {
            for (long round = ROUNDS - 1; round >= 0; --round) {
                long l = encryptMessage & hpc.mask(numBitsSubHalfNumBits);
                long r = (encryptMessage >> numBitsSubHalfNumBits);
                l = (l - hpc.f(round, r)) & hpc.mask(halfNumBits);
                encryptMessage = (l << numBitsSubHalfNumBits) + r;
            }
        } while (encryptMessage >= PRIMARY_KEY);
        return encryptMessage;
    }

    private long ceiling(long primaryKey) {
        long index;
        for (index = 0; primaryKey > 0; ++index, primaryKey = primaryKey >> 1)
            ;
        return index;
    }

    private long mask(long nbits) {
        return (1 << nbits) - 1;
    }

    private long f(long round, long x) {
        messageDigestSHA.reset();
        messageDigestSHA.update((byte) round);
        messageDigestSHA.update(block);
        long rbytes = ((numBitsSubHalfNumBits - 1) / 8) + 1;
        for (long i = 0; i < rbytes; ++i) {
            messageDigestSHA.update((byte) (x >> (((rbytes - i) - 1) * 8)));
        }
        byte[] hash = messageDigestSHA.digest();
        long z = 0;
        long lbytes = ((halfNumBits - 1) / 8) + 1;
        for (int i = 0; i < lbytes; ++i) {
            z = (z << 8) + (hash[i] & 0xff);
        }
        z = z >>> ((lbytes * 8) - halfNumBits);
        return z;
    }

}