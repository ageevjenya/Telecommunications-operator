<#import "parts/common.ftlh" as c>
<@c.page>

    <div class="jumbotron">
        <h3 class="display-4">Личный кабинет</h3>
<#--        <p class="lead">${user.surName}, ${user.firstName}, ${user.secondName}</p>-->
<#--        <p class="lead">${user.number}</p>-->
        <hr class="my-4">
        <p>Подключенный тариф</p>
        <p><a href="#notifications">Уведомленияб (нужно изменить)</a></p>
    </div>
    <div class="jumbotron">
        <p><a name="notifications"></a></p>
<#--        <hr class="my-4">-->
<#--        <p><#if !'${user.surName}' || 0 == '${user.surName}'.length> Отсутствует фамилия, <a href="#notifications">Редактировать данные</a></#if></p>-->
    </div>
</@c.page>