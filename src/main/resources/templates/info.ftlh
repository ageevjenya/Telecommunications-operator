<#import "parts/common.ftlh" as c>
<#import "parts/coveragemap.ftlh" as n>


<@c.page>
    <br>
    Здесь описание нашей компании ляляля
<<<<<<< HEAD
    <br><br>
    <div class="d-flex justify-content-center">
=======
    <br>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="card-deck ">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Акции и рекомендации</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Ваш BTC</h6>
                            <p class="card-text">Здесь вы можете ознакомится с лучшими предложениями</p>
                            <p><a href="/promo" class="card-link">Акции</a></p>
                            <p><a href="#" class="card-link">Рекомендации</a></p>
                        </div>
                    </div>
>>>>>>> origin/develop


                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Общая информация</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Контакты. Карта покрытия. Работа.</h6>
                            <p class="card-text">Здесь вы можете ознакомится с регионами в которых мы предоставляем
                                связь</p>
                            <div class="btn-group" role="group">
                                <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Раскрыть
                                </button>
                                <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                    <p><a href="/contacts" class="card-link">Контакты</a></p>
                                    <p><a href="#networkcoveragemap" class="card-link">Карта покрытия</a></p>
                                    <p><a href="/work" class="card-link">Работа</a></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">F.A.Q.</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Ваш BTC</h6>
                            <p class="card-text">Если у Вас есть вопросы, возможно мы уже на них ответили на этой
                                странице</p>
                            <a href="/faq" class="card-link">F.A.Q.</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col mx-1">
                <p><a name="networkcoveragemap"></a></p>
                <a href="/networkcoveragemap" class="card-link">Подробнее</a>
                <@n.networkcoveragemap pointsacces />
            </div>
        </div>
    </div>

</@c.page>