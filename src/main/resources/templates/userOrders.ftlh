<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <div style="background-color: #314A40; color: white; margin-top: 15px; margin-left: 20%; margin-right: 20%">
        <br>
        <h5 class="text ml-5">Ваши заказы</h5>
        <hr class="my-4">
        <br>
        <#if orders??>
        <ul class="list-unstyled">
            <#list orders as order>
                <li class="media mb-4">
                    <p class="text ml-5">№ заказа: ${order.getId()}</p>
                    <p class="text ml-5">Дата: ${order.createdAt}</p>
                    <div class="media-body" style="margin-left: 50px">
                        <p class="card-text" style="width: 80%">${order.getStringOrder()}</p>
                        <br><br>
                    </div>
                </li>
                <hr class="my-4">
            </#list>
        </ul>
            <#else>
                <p class="text ml-5">Вы ещё не оформили ни один заказ. <a href="/shop">Нажмите</a>, чтобы выбрать товар.</p>
        </#if>
    </div>
    <br><br>
</@c.page>