<#macro comwork>
    <br>
    <h3 style="padding-left: 20%">Вакансии</h3> <br>
    <#list vacancies as vacancy>
        <div style="padding-left: 20%">
            <a href="/vacancy/${vacancy.id?c}" class="btn btn-dark">${vacancy.name}</a>
            <br></br>
        </div>
    <#else>
        <div style="padding-left: 20%">Нет вакансий</div>
        <br></br>
    </#list>
</#macro>