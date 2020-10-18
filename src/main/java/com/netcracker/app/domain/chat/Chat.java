package com.netcracker.app.domain.chat;

public class Chat {
    protected final String defaultMenu = "Здравствуйте! Выберите вопрос, который Вас интересует:\n" +
            "   1. Личный кабинет\n" +
            "   2. Баланс\n" +
            "   3. Услуги\n" +
            "   4. Тарифы\n" +
            "   5. Интернет-магазин\n" +
            "   6. Написать вопрос оператору";
    protected final String personalCab = "Какой именно вопрос Вас интересует:\n" +
            "   1. Изменить пароль\n" +
            "   2. Посмотреть детализацию\n" +
            "   3. Узнать подключённые услуги\n" +
            "   4. Узнать остатки по пакету трафика\n" +
            "   0. Вернуться к списку вопросов";
    protected String changePassword = "Перейдите по ссылке для изменения текущего пароля: ";
    protected String details = "Перейдите по ссылке для просмотра детализации: ";
    protected String yourServices = "Перейдите по ссылке для просмотра подключённых услуг: ";
    protected String remainsOfTariff = "Перейдите по ссылке для просмотра остатков по пакету трафика: ";
}