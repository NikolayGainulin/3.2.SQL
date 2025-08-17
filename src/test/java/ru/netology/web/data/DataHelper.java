package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import java.util.Locale;


public class DataHelper {
    private DataHelper() {
    }
    private static final Faker FAKER = new Faker(new Locale("en"));

    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static String generateRandomLogin() {
        return FAKER.name().username();
    }

    public static String generateRandomPassword() {
        return FAKER.internet().password();
    }

    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(FAKER.numerify("######"));
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;

        public String getLogin() {
            return login;  // Возвращаем поле login
        }

        public String getPassword() {
            return password;  // Возвращаем поле password
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationCode {
        String code;

        public String getCode() {
            return code;  // Возвращаем поле code
        }
    }
}