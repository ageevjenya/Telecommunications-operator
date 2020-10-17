<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <h3 style="margin-left: 20%">Оформление заказа</h3>
    <div style="background-color: #314A40; color: white; margin-top: 15px; margin-left: 20%; margin-right: 20%">
        <br>
        <p class="text ml-5">ФИО: <strong>${user.getLastName()} ${user.getFirstName()} ${user.getMiddleName()}</strong></p>
        <p class="text ml-5">Номер телефона: <strong>${user.getNumber()}</strong></p>
        <br>
            <form method="post">
                <input type="hidden" id="phone" name="phone" value="${user.getNumber()}" />

                <#assign stringOrder = "" />
                <#if cart.productTechInfos??>
                    <#list cart.productTechInfos as productTech>
                        <#if productTech.getAmount() != 0>
                            <#assign stringOrder += "${productTech.device.name} - ${productTech.getAmount()} шт.\n" />
                        </#if>
                    </#list>
                </#if>
                <#if cart.productModemInfos??>
                    <#list cart.productModemInfos as productModem>
                        <#if productModem.getAmount() != 0>
                            <#assign stringOrder += "${productModem.device.name} - ${productModem.getAmount()} шт.\n" />
                        </#if>
                    </#list>
                </#if>

                <input type="hidden" id="stringOrder" name="stringOrder" value="${stringOrder}" />
                <div class="form-group has-feedback">
                    <div class="input-group ml-5">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-address"></i></span>
                        <label for="address" class="text mt-1 ml-2">Адрес: </label>
                        <input type="text" class="form-control mb-2 ml-3 col-lg-5" required="required" pattern="ул[. А-Яа-яЁё,]*д[ 0-9к/. ,]*(кв[ .0-9]*){0,1}"
                            name="address" placeholder="ул. Новослободская, д. 15к4, кв. 502" />
                        <label for="address" class="text mt-1 ml-3">г.Москва </label>
                        <span class="glyphicon form-control-feedback"></span>
                    </div>
                </div>
                <br>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="text-left ml-5">
                    <button id="order" type="submit" class="btn btn-light ml-1">Заказать</button>
                </div>
                <script>
                    $(function() {
                        $('#order').click(function() {
                            var formValid = true;
                            $('input').each(function() {
                                var formGroup = $(this).parents('.form-group');
                                var glyphicon = formGroup.find('.form-control-feedback');
                                if (this.checkValidity()) {
                                    formGroup.addClass('has-success').removeClass('has-error');
                                    glyphicon.addClass('glyphicon-ok').removeClass('glyphicon-remove');
                                } else {
                                    formGroup.addClass('has-error').removeClass('has-success');
                                    glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                                    formValid = false;
                                }
                            });
                            if (formValid) {
                                $('#order');
                            }
                        });
                    });
                </script>
            </form>
        <br>
        </div>

    <div style="margin-top: 15px; margin-left: 20%; margin-right: 20%">
        <p class="text-center">Доставка курьером по городу Москва в течение 2-3 дней. Для уточнения времени и даты доставки с вами свяжется наш оператор.</p>
        <p class="text-center" style="margin-top: -30px">Оплата заказа осуществляется вами при получении.</p>
    </div>
    <div style="background-color: #314A40; color: white; margin-top: 15px; margin-left: 20%; margin-right: 20%">
        <br>
        <h5 class="text ml-5">Ваш заказ на сумму: <strong>${cart.fullPrice}</strong> руб.</h5>
        <hr class="my-4">
        <br>
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
                                    </div>

                                    <p class="card-text" style="width: 80%">${productModem.device.shortDescription}</p>
                                    <p class="card-text">${productModem.device.price}, руб</p>
                                    <div class="row">
                                        <div class="card-text ml-4" style="color: lightgray">${productModem.getAmount()}</div>
                                        <div class="card-text ml-1" style="color: lightgray">шт.</div>
                                    </div>
                                    <br><br>
                                </div>
                            </li>
                            <hr class="my-4">
                            <#assign indic++ />
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
                                    </div>
                                    <p class="card-text" style="width: 80%">${productTech.device.shortDescription}</p>
                                    <p class="card-text">${productTech.device.price}, руб</p>
                                    <div class="row">
                                        <div class="card-text ml-4" style="color: lightgray">${productTech.getAmount()}</div>
                                        <div class="card-text ml-1" style="color: lightgray">шт.</div>
                                    </div>
                                    <br><br>
                                </div>
                            </li>
                            <hr class="my-4">
                            <#if indic lt cart.counts >
                                <br>
                            </#if>
                            <#assign indic++ />
                            </#if>
                        </#list>
                    </ul>
                </#if>
    </div>
    <br>
    </div>

</@c.page>