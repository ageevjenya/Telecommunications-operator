<#import "parts/common.ftlh" as c>

<@c.page>
    <br> <br><br><br>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="jumbotron">
                    <p class="lead">Редактировать пользователя</p>
                    <hr class="my-4">
                    <form action="/user" method="post">
<#--                        <input type="text" name="username" value="${user.username}">-->
                        <div>
                            <#list roles as role>
                                <label><input type="checkbox"
                                              name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                                </label>
                            </#list>
                        </div>
                        <input type="hidden" value="${user.id?c}" name="userId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf"/>
                        <button type="submit">Сохранить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>