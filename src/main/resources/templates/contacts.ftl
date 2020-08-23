<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Contacts</h1>
<#list contacts as contact>
<div>
      <p>Address: ${contact.address}</p>
      <p>Phone: ${contact.phone}</p>
      <p>Work hours: ${contact.workHours}</p>
</div>
</#list>

<a href="/info">Back to info page</a>

</@c.page>