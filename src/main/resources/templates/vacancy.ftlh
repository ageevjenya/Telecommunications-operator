<#import "parts/common.ftlh" as c>
<@c.page>
<br>
    <h3>${vacancy.name}</h3><br>
    <p>${vacancy.text}</p>

<br></br>
    <a href="/resume/${vacancy.id}" class="btn btn-light" >Отправить резюме</a>
    <br></br>
    <a href="/work" class="btn text-nowrap-light">Назад к вакансиям</a>
</@c.page>