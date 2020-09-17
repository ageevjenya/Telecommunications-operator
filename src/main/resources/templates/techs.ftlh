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
            <#list techs as tech>
                <li class="media">
                    <img src="${tech.imgUrl}" class="align-self-center mr-3" style="width: 400px" alt="Tech image">
                    <div class="media-body">
                        <h5 class="card-title p-2">${tech.name}</h5>
                        <p class="card-text">${tech.shortDescription}</p>
                        <p class="card-text">${tech.price}, руб</p>
                        <a class="btn btn-nowrap-light" href="/techs/${tech.id}"><h5><strong>Купить</strong></h5></a>
                    </div>
                </li>
                <br>
            </#list>
        </ul>
    </div>


</@c.page>