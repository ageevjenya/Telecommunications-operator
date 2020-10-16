<#macro comcontacts>
<br><h3 style="padding-left: 20%">Контакты</h3><br>
<#list contacts as contact>
    <address style="padding-left: 20%">
        <strong>${contact.pointName}</strong><br>
        ${contact.address}<br>
        ${contact.workHours}<br>
        ${contact.phone}<br>
    </address>

    <address style="padding-left: 20%">
        <a href="mailto:#">${contact.email}</a>
    </address>
</#list>
</#macro>