<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <h3 style="margin-left: 20%">Корзина</h3>
    <div style="background-color: #314A40; color: white; margin-top: 15px; margin-left: 20%; margin-right: 20%">
        <#if cart.counts == 0>
            <p>Ваша корзина пуста. <a href="/shop">Нажмите</a>, чтобы выбрать товар.</p>
            <#else>
                <#assign indic = 1 />
            <#if cart.productModemInfos??>
                <ul class="list-unstyled">
                    <br>
                    <#list cart.productModemInfos as productModem>
                        <li class="media mb-4">
                            <div class="align-self-center mr-5 ml-5">${indic}</div>
                            <img src="${productModem.device.imgUrl}" class="align-self-center mr-3" style="width: 150px" alt="Modem image">
                            <div class="media-body" style="margin-left: 50px">
                                <h6 class="card-title p-2" style="width: 80%"><a style="color: white" href="/modems/${productModem.device.id}">${productModem.device.name}</a></h6>
                                <p class="card-text" style="width: 80%">${productModem.device.shortDescription}</p>
                                <p class="card-text">${productModem.device.price}, руб</p>
                                <a class="btn btn-dark" style="margin-left: 11px" href="/modems/${productModem.device.id}">Перейти</a>
                                <br><br><br>
                            </div>
                        </li>
                        <hr class="my-4">
                        <#assign indic++ />
                        <br>
                    </#list>
                </ul>
            </#if>
                <#if cart.productTechInfos??>
                    <ul class="list-unstyled">
                        <br>
                        <#list cart.productTechInfos as productTech>
                            <li class="media mb-4">
                                <div class="align-self-center mr-5 ml-5">${indic}</div>
                                <img src="${productTech.device.imgUrl}" class="align-self-center mr-3" style="margin-left: 25px; width: 100px" alt="Tech image">
                                <div class="media-body" style="margin-left: 75px">
                                    <h6 class="card-title p-2" style="width: 80%"><a style="color: white" href="/techs/${productTech.device.id}">${productTech.device.name}</a></h6>
                                    <p class="card-text" style="width: 80%">${productTech.device.shortDescription}</p>
                                    <p class="card-text">${productTech.device.price}, руб</p>
                                    <a class="btn btn-dark" style="margin-left: 11px" href="/techs/${productTech.device.id}">Перейти</a>
                                    <br><br><br>
                                </div>
                            </li>
                            <hr class="my-4">
                            <#if indic lt cart.counts >
                                <br><br>
                            </#if>
                            <#assign indic++ />
                        </#list>
                    </ul>
                </#if>
        </#if>
    </div>
        <br>
        <form class="form-inline justify-content-end" style="margin-right: 20%; margin-left: 20%">
            <h3>Цена: <strong>${cart.fullPrice}</strong>, руб</h3>
        </form>
    <br><br>
</@c.page>