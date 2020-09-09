<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="container">
        <div class="row">
            <div class="col mx-1 mt-3">
                <@l.login "/login" false />
            </div>
        </div>
    </div>
</@c.page>


