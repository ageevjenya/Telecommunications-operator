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
                <li class="media">
                    <img src="${modem.imgUrl}" class="align-self-center mr-3" style="width: 400px" alt="Modem image">
                    <div class="media-body">
                        <br><br>
                        <h5 class="card-title p-2">${modem.name}</h5>
                        <p class="card-text">${modem.shortDescription}</p>
                        <p class="card-text">${modem.price}, руб</p>
                        <a class="btn btn-nowrap-light" href="#"><h5><strong>Купить</strong></h5></a>
                    </div>
                </li>

        <br><br>

        <div class="list-group list-group-horizontal" id="myList" role="tablist">
            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#description" role="tab">Описание</a>
            <a class="list-group-item list-group-item-action" data-toggle="list" href="#specifications" role="tab">Характеристики</a>
        </div>

        <br>
        <div class="tab-content">
            <div class="tab-pane fade show active" id="description" role="tabpanel">${modem.description}</div>
            <div class="tab-pane fade" id="specifications" role="tabpanel">${modem.specifications}</div>
        </div>

        <br><br>

    </div>


</@c.page>