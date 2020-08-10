<#import "parts/common.ftlh" as c>

<@c.page>
<div><a href="/main"> На главную страницу</a></div>

<div>
    <form method="post" action="/internet/add">
        <input type="text" name="pack" placeholder="Введите объем пакета" />
        <input type="text" name="price" placeholder="Укажите цену пакета" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>

<div>Список пакетов интернета</div>

<form method="get" action="/internet">
    <input type="text" name="filter" value="${filter}" placeholder="Введите объем пакета" />
    <button type="submit">Найти</button>
</form>

<form method="post" action="/internet/deletePack">
    <input type="text" name="packId" placeholder="Введите id пакета" />
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Удалить</button>
</form>

<div> ${deleteIdCheck}</div>

<form method="post" action="/internet/updatePack">
    <input type="text" name="packId" placeholder="Введите id пакета" />
    <input type="text" name="pack" placeholder="Введите объем пакета" />
    <input type="text" name="price" placeholder="Укажите цену пакета" />
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Обновить</button>
</form>

    <#list  internetpacks as internetpack>
    <div>
        <b>${internetpack.id}</b>
        <span>${internetpack.pack} Мб</span>
        <i>${internetpack.price} $</i>
    </div>

    <#else>
    No pack internet
    </#list>
</@c.page>