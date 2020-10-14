<#import "parts/common.ftlh" as c>

<@c.page>
    <br>
    <h3>Интернет-магазин</h3>
    <br>
    <div class="card-deck">
        <div class="card" style="background-color: #314A40; color: white">
            <img class="card-img-top" src="https://73online.ru/pic/upld_36086.jpg" alt="Card image connection">
            <div class="card-body">
                <h5 class="card-title">Тарифы</h5>
                <p class="card-text" style="margin-left: -3%">Выберите лучшие тарифы мобильной связи и домашнего интернета</p>
                <li class="nav-item dropdown" style = "list-style-type: none">
                    <a class="btn btn-light dropdown-toggle" href="#" id="navbarDropdownTariffs" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Подключить
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownDTariffs" style="width: 70%">
                        <a class="btn btn-nowrap-light" href="/tariffs">Мобильная связь</a>
                        <a class="btn btn-nowrap-light" href="/tariffsHome">Домашний интернет</a>
                    </div>
                </li>
                <p class="card-text"><small class="text-muted">Все тарифы актуальны</small></p>
            </div>
        </div>
        <div class="card" style="background-color: #314A40; color: white">
            <img class="card-img-top" src="https://help-wifi.com/wp-content/uploads/2015/12/router3g_modem.jpg" alt="Card image modem">
            <div class="card-body">
                <h5 class="card-title">Модемы и роутеры</h5>
                <p class="card-text" style="margin-left: -3%">Арендуйте наши устройства для поддержки лучшей связи дома</p>
                <a class="btn btn-light" href="/modems">Арендовать</a>
                <p class="card-text"><small class="text-muted">Наличие всех устройств гарантировано</small></p>
            </div>
        </div>
        <div class="card" style="background-color: #314A40; color: white">
            <img class="card-img-top" src="https://www.fainaidea.com/wp-content/uploads/2015/11/buy.jpg" alt="Card image device">
            <div class="card-body">
                <h5 class="card-title">Техника</h5>
                <p class="card-text" style="margin-left: -3%">Техника от лучших реселлеров по самым выгодным ценам</p>
                <li class="nav-item dropdown" style = "list-style-type: none">
                    <a class="btn btn-light dropdown-toggle" href="/techs" id="navbarDropdownDevices" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Перейти
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownDevices" style="width: 20%">
                        <a class="btn btn-nowrap-light" href="/techs">Все</a>
                        <br>
                        <a class="btn btn-nowrap-light" href="/techs/Smartphone">Смартфоны</a>
                        <br>
                        <a class="btn btn-nowrap-light" href="/techs/Tablet">Планшеты</a>
                    </div>
                </li>
                <p class="card-text"><small class="text-muted">Наличие всех устройств гарантировано</small></p>
            </div>
        </div>
        <div class="card" style="background-color: #314A40; color: white">
            <img class="card-img-top" src="https://storins.ru/wp-content/uploads/2019/11/pokupka-podpiski.png" alt="Card image subscriptions">
            <div class="card-body">
                <h5 class="card-title">Подписки и опции</h5>
                <p class="card-text" style="margin-left: -3%">Подключите полезные опции на ваше устройство</p>
                <li class="nav-item dropdown" style = "list-style-type: none">
                    <a class="btn btn-light dropdown-toggle" href="#" id="navbarDropdownSubs" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Подключить
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownSubs" style="width: 60%">
                        <a class="btn btn-nowrap-light" href="#">Все</a>
                        <a class="btn btn-nowrap-light" href="#">Красивый номер</a>
                        <a class="btn btn-nowrap-light" href="#">Автоплатёж</a>
                        <a class="btn btn-nowrap-light" href="#">Баланс близких</a>
                    </div>
                </li>
                <p class="card-text"><small class="text-muted">Все подписки и опции актуальны</small></p>
            </div>
        </div>
    </div>
</@c.page>