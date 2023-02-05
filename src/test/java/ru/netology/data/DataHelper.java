package ru.netology.data;

import lombok.Value;

import java.util.Arrays;
import java.util.Objects;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class InvalidVerificationCode {
        private String code;
    }

    public static InvalidVerificationCode getCodeFor() {
        return new InvalidVerificationCode("12348");
    }

    @Value
    public static class CardData {
        private String cardNumber;
    }

    public static String cardNumber(String id) {
        var city = Arrays.asList("5559000000000001", "5559000000000002");
        if (Objects.equals(id, "0001")) {
            return city.get(1);
        } else {
            return city.get(0);
        }
    }


}