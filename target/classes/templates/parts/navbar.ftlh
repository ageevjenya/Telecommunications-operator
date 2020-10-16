<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Оператор связи</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/tariffs" id="navbarDropdownTariffs" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Тарифы
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownTariffs">
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/tariffs">Мобильная связь</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/tariffsHome">Домашний интернет</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/shop">Интернет-магазин</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/contacts" id="navbarDropdownInfo" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    О нас
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownInfo">
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/contacts">Контакты</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/faq">F.A.Q.</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/networkcoveragemap">Карта покрытия</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/work">Работа</a>
                    <div class="dropdown-divider"></div>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/promo">Акции</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/advertising">Реклама</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="#">Рекомендации</a>

                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/personalArea">Личный кабинет</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей</a>
                </li>
            </#if>
        </ul>
        <#if Session.SPRING_SECURITY_CONTEXT??>
            <div class="navbar-text mr-2">
                <a class="nav-link" style="color: white" href="/cart">Корзина</a>
            </div>
        </#if>
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>