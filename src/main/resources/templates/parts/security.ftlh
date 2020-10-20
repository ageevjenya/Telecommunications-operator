
<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session. SPRING_SECURITY_CONTEXT.authentication.principal
    name= user.getUsername()
    <#--counts = user.getCartCount()-->
    <#--    isAdmin = user.isAdmin()-->
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    isUser = user.getAuthorities()?seq_contains('USER')
    isAuth = user.getAuthorities()??
        isManager = user.getAuthorities()?seq_contains('MANAGER')
        isSupport = user.getAuthorities()?seq_contains('SUPPORT')
    >
<#else>
    <#assign
    name = "гость"
    <#--counts = 0-->
    isAdmin = false
    isAuth = false
        isManager = false
        isSupport = false
    isUser = false
    >
</#if>