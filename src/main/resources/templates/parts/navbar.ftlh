<#include "security.ftlh">
<#import "login.ftlh" as l>
<nav id="navbar" class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Оператор связи</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/tariffs" id="navbarDropdownTariffs" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Тарифы
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownTariffs">
                    <a class="dropdown-item" href="/tariffs">Мобильная связь</a>
                    <a class="dropdown-item" href="/internet">Домашний интернет</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/shop">Интернет-магазин</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/info" id="navbarDropdownInfo" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Инфо
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownInfo">
                    <a class="dropdown-item" href="/contacts">Контакты</a>
                    <a class="dropdown-item" href="/faq">F.A.Q.</a>
                    <a class="dropdown-item" href="/info">О нас</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/promo">Акции</a>
                    <a class="dropdown-item" href="/advertising">Реклама</a>
                    <a class="dropdown-item" href="#">Рекомендации</a>
                    <a class="dropdown-item" href="/work">Работа</a>
                </div>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей</a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>