<#import "parts/common.ftlh" as c>
<#import "parts/coveragemap.ftlh" as n>

<@c.page>
    <body>
    <br>
            <div>
                <h3 class="display-5" style="padding-left: 20%">Карта покрытия</h3>
<br>
                <form  method="post">
                    <button type="submit" style="margin-left: 20%">Найти</button>
                    <br>
                    <div class="row" style="padding-left: 21.15%; padding-top: 15px">
                        <#list typepoints as typepoint>
                            <label><input type="checkbox"
                                          name="${typepoint}"  ${typepointschecked?seq_contains(typepoint)?string("checked", "")}>${typepoint.getTitle()}</label>
                        </#list>
                    </div>
                    <input type="hidden" value="${_csrf.token}" name="_csrf"/>

                </form>
                <br>
                <div class="row col-10" style="padding-left: 21%">
                    <@n.networkcoveragemap pointsacces/>
                </div>
                <br><br>
            </div>

    </body>

</@c.page>