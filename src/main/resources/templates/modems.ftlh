<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <br>
    <#if isAdmin>
        <a class="btn btn-primary" href="/adminModemTech">Управлять</a>
        <br>
    </#if>

    <h3>Модемы и роутеры</h3><br>

    <#list modems as modem>
        <div class="card mb-3">
            <img class="card-img float-left" src="${modem.imgUrl}" alt="Card image ${modem.name}">
            <div class="card-body">
                <h5 class="card-title">${modem.name}</h5>
                <p class="card-text">${modem.shortDescription}</p>
                <p class="card-text">${modem.price}, руб</p>
                <a class="btn btn-nowrap-light float-right" href="/modem/${modem.id}"><strong>Купить</strong></a>
            </div>
        </div>
    </#list>

</@c.page>