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
                <#if !order.getStatus()?has_content>
            <div class="row">
                    <h5 class="text ml-5 mr-1">Ваш заказ</h5><h5 class="text" style="color: white">в обработке</h5>
            </div>
                    <#elseif order.getStatus() == "принят">
                        <div class="row">
                        <h5 class="text ml-5 mr-1">Ваш заказ</h5><h5 class="text" style="color: #5488af">принят</h5>
                        </div>
                    <#elseif order.getStatus() == "доставлен">
            <div class="row">
                    <h5 class="text ml-5 mr-1">Ваш заказ</h5><h5 class="text" style="color: #ffcc00">доставлен</h5>
            </div>
                    <#else>
                    <h5 class="text ml-5" style="color: #A9A9A9">Отказ</h5>
                </#if>
                <hr class="my-4">
            </#list>
        </ul>
            <#else>
                <p class="text ml-5">Вы ещё не оформили ни один заказ. <a href="/shop">Нажмите</a>, чтобы выбрать товар.</p>
        </#if>
    </div>
    <br><br>
</@c.page>