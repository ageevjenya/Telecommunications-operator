<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
<#--    <script type="text/javascript"></script>-->
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <br>
                <h3>Домашний интернет</h3>
                <br>

                <form method="get" action="/tariffsHome" class="form-inline">
                    Скорость интернета от 0 мб/с до
                    <input type="text" class="form-control ml-1" name="filter" value="${filter}"
                           placeholder="мб/с"/>
                    <button type="submit" class="btn btn-default">Найти</button>
                </form>

                <br>

                <#if isAdmin>
                    <div class="jumbotron">
                        <h3>Редактировать тарифы</h3>
                        <br>
                        <form method="post" action="/tariffsHome" class="form-inline">

                            <input type="text" class="form-control" name="name"
                                   placeholder="Введите название тарифа"/>
                            <input type="text" class="form-control" name="priceOfMonth"
                                   placeholder="Укажите цену"/>
                            <input type="text" class="form-control" name="speedInternet"
                                   placeholder="Укажите скорость интернета"/>
                            <input type="text" class="form-control" name="description"
                                   placeholder="Введите описание тарифа"/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                            <button type="submit" class="btn btn-default">Добавить</button>

                        </form>


                        <br>
                        <form method="post" action="/tariffsHome/update" class="form-inline">
                            <input type="text" class="form-control col-1" name="tariffId"
                                   placeholder="Id"/>


                            <input type="text" class="form-control" name="name"
                                   placeholder="Название"/>


                            <input type="text" class="form-control  col-1" name="priceOfMonth"
                                   placeholder="Цена"/> руб.


                            <input type="text" class="form-control  col-2" name="speedInternet"
                                   placeholder="Скорость интернета"/> мб/с


                            <input type="text" class="form-control" name="description"
                                   placeholder="Описание"/>


                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>


                            <button type="submit" class="btn btn-default">Обновить</button>
                        </form>
                        <br>


                    </div>
                </#if>

                <div>
                    <table class="table table-hover">
                        <tr>
                            <#if isAdmin>
                                <th>ID</th></#if>
                            <th>Пакет</th>
                            <th>Цена, руб/мес</th>
                            <th>Интернет, мб/с</th>
                            <th>Описание</th>
                            <#if isAuth>
                                <th></th>
                            </#if>
                        </tr>
                        <#list  tariffHomes as tariffHome>
                            <tr>
                                <#if isAdmin>
                                    <td>${tariffHome.id?c}</td></#if>
                                <td>${tariffHome.name}</td>
                                <td>${tariffHome.priceOfMonth?c}</td>
                                <td>${tariffHome.speedInternet?c}</td>
                                <td>${tariffHome.description}</td>
                                <#if isAuth>
                                    <td>
                                        <#if userTariffHomes?? && userTariffHomes==tariffHome>
                                            Подключено
                                        <#else>
                                            <form method="post" action="/tariffsHome/connect" class="form-inline">
                                                <input type="hidden" name="tariffHomeId" value="${tariffHome.id?c}"/>
                                                <input type="hidden" name="tariffHomeName" value="${tariffHome.name}"/>
                                                <input type="hidden" name="tariffHomeSpeedInternet"
                                                       value="${tariffHome.speedInternet?c}"/>
                                                <input type="hidden" name="tariffHomeDescription"
                                                       value="${tariffHome.description}"/>
                                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                                <button type="submit" class="btn btn-default">Подключить</button>
                                            </form>
                                        </#if>
                                    </td>
                                </#if>
                                <#if isAdmin>
                                    <td>
                                        <form method="post" action="/tariffsHome/delete" class="form-inline">
                                            <input type="hidden" name="tariffId"
                                                   value="${tariffHome.id?c}"/>
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                            <button type="submit" class="btn btn-default">Удалить</button>
                                        </form>
                                    </td>
                                </#if>
                            </tr>
                        <#else>
                            <br>
                            <strong>Извините, пока нет достпуных тарифов</strong>
                            <br>
                        </#list>
                    </table>
                </div>
            </div>
        </div>
    </div>


</@c.page>