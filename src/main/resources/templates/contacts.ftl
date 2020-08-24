<#import "parts/common.ftl" as c>
<@c.page>
    <br><h3>Contacts</h3><br>
<#list contacts as contact>
<address>
  <strong>Name</strong><br>
  ${contact.address}<br>
  ${contact.workHours}<br>
  ${contact.phone}
</address>

<address>
  <a href="mailto:#">alesiknep@mail.ru</a>
</address>
</#list>

</@c.page>