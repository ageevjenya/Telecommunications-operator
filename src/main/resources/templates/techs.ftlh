<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <br>
    <#if isAdmin>
        <a class="btn btn-primary" href="/adminModemTech">Управлять</a>
        <br>
    </#if>

</@c.page>