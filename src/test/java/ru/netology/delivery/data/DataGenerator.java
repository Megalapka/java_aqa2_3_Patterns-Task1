package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        LocalDate date = LocalDate.now().plusDays(days);
        String newDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return newDate;
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random

        String city = "Санкт-Петербург";
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {

        Faker faker = new Faker(new Locale(locale));
        String phone = faker.numerify("+7##########");
        return phone;
    }

}
