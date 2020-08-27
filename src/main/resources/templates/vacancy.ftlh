<#import "parts/common.ftlh" as c>
<@c.page>
<br>
    <h3>${vacancy.name}</h3><br>
    <p>${vacancy.text}</p>

<br></br>
    <a href="/resume/${vacancy.id}" class="btn btn-light" >Send resume</a>
    <br></br>
    <a href="/work" class="btn text-nowrap-light">Back to list of vacancies</a>
</@c.page>