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
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-username"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Имя пользователя:</label>
            <div class="col-sm-6">
                <input type="text" name="username" required="required" class="form-control" placeholder="User name"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-password"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Пароль:</label>
            <div class="col-sm-6">
                <input type="text" name="password" required="required" class="form-control" placeholder="Password"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-number"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Номер:</label>
            <div class="col-sm-6">
                <input type="text" name="number" pattern="^\s*(?:\+?(\d{1,3}))?([-. (]*(\d{3})[-. )]*)?((\d{3})[-. ]*(\d{2,4})(?:[-.x ]*(\d+))?)\s*$" required="required" class="form-control" placeholder="+7(999)99999 99"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lastName"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Фамилия:</label>
            <div class="col-sm-6">
                <input type="text" name="lastName" pattern="[A-ZА-ЯЁ][a-zа-яё]+" required="required" class="form-control" placeholder="LastName"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-firstName"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Имя:</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" pattern="[A-ZА-ЯЁ][a-zа-яё]+" required="required" class="form-control" placeholder="FirstName"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-middleName"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Отчество:</label>
            <div class="col-sm-6">
                <input type="text" name="middleName" pattern="[A-ZА-ЯЁ][a-zа-яё]+" required="required" class="form-control" placeholder="MiddleName"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <div class="form-group row has-feedback">
            <span class="input-group-addon"><i class="glyphicon glyphicon-birthday"></i></span>
            <label class="col-sm-2 col-form-label" style="margin-left: 20%">Дата рождения:</label>
            <div class="col-sm-6">
                <input type="date" name="birthday" pattern="(([0][1-9])|([12][0-9])|([3][01]))([.// -]*)(([0][1-9])|([1][0-2]))([.// -]*)(([1][9][4-9][0-9])|([2][0][0][0-5]))" required="required" class="form-control" placeholder="Birthday"/>
            </div>
            <span class="glyphicon form-control-feedback"></span>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<br>
        <#if !isRegisterForm><a href="/registration">Зарегистрироваться</a></#if>
        <button class="btn btn-dark" id="reg" type="submit" style="margin-left: 45%"><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
    </form>
    <script>
        $(function() {
            $('#reg').click(function() {
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
                    $('#reg');
                }
            });
        });
    </script>
    <br>
</#macro>

<#macro logout>
    <form id="1" action="/logout" method="post" >
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-nowrap"
                type="submit"><#if Session.SPRING_SECURITY_CONTEXT??>Выйти<#else>Войти</#if></button>
    </form>
</#macro>

