<#import "parts/common.ftlh" as c>

<@c.page>
    <div><a href="/"> На главную страницу</a></div>

    <div>
        <form method="post" action="/internet">
            <input type="text" name="name" placeholder="Введите название пакета"/>
            <input type="text" name="priceOfMonth" placeholder="Укажите цену пакета"/>
            <input type="text" name="gbInternet" placeholder="Укажите количество GB интернета"/>
            <input type="text" name="description" placeholder="Введите описание пакета"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список пакетов интернета</div>

    <form method="get" action="/internet">
        <input type="text" name="filter" value="${filter}" placeholder="Введите объем пакета"/>
        <button type="submit">Найти</button>
    </form>

    <form method="post" action="/internet/delete">
        <input type="text" name="packId" placeholder="Введите id пакета"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Удалить</button>
    </form>

    <div> ${deleteIdCheck}</div>

    <form method="post" action="/internet/update">
        <input type="text" name="packId" placeholder="Введите id пакета"/>
        <input type="text" name="name" placeholder="Введите название пакета"/>
        <input type="text" name="priceOfMonth" placeholder="Укажите цену пакета"/>
        <input type="text" name="gbInternet" placeholder="Введите количество GB интернета"/>
        <input type="text" name="description" placeholder="Введите описание пакета"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Обновить</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Packet</th>
            <th>Price</th>
            <th>Internet, GB</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <#list  internetpacks as internetpack>
            <tr>
                <td>${internetpack.id}</td>
                <td>${internetpack.name} Мб</td>
                <td>${internetpack.priceOfMonth} $</td>
                <td>${internetpack.gbInternet} GB</td>
                <td>${internetpack.description}</td>
            </tr>
        <#else>
            No pack internet
        </#list>
        </tbody>
    </table>


</@c.page>