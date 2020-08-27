<#include "security.ftlh">
<#import "login.ftlh" as l>
<nav id="navbar" class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Telecommunication operator</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/tariffs" id="navbarDropdownTariffs" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Tariffs
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownTariffs">
                    <a class="dropdown-item" href="/tariffs">Mobile</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/info" id="navbarDropdownInfo" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Info
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownInfo">
                    <a class="dropdown-item" href="/contacts">Contacts</a>
                    <a class="dropdown-item" href="/faq">F.A.Q.</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/info">About us</a>
                    <a class="dropdown-item" href="/work">Work</a>
                </div>
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