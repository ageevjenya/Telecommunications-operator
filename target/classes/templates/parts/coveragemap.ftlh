<#macro networkcoveragemap pointsacces>
    <head>

        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"/>
        <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>

    </head>
    <div id="map" style="width:1100px; height:500px;"></div>
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


        // Icon options
        var iconOptions = {
            iconRetinaUrl: "https://cdn.icon-icons.com/icons2/1522/PNG/512/antennalinear_106189.png",
            iconSize: [10, 10]
        }

        // Creating a custom icon
        var customIcon = L.icon(iconOptions);
        // Creating layer group
        var layerGroup = L.layerGroup();
    </script>
    <script>
        <#if pointsacces?has_content>
        <#list pointsacces as pointacces>

        // Options for the marker
        var markerOptions = {
            title: '${pointacces.title}',
            clickable: true,
            draggable: false,
            icon: customIcon
        }
        // Creating a marker
        var marker = new L.Marker(['${pointacces.latitude}'.replace(",", "."), '${pointacces.longitude}'.replace(",", ".")], markerOptions);

        // Adding pop-up to the marker
        marker.bindPopup('${pointacces.info}').openPopup();

        // Adding marker to the map
        marker.addTo(layerGroup);

        // Center of the circle
        var circleCenter = ['${pointacces.latitude}'.replace(",", "."), '${pointacces.longitude}'.replace(",", ".")];

        // Circle options
        var circleOptions = {
            stroke: false,
            color: 'Lime',
            fillColor: '#00FF00',
            fillOpacity: 0.2
        }
        var radius = parseInt('${pointacces.radius}'.replace(/\s+/g, ''), 10);
        // Creating a circle
        var circle = L.circle(circleCenter, radius, circleOptions);
        circle.addTo(layerGroup);     // Adding circle to the map
        </#list>
        // Adding layer group to map
        layerGroup.addTo(map);
        </#if>
    </script>
</#macro>