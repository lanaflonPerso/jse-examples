package core.serialization.encrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Test;

public class EncryptSerializationTest {
    @Test
    public void testEncryptDecryptString()
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String orig = "hello";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        EncryptSerialization.encrypt(orig, baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        Assert.assertEquals(orig, EncryptSerialization.decrypt(bais));
    }

    @Test
    public void testEncryptDecryptPerson()
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        Person orig = new Person("Jack", 21);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        EncryptSerialization.encrypt(orig, baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        Assert.assertEquals(orig, EncryptSerialization.decrypt(bais));
    }

    static class Person implements Serializable {
        private static final long serialVersionUID = 0;
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Person person = (Person) o;

            if (age != person.age) {
                return false;
            }
            if (!name.equals(person.name)) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age;
            return result;
        }
    }
}
