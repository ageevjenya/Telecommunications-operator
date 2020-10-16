<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/pager.ftlh" as p>

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
        <@p.pager url page />
    <ul class="list-unstyled">
        <br>
        <#list page.content as modem>
        <li class="media mb-4">
            <img src="${modem.imgUrl}" class="align-self-center mr-3" style="width: 150px" alt="Modem image">
            <div class="media-body" style="margin-left: 30px">
                <h6 class="card-title p-2" style="width: 80%"><a style="color: black" href="/modems/${modem.id}">${modem.name}</a></h6>
                <p class="card-text" style="width: 80%">${modem.shortDescription}</p>
                <p class="card-text">${modem.price}, руб</p>
                <a class="btn btn-dark" style="margin-left: 11px" href="/modems/${modem.id}">Купить</a>
                <br><br><br>
            </div>
        </li>
            <br>
        </#list>
    </ul>
        <@p.pager url page />
    </div>
</@c.page>