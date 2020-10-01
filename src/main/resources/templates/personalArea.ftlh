<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="jumbotron">
                    <h3 class="display-4">Личный кабинет</h3>
                    <p class="lead">${user.lastName?ifExists} ${user.firstName} ${user.middleName?ifExists} </p>
                    <p class="lead">${user.number?ifExists}</p>

                    <hr class="my-4">
                    <p class="lead">Мобильная связь: <#if  user.tariffMobile??> ${user.tariffMobile}. Осталось ${usedTariffMobile?ifExists}
                        <#else> нет подключенных тарифов </#if> </p>
                    <p><a href="/tariffs" class="btn btn-primary">Выбрать мобильный тариф</a></p>
                    <p class="lead">Домашний интернет: <#if  user.tariffHome??>
                            <b>${user.tariffHome.name},
                            скорость интернета ${user.tariffHome.speedInternet} мб/с,
                            цена ${user.tariffHome.priceOfMonth} рублей</b>
                            <#else> нет подключенных тарифов </#if> </p>
                    <p><a href="/tariffsHome" class="btn btn-primary">Выбрать домашний тариф</a></p>
                    <hr class="my-4">
                    <p><a href="#notifications">Уведомления например тут</a></p>
                    <p><a name="notifications"></a></p>
                    <hr class="my-4">
                </div>
            </div>
        </div>
    </div>
</@c.page>