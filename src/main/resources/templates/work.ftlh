<#import "parts/common.ftlh" as c>
<@c.page>
<br>
    <h3>Вакансии</h3> <br>
    <#list vacancies as vacancy>
    <div>
    <a href="/vacancy/${vacancy.id}" class="btn btn-light">${vacancy.name}</a>
    <br></br>
    </div>
        <#else>
        Нет вакансий
        <br></br>
    </#list>

    <br></br>
    <a class="btn text-nowrap-light" href="/info">Назад к инфо</a>
</@c.page>