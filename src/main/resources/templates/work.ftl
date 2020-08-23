<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Vacancies</h1>
    <#list vacancies as vacancy>
    <div>
    <a href="/vacancy/${vacancy.id}">${vacancy.name}</a>
    <br></br>
    </div>
        <#else>
        No vacancies
        <br></br>
    </#list>

    <br></br>
    <a href="/info">Back to info</a>
</@c.page>