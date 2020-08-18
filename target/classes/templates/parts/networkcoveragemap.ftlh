<#macro networkcoveragemap pointsacces>

    <div id="map" style="width:900px; height:500px;"></div>
    <script>
        // Creating map options
        var mapOptions = {
            center: [55.755814, 37.617635],
            zoom: 10,
            attributionControl: false
        }
        // Creating a map object
        var map = new L.map('map', mapOptions);
        // Creating a layer object
        var layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');

        // Adding layer to the map
        map.addLayer(layer);
    </script>
    <script>
        <#if pointsacces?has_content>

        <#list pointsacces as pointacces>
        // Options for the marker
        var markerOptions = {
            title: '${pointacces.title}',
            clickable: true,
            draggable: false
            // icon: customIcon
        }
        // Creating a marker
        var marker = new L.Marker(["${pointacces.latitude}", "${pointacces.longitude}"], markerOptions);

        // Adding pop-up to the marker
        marker.bindPopup('${pointacces.title}').openPopup();

        // Adding marker to the map
        marker.addTo(map);

        var circleCenter = ["${pointacces.latitude}", "${pointacces.longitude}"];     // Center of the circle

        // Circle options
        var circleOptions = {
            color: 'Lime',
            fillColor: '#00FF00',
            fillOpacity: 0.1
        }
        // Creating a circle
        var circle = L.circle(circleCenter, "${pointacces.radius}", circleOptions);
        circle.addTo(map);     // Adding circle to the map
        </#list>
        </#if>
    </script>
</#macro>