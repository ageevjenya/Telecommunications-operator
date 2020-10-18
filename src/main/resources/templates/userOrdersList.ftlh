<#import "parts/common.ftlh" as c>

<@c.page>
<div style="margin-left: 3%">
    <br>
    <h3>Список заказов</h3>
    <br>
</div>
    <#if orders?has_content>

            <table class="table table-hover" style="margin-left: 3%; width: 95%">
            <tr>
                <th>№ заказа</th>
                <th>Статус</th>
                <th>Дата</th>
                <th>ФИО</th>
                <th>Телефон</th>
                <th>Адрес</th>
                <th>Товары</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <#list orders as order>
                <tr>
                    <td>${order.getId()}</td>

                    <#if order.getStatus()?has_content>
                        <td>Принят</td>
                        <#else>
                        <td>В обработке</td>
                    </#if>

                    <td>${order.getCreatedAt()}</td>
                    <td>${order.getUser().getFirstName()} ${order.getUser().getLastName()}</td>
                    <td>${order.getPhone()}</td>
                    <td>${order.getAddress()}</td>
                    <td>${order.getStringOrder()}</td>
                    <td>
                    <form method="post" action="/noOrder">
                        <input type="hidden" name="orderId" value="${order.getId()}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-danger">Отказ</button>
                    </form>
                </td>
                    <td>
                        <form method="post" action="/yesOrder">
                            <input type="hidden" name="orderId" value="${order.getId()}"/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-info">Принять</button>
                        </form>
                    </td>
                <td>
                    <form method="post" action="/dev">
                        <input type="hidden" name="orderId" value="${order.getId()}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-success">Доставлен</button>
                    </form>
                </td>
                </tr>
            </#list>
            </table>
    <#else>
        <div style="margin-left: 20%">Нет активных заказов</div>
    </#if>


</@c.page>