<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session. SPRING_SECURITY_CONTEXT.authentication.principal
    name= user.getUsername()
    <#--    isAdmin = user.isAdmin()-->
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    >
<#else>
    <#assign
    name = "гость"
    isAdmin = false
    >
</#if>