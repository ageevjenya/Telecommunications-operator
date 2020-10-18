<#macro page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Telecommunication operator</title>
        <link rel="shortcut icon"
              href="http://s1.iconbird.com/ico/0612/vistabasesoftwareicons/w256h2561339252701Globe2.png"
              type="image/png">

        <link rel="stylesheet" href="/static/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
            <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"/>
            <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <style type="text/css">
            * { margin: 0; padding: 0; }
            p { padding: 10px; }
            #left { position: absolute; left: 0; top: 80px; width: 15%; }
            #right { position: absolute; left: 20%; right: 30px; top: 80px; width: 80%; }
        </style>


    </head>
    <body>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <#nested>
        <#--<br><br>
        <div id="footer" style="background-color: #314A40; color: white">
            <br>
            <h10 style="margin-left: 46%; margin-bottom: -15px">NetCracker</h10>
            <h11 style="margin-left: 45.4%">Москва, 2020</h11>
            <br><br>
        </div>-->
        <script>
        window.onload = function () {
            var scrolled;
            var timer;

            /*var scrollHeight = Math.max(
                document.body.scrollHeight, document.documentElement.scrollHeight,
                document.body.offsetHeight, document.documentElement.offsetHeight,
                document.body.clientHeight, document.documentElement.clientHeight
            );

            var element = document.getElementById("footer");
            element.style.marginTop = scrollHeight + "px";*/

            $(document).ready(function(){

                $(window).scroll(function(){
                    if (window.pageYOffset < 500) {
                        document.getElementById('top').style.display = 'none';
                    } else {
                        document.getElementById('top').style.display = '';
                    }
                });

            });

            document.getElementById('top').onclick = function () {
                scrolled = window.pageYOffset; //position
                //window.scrollTo(0, 0); //hard scroll
                scrollToTop();
            };

            function scrollToTop() {
                if (scrolled > 0) {
                    window.scrollTo(0, scrolled);
                    scrolled = scrolled - 20; // speed = 100
                    timer = setTimeout(scrollToTop, 0.1); // time 100 mls
                } else {
                    clearTimeout(timer);
                    window.scrollTo(0, 0); // for remains
                }
            }
        }
        </script>
        <button id="top" class="btn btn-outline-dark" style="position: fixed; right: 30px; bottom: 30px; wrap-option: 0px;
        cursor: pointer; display: none">Наверх</button>
    </div>
   </body>
    </html>
</#macro>