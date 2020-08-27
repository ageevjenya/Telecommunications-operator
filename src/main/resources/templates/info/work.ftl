<#import "parts/common.ftl" as c>
<@c.page>
<br>
    <h3>Vacancies</h3> <br>
    <#list vacancies as vacancy>
    <div>
    <a href="/vacancy/${vacancy.id}" class="btn btn-light">${vacancy.name}</a>
    <br></br>
    </div>
        <#else>
        No vacancies
        <br></br>
    </#list>

    <br></br>
    <a class="btn text-nowrap-light" href="/info">Back to info</a>
</@c.page>