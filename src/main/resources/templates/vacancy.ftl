<#import "parts/common.ftl" as c>
<@c.page>
    <h1>${vacancy.name}</h1>
    <p>${vacancy.text}</p>

<br></br>
    <a href="/resume/${vacancy.id}">Send resume</a>
    <br></br>
    <a href="/work">Back to list of vacancies</a>
</@c.page>