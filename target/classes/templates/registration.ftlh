<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="jumbotron">
                    <h3 class="display-4">Регистрация</h3>
                    <p class="lead">Введите данные</p>
                </div>
                ${message?ifExists}
                <br>
                <@l.registration "/registration" true />
            </div>
        </div>
    </div>
</@c.page>