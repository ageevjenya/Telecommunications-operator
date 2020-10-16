<#include "security.ftlh">
<#import "login.ftlh" as l>
<script src="../static/jsfunctions/notifications.js" type="text/javascript"></script>
<nav id="navbar" class="navbar navbar-expand-lg navbar-dark" style="background-color: #424242;">
    <a class="navbar-brand" href="/">Оператор связи</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/tariffs" id="navbarDropdownTariffs" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Тарифы
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownTariffs">
                    <a class="dropdown-item" href="/tariffs">Мобильная связь</a>
                    <a class="dropdown-item" href="/tariffsHome">Домашний интернет</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/shop">Интернет-магазин</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/contacts" id="navbarDropdownInfo" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    О нас
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownInfo">
                    <a class="dropdown-item" href="/contacts">Контакты</a>
                    <a class="dropdown-item" href="/faq">F.A.Q.</a>
                    <a class="dropdown-item" href="/networkcoveragemap">Карта покрытия</a>
                    <a class="dropdown-item" href="/work">Работа</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/promo">Акции</a>
                    <a class="dropdown-item" href="/advertising">Реклама</a>
                    <a class="dropdown-item" href="#">Рекомендации</a>

                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/personalArea">Личный кабинет</a>
            </li>
            <#if isAuth>
                <li class="nav-item">
                    <a class="nav-link" href="/requests">Заявки</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей</a>
                </li>
            </#if>
        </ul>


    </div>
    <#if isAuth>
        <div class="dropdown">
            <!-- the id is important here -->
            <button class="btn btn-defoult dropdown-toggle" type="button" data-toggle="dropdown"
                    onclick="notificationAllActive()" id="notification">Уведомления
                <span class="caret"></span></button>
            <ul class="dropdown-menu" onclick="notificationAllActive()">
                <div id="notificationList"></div>

            </ul>
        </div>
    </#if>
    <div class="navbar-text mr-3">${name}</div>
    <@l.logout />
</nav>
<script> notificationAllActive()</script>