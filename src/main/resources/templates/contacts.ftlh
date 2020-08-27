<#import "parts/common.ftlh" as c>
<@c.page>
    <br><h3>Контакты</h3><br>
<#list contacts as contact>
<address>
  <strong>Название точки</strong><br>
  ${contact.address}<br>
  ${contact.workHours}<br>
  ${contact.phone}
</address>

<address>
  <a href="mailto:#">alesiknep@mail.ru</a>
</address>
</#list>

</@c.page>