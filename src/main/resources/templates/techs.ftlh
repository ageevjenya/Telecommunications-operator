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
            <#list page.content as tech>
                <li class="media">
                    <img src="${tech.imgUrl}" class="align-self-center mr-3" style="width: 100px" alt="Tech image">
                    <div class="media-body" style="margin-left: 30px">
                        <h6 class="card-title p-2" style="width: 80%"><a style="color: black" href="/techs/${tech.id}">${tech.name}</a></h6>
                        <p class="card-text" style="width: 80%">${tech.shortDescription}</p>
                        <p class="card-text">${tech.price}, руб</p>
                        <a class="btn btn-dark" style="margin-left: 11px" href="/techs/${tech.id}">Купить</a>
                        <br><br><br>
                    </div>
                </li>
                <br>
            </#list>
        </ul>
        <@p.pager url page />
    </div>
</@c.page>