<#include "security.ftlh">
<#import "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">BTC</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">На главную</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/networkcoveragemap">Карта покрытия</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Войти</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/internet">Интернет</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/promo">Акции</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/advertising">Реклама</a>
            </li>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>