<#import "parts/common.ftlh" as c>
<#import "parts/networkcoveragemap.ftlh" as n>

<@c.page>
    <head>

        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"/>
        <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>

    </head>
    <body>
    <div>Карта покрытия</div>

    <div class="row">
        <div class="col-3">
            <form  action="/networkcoveragemap/filter" method="post">
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


    <#--    <script>-->
    <#--        // Creating map options-->
    <#--        var mapOptions = {-->
    <#--            center: [55.755814, 37.617635],-->
    <#--            zoom: 10,-->
    <#--            attributionControl: false-->
    <#--        }-->
    <#--        // Creating a map object-->
    <#--        var map = new L.map('map', mapOptions);-->
    <#--        // Creating a layer object-->
    <#--        var layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');-->

    <#--        // Adding layer to the map-->
    <#--        map.addLayer(layer);-->


    <#--        // // Icon options-->
    <#--        // var iconOptions = {-->
    <#--        //     iconRetinaUrl: "D:/NetCracker/Telecommunications-operator/src/main/resources/templates/antenna1.png",-->
    <#--        //     iconSize: [294, 171]-->
    <#--        // }-->
    <#--        //-->
    <#--        // // Creating a custom icon-->
    <#--        // var customIcon = L.icon(iconOptions);-->
    <#--        <#list pointsacces as pointacces>-->
    <#--        // Options for the marker-->
    <#--        var markerOptions = {-->
    <#--            title: "${pointacces.title}",-->
    <#--            clickable: true,-->
    <#--            draggable: false-->
    <#--            // icon: customIcon-->
    <#--        }-->
    <#--        // Creating a marker-->
    <#--        var marker = new L.Marker(["${pointacces.center}"], markerOptions);-->

    <#--        // Adding pop-up to the marker-->
    <#--        marker.bindPopup('Hi Welcome to Tutorialspoint').openPopup();-->

    <#--        // Adding marker to the map-->
    <#--        marker.addTo(map);-->
    <#--        </#list>-->





    <#--        // Creating latlng object-->
    <#--        var latlngs = [-->
    <#--            [55.783069, 37.692336],-->
    <#--            [55.797318, 37.653663],-->
    <#--            [55.822051, 37.671054],-->
    <#--            [55.822051, 37.671054],-->
    <#--            [55.796986, 37.707310]-->
    <#--        ];-->
    <#--        // Creating a polygon-->
    <#--        var polygon = L.polygon(latlngs, {color: 'red'});-->

    <#--        // Adding to polygon to map-->
    <#--        polygon.addTo(map);-->

    <#--        var circleCenter = [55.755814, 37.617635];     // Center of the circle-->

    <#--        // Circle options-->
    <#--        var circleOptions = {-->
    <#--            color: 'Lime',-->
    <#--            fillColor: '#00FF00',-->
    <#--            fillOpacity: 0.1-->
    <#--        }-->
    <#--        // Creating a circle-->
    <#--        var circle = L.circle(circleCenter, 50000, circleOptions);-->
    <#--        circle.addTo(map);     // Adding circle to the map-->

    <#--        // Creating latlng object-->
    <#--        var latlang = [-->
    <#--            [[17.385044, 78.486671], [16.506174, 80.648015], [17.686816, 83.218482]],-->
    <#--            [[13.082680, 80.270718], [12.971599, 77.594563], [15.828126, 78.037279]]-->
    <#--        ];-->
    <#--        // Creating multi polygon options-->
    <#--        var multiPolygonOptions = {color: 'red', weight: 8};-->

    <#--        // Creating multi polygons-->
    <#--        var multipolygon = L.multiPolygon(latlang, multiPolygonOptions);-->

    <#--        // Adding multi polygon to map-->
    <#--    -->
    <#--        multipolygon.addTo(map);-->

    <#--        // // Creating layer group-->
    <#--        // var layerGroup = L.layerGroup([hydMarker, vskpMarker, vjwdMarker, polygon]);-->
    <#--        // // Adding layer group to map-->
    <#--        // layerGroup.addTo(map);-->
    <#--        map.on("click", function (e) {-->
    <#--            new L.Marker([e.latlng.lat, e.latlng.lng]).addTo(map);-->
    <#--        })-->
    <#--    </script>-->

    </body>

</@c.page>