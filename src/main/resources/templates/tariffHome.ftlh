<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <#if isAdmin>
        <br>
    <div>
        <form method="post" action="/tariffHome/add" class="form-inline">
            <input type="text" class="form-control" name="name" placeholder="Введите название пакета"/>
            <input type="text" class="form-control" name="priceOfMonth" placeholder="Укажите цену пакета"/>
            <input type="text" class="form-control" name="gbInternet" placeholder="Укажите количество GB интернета"/>
            <input type="text" class="form-control" name="description" placeholder="Введите описание пакета"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-default">Добавить</button>
        </form>
    </div>
    </#if>
    <br>
    <h3>Домашний интернет</h3>
    <br>

    <form method="get" action="/tariffHome" class="form-inline">
        <input type="text" class="form-control" name="filter" value="${filter}" placeholder="Введите объем пакета"/>
        <button type="submit" class="btn btn-default">Найти</button>
    </form>

    <br><br>

    <#if isAdmin>
    <br>
    <form method="post" action="/tariffHome/delete" class="form-inline">
        <input type="text" class="form-control" name="packId" placeholder="Введите id пакета"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Удалить</button>
    </form>
    <br>

    <div> ${deleteIdCheck}</div>
    <br>

    <form method="post" action="/tariffHome/update" class="form-inline">
        <input type="text" class="form-control" name="packId" placeholder="Введите id пакета"/>
        <input type="text" class="form-control" name="name" placeholder="Введите название пакета"/>
        <input type="text" class="form-control" name="priceOfMonth" placeholder="Укажите цену пакета"/>
        <input type="text" class="form-control" name="gbInternet" placeholder="Введите количество GB интернета"/>
        <input type="text" class="form-control" name="description" placeholder="Введите описание пакета"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Обновить</button>
    </form>
    <br>
    </#if>

    <div>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Пакет</th>
            <th>Цена, руб/мес</th>
            <th>Интернет, GB</th>
            <th>Описание</th>
            <#if !isAdmin>
                <th></th>
            </#if>
        </tr>
        <#list  internetpacks as internetpack>
            <tr>
                <td>${internetpack.id}</td>
                <td>${internetpack.name}</td>
                <td>${internetpack.priceOfMonth}</td>
                <td>${internetpack.gbInternet}</td>
                <td>${internetpack.description}</td>
                <#if !isAdmin>
                    <td>
                        <a href="#">Подключить</a>
                    </td>
                </#if>
            </tr>
        <#else>
            <br>
            <strong>No pack tariffHome</strong>
            <br>
        </#list>
    </table>
    </div>


</@c.page>