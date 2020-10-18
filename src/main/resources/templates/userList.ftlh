<#import "parts/common.ftlh" as c>

<@c.page>
    <br> <br><br><br>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <div class="jumbotron">
                    <p class="lead">Список пользователей</p>
                    <hr class="my-4">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Имя пользователя</th>
                            <th>Роли</th>
                            <th>Редактировать</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list users as user>
                            <tr>
                                <td>${user.id?c}</td>
                                <td>${user.username}</td>
                                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                                <td><a href="/user/${user.id?c}">Редактировать</a></td>
                            </tr>

                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</@c.page>