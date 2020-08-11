<#import "parts/common.ftlh" as c>

<@c.page>
    User editor

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <div>
            <#list roles as role>
                <label><input type="checkbox"
                              name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </#list>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden"  value="${_csrf.token}" name="_csrf"/>
        <button type="submit">Save</button>
    </form>
</@c.page>