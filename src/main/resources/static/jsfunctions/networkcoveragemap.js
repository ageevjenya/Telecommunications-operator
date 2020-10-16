function pointacceschoose(input) {
    let typePointInput = {};
    typePointInput[input.name] = input.value;
    // console.log(typePointInput);
    //this need for work
    $(function () {
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/networkcoveragemap/pointacces", //?_csrf=" + $("#_csrf").val(), //or this need for work
        dataType: 'json',
        data: JSON.stringify(typePointInput),
        success: function (data) {
            // console.log(data);
            pointAcessAdd(data);
            // setTimeout(function () {
            // }, (300));
        }
    });

};

function exapleinputintable(type) {
    let htmlId = '#pointAcces';
    let couriersInput = {};
    couriersInput[type.name] = type.value;
    console.log(type);
    console.log(type.name);
    console.log(type.value);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/networkcoveragemap/pointacces",
        data: JSON.stringify(),
        dataType: 'json',
        cache: false,
        timeout: 60000,
        success: function (data) {
            console.log(data);
            let view;
            let newLine;
            for (let i = 0; i < data.length; i++) {

                newLine =
                    "<tr>" +
                    "            <th scope=\"row\">" + data[i].id + "</th>\n" +
                    "            <td>" + data[i].longitude + "</td>\n" +
                    "            <td>" + data[i].latitude + "</td>\n" +
                    "</tr>";
                if (typeof view === 'undefined') {
                    view = "" + newLine;
                } else {
                    view = view + newLine;
                }

            }
            $(htmlId).html(view);
        }
    });


};

function pointAcessAdd(data) {
    if (data) {
        let map = createMap();

        // Icon options
        var iconOptions = {
            // iconRetinaUrl: "https://cdn.icon-icons.com/icons2/1522/PNG/512/antennalinear_106189.png",

            iconRetinaUrl: "/images/antenna.jpg",

            iconSize: [10, 10]
        }

        // Creating a custom icon
        var customIcon = L.icon(iconOptions);
        // Creating layer group
        var layerGroup = L.layerGroup();

        for (let i = 0; i < data.length; i++) {
            // Options for the marker
            var markerOptions = {
                title: data[i].title,
                clickable: true,
                draggable: false,
                icon: customIcon
            }
            // Creating a marker
            var marker = new L.Marker([data[i].latitude.toString().replace(",", "."), data[i].longitude.toString().replace(",", ".")], markerOptions);

            // Adding pop-up to the marker
            marker.bindPopup(data[i].info).openPopup();

            // Adding marker to the map
            marker.addTo(layerGroup);

            // Center of the circle
            var circleCenter = [data[i].latitude.toString().replace(",", "."), data[i].longitude.toString().replace(",", ".")];

            // Circle options
            var circleOptions = {
                stroke: false,
                color: 'Lime',
                fillColor: '#00FF00',
                fillOpacity: 0.2
            }
            var radius = parseInt(data[i].radius.toString().replace(/\s+/g, ''), 10);
            // Creating a circle
            var circle = L.circle(circleCenter, radius, circleOptions);
            circle.addTo(layerGroup);     // Adding circle to the map

            // Adding layer group to map
            layerGroup.addTo(map);

            //$(htmlId).html(map);
        }
    }
};

function createMap() {
    let container = document.getElementById('map');
    if (container != null) {
        container._leaflet_id = null;
    }
    // Creating map options
    var mapOptions = {
        center: [55.755814, 37.617635],
        zoom: 10,
        attributionControl: false
    }
    // Creating a map object
    var map = new L.map('map', mapOptions);
    //let map  = document.getElementById('map');
    // Creating a layer object
    var layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');

    // Adding layer to the map
    map.addLayer(layer);
    return map;
};