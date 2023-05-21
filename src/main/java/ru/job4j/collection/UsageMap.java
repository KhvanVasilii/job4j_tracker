package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("vovablack@gmail.com", "Владимир Блэк Алексеевич");
        hashMap.put("kif@mail.ru", "Коваль Игнат Сергеевич");
        hashMap.put("dsssfff@bk.ru", "Кирил Онегин Валерьевич");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println("Почта: " + key + " Сотрудник: " + value);
        }
    }
}
