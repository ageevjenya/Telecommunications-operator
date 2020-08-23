<#macro manage path names>
<div>
<form method="post" action="${path}" name="${names}">

            <#list names as name>
            <input type="text" name="name" placeholder="name" />
            </#list>
            <button type="submit">Send</button>

</form>
</div>
</#macro>