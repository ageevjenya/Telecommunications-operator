<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>Main page</div>
    <div><a href="/internet">Internet</a></div>
    <div><a href="/networkcoveragemap">Networkcoveragemap</a></div>
    <div>
        <@l.logout />
    </div>
</@c.page>