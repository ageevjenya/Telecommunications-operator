<#import "parts/common.ftlh" as c>
<#import "parts/coveragemap.ftlh" as n>

<@c.page>
    <body>
    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <h3 class="display-5">Карта покрытия</h3>

                <form  method="post">
                    <button type="submit">Найти</button>
                    <div>
                        <#list typepoints as typepoint>
                            <label><input type="radio"
                                          name="${typepoint}"  ${typepointschecked?seq_contains(typepoint)?string("checked", "")}>${typepoint.getTitle()}</label>
                        </#list>
                    </div>
                    <input type="hidden" value="${_csrf.token}" name="_csrf"/>

                </form>
                <div class="col-6">
                    <@n.networkcoveragemap pointsacces/>
                </div>
            </div>
        </div>
    </div>

    </body>

</@c.page>