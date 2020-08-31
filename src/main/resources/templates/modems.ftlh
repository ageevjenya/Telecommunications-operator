<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <br>
    <#if isAdmin>
        <a class="btn btn-primary" href="/adminModemTech">Управлять</a>
        <br>
    </#if>
    <div id="left">
    <#include "parts/shopnav.ftlh">
    </div>

    <div id="right">
    <ul class="list-unstyled">
        <#list modems as modem>
        <li class="media">
            <img src="${modem.imgUrl}" class="align-self-start mr-3" alt="Modem image">
            <div class="media-body">
                <br><br>
                <h5 class="card-title">${modem.name}</h5>
                <p class="card-text">${modem.shortDescription}</p>
                <p class="card-text">${modem.price}, руб</p>
                <a class="btn btn-nowrap-light" href="/modems/${modem.id}"><h5><strong>Купить</strong></h5></a>
            </div>
        </li>
        </#list>
    </ul>
    </div>


</@c.page>