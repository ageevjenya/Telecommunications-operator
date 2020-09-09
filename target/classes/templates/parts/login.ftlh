<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя пользователя или номер:</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="User name or number"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="text" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <#if !isRegisterForm><a href="/registration">Зарегестрироваться</a></#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Зарегестрироваться<#else>Войти</#if></button>
    </form>
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
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Зарегестрироваться<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary"
                type="submit"><#if Session.SPRING_SECURITY_CONTEXT??>Выйти<#else>Войти</#if></button>
    </form>
</#macro>

