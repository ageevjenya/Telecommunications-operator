<#import "parts/common.ftlh" as c>
<@c.page>
    <br><br><br>

    <div class="jumbotron" style="background-image: linear-gradient(to bottom, rgba(255,255,255,0.6) 0%,rgba(255,255,255,0.9) 100%), url(https://expertsib.ru/assets/content/magazine/2018/6/08-01c.jpg); background-size: cover; background-position: center">
        <h3 class="display-4">Личный кабинет</h3>
        <p class="lead">${user.lastName?ifExists} ${user.firstName} ${user.middleName?ifExists} </p>
        <div class="lead">
            <div>
                <div class="col-md-2">
                    <div class="card flex-row mb-4 shadow-sm h-md-250">
                        <div class="d-flex flex-column bd-highlight mb-2">
                            <div class="p-2 bd-highlight">
                                <h6 class="text-left text-muted">Баланс на сегодня</h6>
                                <h3 class="text-secondary">${user.getBalance().money}</h3>
                            </div>
                            <div class="p-2 bd-highlight">

                                <h6 class="text-left text-muted">Мой номер</h6>
                                <h5>${user.number}</h5>
                                <br>
                                <form method="post" action=/balance/save class="form-select-button">
                                    <input type="text" class="form-control" name="money" placeholder="Введите сумму (₽)"/>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                    <br>
                                    <button type="submit" class="btn btn-dark btn-block">Пополнение</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <hr class="my-4">
        <p class="lead">Мобильная связь: <#if  user.tariffMobile??> <b>${user.tariffMobile.name}</b>. Осталось ${usedTariffMobile?ifExists}
            <#else> нет подключенных тарифов </#if> </p>
        <p><a href="/tariffs" class="btn btn-dark">Выбрать мобильный тариф</a></p>
        <p class="lead">Домашний интернет: <#if  user.tariffHome??>
                <b>${user.tariffHome.name},
                    скорость интернета ${user.tariffHome.speedInternet} мб/с,
                    цена ${user.tariffHome.priceOfMonth} рублей</b>
            <#else> нет подключенных тарифов </#if> </p>
        <p><a href="/tariffsHome" class="btn btn-dark">Выбрать домашний тариф</a></p>
        <br><br><br>

    <#if resumes?size gt 0>
        <div class="accordion" id="resume" style="padding-left: 20%; width: 80%">
        <div class="card">
            <div class="card-header" id="headingOne" style="background-color: white">
                <h2 class="mb-0">
                    <button class="btn btn-link btn-block text-center" style="background-color: white; color: #314A40" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        <#if resumes?size == 1>
                            Ваше резюме
                        <#else>
                            Ваши резюме
                        </#if>
                    </button>
                </h2>
            </div>
            <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#resume">
                <div class="card-body" style="padding-left: 20%">
                    <#list resumes as resume>
                        <form method="post" action="/personalArea/update">
                            <style>
                                input::placeholder {
                                    color: black;
                                    font-weight: bolder;
                                }
                            </style>
                            <input type="hidden" id="id" name="id" value="${resume.id}" />
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-vacancyName"></i></span>
                                <label for="vacancyName" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px"><strong>Вакансия: </strong></label>
                                <input type="text" id="vacancyName" class="form-control col-sm-3" style="border-color: white" pattern="[A-Za-zА-Яа-я ]{3,30}"
                                       name="vacancyName" placeholder="${resume.vacancy.name}">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
                                <label for="firstName" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px">Имя: </label>
                                <input type="text" id="firstName" class="form-control col-sm-3" style="border-color: white" name="firstName"
                                       pattern="[A-ZА-ЯЁ][a-zа-яё]+" placeholder="${resume.firstName}">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lastName"></i></span>
                                <label for="lastName" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px">Фамилия: </label>
                                <input type="text" id="lastName" class="form-control col-sm-3" style="border-color: white" name="lastName"
                                       pattern="[A-ZА-ЯЁ][a-zа-яё]+" placeholder="${resume.lastName}">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-birthday"></i></span>
                                <label for="birthday" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px">День рождения: </label>
                                <input type="text" id="birthday" class="form-control col-sm-3" style="border-color: white" name="birthday"
                                       pattern="(([0][1-9])|([12][0-9])|([3][01]))([.// -]*)(([0][1-9])|([1][0-2]))([.// -]*)(([1][9][4-9][0-9])|([2][0][0][0-5]))"
                                       placeholder="${resume.birthday.dayOfMonth}.${resume.birthday.monthValue}.${resume.birthday.getYear()}">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                                <label for="phone" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px">Номер телефона: </label>
                                <input type="text" id="phone" class="form-control col-sm-3" style="border-color: white" name="phone"
                                       pattern="^\s*(?:\+?(\d{1,3}))?([-. (]*(\d{3})[-. )]*)?((\d{3})[-. ]*(\d{2,4})(?:[-.x ]*(\d+))?)\s*$" placeholder="${resume.phone}">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-email"></i></span>
                                <label for="email" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px">E-mail: </label>
                                <input type="text" id="email" class="form-control col-sm-3" style="border-color: white" name="email"
                                       pattern="\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b" placeholder="${resume.email}">
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <div class="form-group row has-feedback">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-text"></i></span>
                                <label for="text" class="col-xs col-form-label" style="padding-left: 25px; padding-right: 15px">О себе: </label>
                                <textarea type="text" id="text" rows="1" class="form-control col-sm-3" style="border-color: white" name="text" placeholder="${resume.text}"></textarea>
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <#if resume.getAccepted()?hasContent>
                                <#else>
                            <button id="change" type="submit" class="btn btn-light" style="color: black; margin-left: 350px">Изменить</button>
                            </#if>
                        </form>
                        <#if resume.getAccepted()?hasContent>
                            <#if resume.getAccepted() == "принято">
                                <p style="color: #ffcc00">Ваше резюме ${resume.getAccepted()}</p>
                                <#else>
                                    <p style="color: #A9A9A9">Ваше резюме ${resume.getAccepted()}</p>
                            </#if>
                            <#else>
                                <p style="color: #5488af">Ваше резюме рассматривают.</p>
                        </#if>
                        <#if resumes?size gt 1 && resume?index lt (resumes?size - 1)>
                            <hr class="my-4">
                        </#if>
                    </#list>
                </div>

                <script>
                    $(function() {
                        $('#change').click(function() {
                            var formValid = true;
                            $('input|textarea').each(function() {
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
                                $('#change');
                            }
                        });
                    });
                </script>

            </div>
        </div>
        <br><br>
    </#if>
</@c.page>