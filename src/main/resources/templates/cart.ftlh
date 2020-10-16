<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <h3 style="margin-left: 20%">Корзина</h3>
    <#assign productAmount = true />
    <div style="background-color: #314A40; color: white; margin-top: 15px; margin-left: 20%; margin-right: 20%">
        <#if cart.counts == 0>
            <p>Ваша корзина пуста. <a href="/shop">Нажмите</a>, чтобы выбрать товар.</p>
            <#else>
                <#assign indic = 1 />
            <#if cart.productModemInfos??>
                <ul class="list-unstyled">
                    <#list cart.productModemInfos as productModem>
                        <#if productModem.amount != 0>
                            <br>
                            <li class="media mb-4">
                                <div class="align-self-center mr-5 ml-5">${indic}</div>
                                <img src="${productModem.device.imgUrl}" class="align-self-center mr-3" style="width: 150px" alt="Modem image">
                                <div class="media-body" style="margin-left: 50px">
                                    <div class="row">
                                        <h6 class="card-title p-2 ml-3" style="width: 80%"><a style="color: white" href="/modems/${productModem.device.id}">${productModem.device.name}</a></h6>

                                        <a type="button" class="mb-4 close" data-dismiss="toast" data-toggle="tooltip"
                                                data-placement="bottom" title="Убрать из корзины" href="/deleteModem/${productModem.getId()}" aria-label="Close">
                                            <span style="color: #343A40">&times;</span>
                                        </a>
                                    </div>

                                    <p class="card-text" style="width: 80%">${productModem.device.shortDescription}</p>
                                    <p class="card-text">${productModem.device.price}, руб</p>
                                    <div class="row">
                                        <a class="button ml-4 mr-3" href="/minusAmountModem/${productModem.getId()}" aria-label="Previous">
                                            <span style="color: lightgray">&laquo;</span>
                                        </a>
                                        ${productModem.getAmount()}
                                        <a class="button ml-3" href="/plusAmountModem/${productModem.getId()}" aria-label="Next">
                                            <span style="color: lightgray">&raquo;</span>
                                        </a>
                                        <div class="card-text ml-3" style="color: lightgray">кол-во</div>
                                    </div>
                                    <br><br>
                                    <a class="btn btn-dark" style="margin-left: 11px" href="/modems/${productModem.device.id}">Перейти</a>
                                    <br><br>
                                </div>
                            </li>
                            <hr class="my-4">
                            <#assign indic++ />
                            <br>
                            <#assign productAmount = false />
                        </#if>
                    </#list>
                </ul>
            </#if>
                <#if cart.productTechInfos??>
                    <ul class="list-unstyled">
                        <#list cart.productTechInfos as productTech>
                            <#if productTech.amount != 0>
                                <br>
                            <li class="media mb-4">
                                <div class="align-self-center mr-5 ml-5">${indic}</div>
                                <img src="${productTech.device.imgUrl}" class="align-self-center mr-3" style="margin-left: 25px; width: 100px" alt="Tech image">
                                <div class="media-body" style="margin-left: 75px">
                                    <div class="row">
                                        <h6 class="card-title p-2 ml-3" style="width: 80%"><a style="color: white" href="/techs/${productTech.device.id}">${productTech.device.name}</a></h6>

                                        <a type="button" class="mb-4 close" data-dismiss="toast" data-toggle="tooltip"
                                                data-placement="bottom" title="Убрать из корзины" href="/deleteTech/${productTech.getId()}" aria-label="Close">
                                            <span style="color: #343A40">&times;</span>
                                        </a>
                                    </div>
                                    <p class="card-text" style="width: 80%">${productTech.device.shortDescription}</p>
                                    <p class="card-text">${productTech.device.price}, руб</p>
                                    <div class="row">
                                        <a class="button ml-4 mr-3" href="/minusAmountTech/${productTech.getId()}" aria-label="Previous">
                                            <span style="color: lightgray">&laquo;</span>
                                        </a>
                                        ${productTech.getAmount()}
                                        <a class="button ml-3" href="/plusAmountTech/${productTech.getId()}" aria-label="Next">
                                            <span style="color: lightgray">&raquo;</span>
                                        </a>
                                        <div class="card-text ml-3" style="color: lightgray">кол-во</div>
                                    </div>
                                    <br><br>
                                    <a class="btn btn-dark" style="margin-left: 11px" href="/techs/${productTech.device.id}">Перейти</a>
                                    <br><br>
                                </div>
                            </li>
                            <hr class="my-4">
                            <#if indic lt cart.counts >
                                <br><br>
                            </#if>
                            <#assign indic++ />
                            <#assign productAmount = false />
                            </#if>
                        </#list>
                    </ul>
                </#if>
                <#if productAmount>
                    <p class="text-center">Ваша корзина пуста. <a href="/shop">Нажмите</a>, чтобы выбрать товар.</p>
                </#if>
        </#if>
    </div>
    <#if !productAmount>
        <br>
        <form class="form-inline justify-content-end" style="margin-right: 20%; margin-left: 20%">
            <h3>Цена: <strong>${cart.fullPrice}</strong>, руб</h3>
        </form>
    <br>
    <div class="text-right" style="margin-right: 20%; margin-left: 20%">
    <a class="btn btn-dark" href="/order">Оформить заказ</a>
    </div>
    </#if>
    <br><br>
</@c.page>