<#import "../parts/common.ftlh" as c>
<#import "../parts/coveragemap.ftlh" as n>

<@c.page>
    <head>

        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"/>
        <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>

    </head>
    <body>
    <div>Карта покрытия</div>

    <div class="row">
        <div class="col-3">
<#--            action="/networkcoveragemap/filter" method="post"-->
            <form>
                <div>
                    <#list typepoints as typepoint>
                        <label><input type="checkbox"
                                      name="${typepoint}" checked>${typepoint.getTitle()}</label>
                    </#list>
                </div>
                <input type="hidden" value="${_csrf.token}" name="_csrf"/>
                <button type="submit">Найти</button>
            </form>
        </div>
        <div class="col-6">
            <@n.networkcoveragemap pointsacces />
        </div>
    </div>


    </body>

</@c.page>