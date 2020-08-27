<#import "../parts/common.ftlh" as c>

<@c.page>
    <div><a href="/"> На главную страницу</a></div>

    <div>
        <form method="post" action="/internet">
            <input type="text" name="pack" placeholder="Введите объем пакета"/>
            <input type="text" name="price" placeholder="Укажите цену пакета"/>
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
        <input type="text" name="pack" placeholder="Введите объем пакета"/>
        <input type="text" name="price" placeholder="Укажите цену пакета"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Обновить</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Pack</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <#list  internetpacks as internetpack>
            <tr>
                <td>${internetpack.id}</td>
                <td>${internetpack.pack} Мб</td>
                <td>${internetpack.price} $</td>
            </tr>
        <#else>
            No pack internet
        </#list>
        </tbody>
    </table>


</@c.page>