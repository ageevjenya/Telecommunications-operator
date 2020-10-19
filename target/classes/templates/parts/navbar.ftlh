<#include "security.ftlh">
<#import "login.ftlh" as l>

<script src="../static/jsfunctions/notifications.js" type="text/javascript"></script>
<#--    <nav id="navbar" class="navbar navbar-expand-lg navbar-dark" style="background-color: #424242;">-->
<nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top scrolling-navbar">


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
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/tariffs">Мобильная
                        связь</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/tariffsHome">Домашний
                        интернет</a>
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
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/contacts">Контакты</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/faq">F.A.Q.</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/networkcoveragemap">Карта
                        покрытия</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/work">Работа</a>

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
            <#if isAdmin || isManager || isSupport>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" style="color: #5488af" href="/user">Пользователи</a>
                </li>
                </#if>
            <#if isAdmin || isManager>
                <li class="nav-item">
                    <a class="nav-link" style="color: #5488af" href="/userResumesList">Резюме</a>
                </li>
                </#if>

                <#if isSupport || isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" style="color: #5488af" href="/userOrdersList">П-заказы</a>
                    </li>
                    </#if>
            </#if>
        </ul>
        <ul class="navbar-nav" style="right: 5%">
        <#if Session.SPRING_SECURITY_CONTEXT??>
            <li class="nav-item dropdown">
                    <!-- the id is important here -->
                    <a class="nav-link" style="color: #A9A9A9" type="button" data-toggle="dropdown"
                            onclick="notificationAllActive()" id="notification"><i class="far fa-bell mr-2"></i><script>notificationsAmount()</script>
                        <span class="badge badge-secondary" id="notificationsAmountList"></span></a>
                    <ul class="dropdown-menu" onclick="notificationAllActive()">
                        <div id="notificationList"></div>

                    </ul>
            </li>
            <li class="nav-item mr-2">
                <a class="nav-link" href="/cart"><i class="fas fa-shopping-cart mr-2"></i><script>notificationProduct()</script><span
                            class="badge badge-secondary" id="notificationProductView"></span></a>
            </li>

            <li class="nav-item dropdown mr-3">
                <a class="btn btn-outline-info lighten-2" style="border-color: #A9A9A9; color: #A9A9A9; background-color: #314A40"
                   href="/personalArea" id="navbarDropdownPersonal" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    ${name}<i class="far fa-user ml-2"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPersonal">
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/personalArea">Личный кабинет</a>
                    <a class="btn btn-nowrap" style="position: center; color: #314A40" href="/userOrders">Ваши заказы</a>
                    <div class="dropdown-divider"></div>
                    <@l.logout />
                </div>
            </li>

            <#else>
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-light"
                            type="submit">Войти</button>
                </form>
        </#if>
        </ul>
    </div>
</nav>
<script> notificationAllActive()</script>