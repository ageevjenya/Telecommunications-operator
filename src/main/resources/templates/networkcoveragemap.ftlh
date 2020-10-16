<#import "parts/common.ftlh" as c>
<#import "parts/coveragemap.ftlh" as n>

<@c.page>
<body>
    <script src="../static/jsfunctions/networkcoveragemap.js" type="text/javascript"></script>

    <div class="container">
        <div class="row">
            <div class="col mx-1">
                <h3 class="display-5">Карта покрытия</h3>

                <form  id="typePointAcces" >
                    <div>
                        <#list typepoints as typepoint>
                            <label><input name="typePointAcces" type="radio" id="${typepoint}"
                                          onclick="pointacceschoose(this)" value="${typepoint}"
                                        ${typepointschecked?seq_contains(typepoint)?string("checked", "")}>${typepoint.getTitle()}</label>
                        </#list>
                    </div>
                    <input id="_csrf" type="hidden" value="${_csrf.token}" name="_csrf"/>

                </form>
                <div class="col-6">
                    <@n.networkcoveragemap pointsacces/>
                </div>
            </div>
        </div>
    </div>
    <table class="table table-striped">
        <tbody id="pointAcces">
        </tbody>
    </table>
    </body>

</@c.page>