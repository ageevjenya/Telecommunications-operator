<#import "parts/common.ftlh" as c>
<#import "parts/coveragemap.ftlh" as n>
<#import "parts/commoncontacts.ftlh" as cont>
<#import "parts/comwork.ftlh" as work>
<#import "parts/comfaq.ftlh" as fq>

<@c.page>

    <br><br> <br>
    <div class="jumbotron" style="background-image: linear-gradient(to bottom, rgba(255,255,255,0.6) 0%,rgba(255,255,255,0.9) 100%), url(https://expertsib.ru/assets/content/magazine/2018/6/08-01c.jpg); background-size: cover; background-position: center">

      <h3 class="display-4">Оператор связи</h3>
      <p class="lead">У нас вам будут предоставлены лучшие услуги.</p>
      <hr class="my-4">
      <p>Нажав всего одну кнопку, вы узнаете о нас больше и получите достойное обслуживание.</p>
      <a class="btn btn-dark" href="/shop" style="margin-left: 10px" role="button">Услуги</a>
    </div>
    <br>
    <div class="col mx-1" style="margin-left: 20%;  margin-right: 20%; text-align: center">
        <p>Мы предоставляем услуги подключения тарифов мобильной и домашней связи, покупки техники и устройств. Так же мы всегда рады новым работникам, с вакансиями можно ознакомиться в разделе "Контакты"</p>
    </div>
    <br><br>

    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="card-deck ">
                    <div class="card">
                        <div class="card-body" style="background-color: #314A40; color: white">
                            <h5 class="card-title">Общая информация</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Контакты. Карта покрытия. Работа.</h6>
                            <p class="card-text mb-2" style="margin-left: -3.1%">Здесь вы можете ознакомится с регионами в которых мы предоставляем
                                связь</p>
                            <br>
                            <div class="btn-group" role="group">
                                <button id="btnGroupDrop1" type="button" class="btn btn-light dropdown-toggle"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Раскрыть
                                </button>
                                <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                    <a href="#contacts" class="btn btn-nowrap" style="position: center; color: #314A40">Контакты</a>
                                    <br>
                                    <a href="#networkcoveragemap" class="btn btn-nowrap" style="position: center; color: #314A40">Карта покрытия</a>
                                    <br>
                                    <a href="#work" class="btn btn-nowrap" style="position: center; color: #314A40">Работа</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body" style="background-color: #314A40; color: white">
                            <h5 class="card-title">F.A.Q.</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Ваш BTC</h6>
                            <p class="card-text mb-2" style="margin-left: -3.1%">Если у Вас есть вопросы, возможно мы уже на них ответили на этой
                                странице</p>
                            <br>
                            <a href="#faq" class="btn btn-light">F.A.Q.</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <div class="col mx-1">
                <p><a name="contacts"></a></p>
                <@cont.comcontacts/>
            </div>
            <a href="/contacts" class="btn btn-light" style="margin-left: 20.5%; margin-top: 15px">Подробнее</a>
        </div>
        <div>
            <div class="row col-10" style="padding-left: 22%">
                <p><a name="networkcoveragemap"></a></p>
                <@n.networkcoveragemap pointsacces />
            </div>
            <a href="/networkcoveragemap" class="btn btn-light" style="margin-left: 20.5%; margin-top: 15px">Подробнее</a>
        </div>
        <div>
            <div class="col mx-1">
                <p><a name="work"></a></p>
                <@work.comwork/>
            </div>
            <a href="/work" class="btn btn-light" style="margin-left: 20.5%; margin-top: 15px">Подробнее</a>
        </div>
        <div>
            <div class="col mx-1">
                <p><a name="faq"></a></p>
                <@fq.comfaq/>
                <br>
            </div>
            <a href="/faq" class="btn btn-light" style="margin-left: 20.5%; margin-top: 15px">Подробнее</a>
        </div>
    </div>
    <br><br>
    <#include "parts/footer.ftlh"/>
</@c.page>