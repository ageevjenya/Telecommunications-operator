<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <br> <br><br><br>
    <#if isAdmin>
        <a class="btn btn-primary" href="/adminModemTech">Управлять</a>
        <br>
    </#if>
    <div id="left">
        <#include "parts/shopnav.ftlh">
    </div>

    <div id="right">
                <li class="media">
                    <div id="carouselIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <#assign currIndex = 1 />
                            <li data-target="#carouselIndicators" data-slide-to="0" class="active"></li>
                            <#list imgs as img>
                                <li data-target="#carouselIndicators" data-slide-to="${currIndex}"></li>
                                <#assign currIndex = img?index + 1 />
                            </#list>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${modem.imgUrl}" class="d-block align-self-center mr-3" style="margin-top: 10%; width: 250px" alt="Modem image">
                            </div>
                            <#list imgs as img>
                                <div class="carousel-item">
                                    <img src="${img.url}" class="d-block align-self-center mr-3" style="margin-top: 10%; width: 250px" alt="Modem image">
                                </div>
                            </#list>
                        </div>
                        <a class="carousel-control-prev" href="#carouselIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                    <div class="media-body" style="margin-left: 30px">
                        <br><br>
                        <h6 class="card-title p-2" style="width: 80%">${modem.name}</h6>
                        <p class="card-text" style="width: 80%">${modem.shortDescription}</p>
                        <p class="card-text">${modem.price?с}, руб</p>

                        <a class="btn btn-dark" style="margin-left: 11px" href="/modem/${modem.id?c}">Добавить в корзину</a>
                    </div>
                </li>

        <br><br><br>

        <div class="list-group list-group-horizontal" id="myList" role="tablist" style="margin-right: 20%">
            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#description" role="tab">Описание</a>
            <a class="list-group-item list-group-item-action" data-toggle="list" href="#specifications" role="tab">Характеристики</a>
        </div>

        <style>
            .list-group .list-group-item.active {
                border-color: #314A40;
                background-color: #314A40;
                color: white;
            }
        </style>

        <br>
        <div class="tab-content" style="margin-right: 20%">
            <div class="tab-pane fade show active" id="description" role="tabpanel">${modem.description}</div>
            <div class="tab-pane fade" id="specifications" role="tabpanel">${modem.specifications}</div>
        </div>

        <br><br>

    </div>


</@c.page>