package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        LocalDate date = LocalDate.now().plusDays(days);
        String newDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return newDate;
    }

    public static String generateCity() {

        ArrayList<String> cityList = new ArrayList<>();
        cityList.add("Абакан");
        cityList.add("Анадырь");
        cityList.add("Архангельск");
        cityList.add("Астрахань");
        cityList.add("Барнаул");
        cityList.add("Белгород");
        cityList.add("Биробиджан");
        cityList.add("Благовещенск");
        cityList.add("Брянск");
        cityList.add("Великий Новгород");
        cityList.add("Владивосток");
        cityList.add("Владикавказ");
        cityList.add("Владимир");
        cityList.add("Волгоград");
        cityList.add("Вологда");
        cityList.add("Воронеж");
        cityList.add("Горно-Алтайск");
        cityList.add("Грозный");
        cityList.add("Екатеринбург");
        cityList.add("Иваново");
        cityList.add("Ижевск");
        cityList.add("Иркутск");
        cityList.add("Йошкар-Ола");

        Collections.shuffle(cityList);

        String city = cityList.get(8);
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
