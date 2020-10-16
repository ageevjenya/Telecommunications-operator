<#macro login path isRegisterForm>

    <div class="view" onClick=false>
        <img src="https://images.wallpaperscraft.ru/image/nochnoj_gorod_vid_sverkhu_zdaniya_zheleznaya_doroga_118814_1920x1080.jpg"
             class="img-fluid"
             alt="" style="width: 100%; height: 100%; position: absolute" >

        <div class="mask pattern-1 flex-center waves-effect waves-light" >
            <div class="card mx-auto" style="width: 420px">
                <h3 class="card-header info-color white-text text-center py-4">
                    <strong>Авторизация</strong>
                </h3>
                <div class="card-body">

                    <form action="${path}" method="post">
                        <div class="md-form">
                            <i class="fa fa-user prefix grey-text"></i>
                            <label for="materialFormCardNameEx" class="font-weight-light">Имя пользователя или
                                номер:</label>
                            <input type="text" name="username" id="materialFormCardNameEx" class="form-control">
                        </div>
                        <div class="md-form">
                            <i class="fa fa-lock prefix grey-text"></i>
                            <label for="materialFormCardPasswordEx" class="font-weight-light">Пароль:</label>
                            <input type="password" name="password" id="materialFormCardPasswordEx"
                                   class="form-control">
                        </div>
                        <div class="text-center py-4 mt-3">
                            <button class="btn btn-outline-info" type="submit">Войти</button>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <#if !isRegisterForm>
                            <div class="text-center">
                                <p>У вас еще нет учетной записи?
                                    <a href="/registration">Зарегистрироваться</a>
                                </p>
                            </div>
                        </#if>
                    </form>
                </div>
            </div>
        </div>
    </div>
</#macro>

<#macro registration path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя пользователя:</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="text" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер:</label>
            <div class="col-sm-6">
                <input type="text" name="number" class="form-control" placeholder="+7(999)99999 99"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Фамилия:</label>
            <div class="col-sm-6">
                <input type="text" name="lastName" class="form-control" placeholder="LastName"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя:</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" class="form-control" placeholder="FirstName"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Отчество:</label>
            <div class="col-sm-6">
                <input type="text" name="middleName" class="form-control" placeholder="MiddleName"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата рождения:</label>
            <div class="col-sm-6">
                <input type="date" name="birthday" class="form-control" placeholder="Birthday"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <#if !isRegisterForm><a href="/registration">Зарегестрироваться</a></#if>

        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>
    <form id="1" action="/logout" method="post" >
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary"
                type="submit"><#if Session.SPRING_SECURITY_CONTEXT??>Выйти<#else>Войти</#if></button>
    </form>
</#macro>

