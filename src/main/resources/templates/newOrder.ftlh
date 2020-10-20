<#import "parts/common.ftlh" as c>
<@c.page>
    <br> <br><br><br>
    <div style="background-color: #314A40; color: white; margin-top: 15px; margin-left: 20%; margin-right: 20%">
    <br>
    <p class="text-center ml-5">Ваш заказ №${order.getId()} успешно оформлен!</p>
    <p class="text-center ml-5">Ожидайте, пожалуйста, с вами свяжется наш оператор.</p>
        <br>
    </div>
    <script>
        setTimeout(function(){
            window.location.href = '/';
        }, 3 * 1000);
    </script>
</@c.page>