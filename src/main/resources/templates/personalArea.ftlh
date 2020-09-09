<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="jumbotron">
                    <h3 class="display-4">Личный кабинет</h3>
                    <p class="lead">${user.lastName?ifExists} ${user.firstName} ${user.middleName?ifExists}</p>
                    <p class="lead">${user.number?ifExists}</p>

                    <hr class="my-4">
                    <p class="lead">Мобильная связь: ${ (user.tariffMobile!"нет подключенных тарифов") } ${usedTariffMobile?ifExists}</p>
                    <p class="lead">Домашний интернет: ${ (user.tariffHome!"нет подключенных тарифов") } ${usedTariffHome?ifExists}</p>
                    <p><a href="#" class="btn btn-primary">Выбрать тариф</a></p>

                    <hr class="my-4">
                    <p><a href="#notifications">Уведомления например тут</a></p>
                    <p><a name="notifications"></a></p>
                    <hr class="my-4">
                </div>
            </div>
        </div>
    </div>
</@c.page>