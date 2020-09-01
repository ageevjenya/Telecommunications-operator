<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <h3>Мобильная связь</h3>
    <br>

    <div>
        <form method="get" action="tariffs" class="form-inline">
            <input type="text" class="form-control" name="filter" placeholder="Пакет" />
            <button type="submit" class="btn btn-default">Найти</button>
        </form>
    </div>

    <br><br>

    <div>
      <table class="table table-hover">
        <tr>
          <th>Пакет</th>
          <th>Минуты</th>
          <th>SMS</th>
          <th>Интернет, GB</th>
          <th>Цена, руб/мес</th>
          <th>Описание</th>
            <#if isAdmin>
                <th>Удалить</th>
                <#else>
                <th></th>
            </#if>
        </tr>
        <#list mobileTariffs as mobileTariff>
        <tr>
          <td>${mobileTariff.name}</td>
          <td>${mobileTariff.minutes}</td>
          <td>${mobileTariff.sms}</td>
          <td>${mobileTariff.gbInternet}</td>
          <td>${mobileTariff.priceOfMonth}</td>
          <td>${mobileTariff.description}</td>
          <#if isAdmin>
              <td><a href="/delete/${mobileTariff.id}">Удалить</a></td>
              <input type="hidden" name="_csrf" value="${_csrf.token}"/>
              <#else>
              <td><a href="#">Подключить</a></td>
          </#if>
        </tr>
        </#list>
      </table>
    </div>

    <#if isAdmin>
        <br></br>
    <div>
        <form method="post" action="update" class="form-inline">
           <input type="text" class="form-control" name="id" placeholder="Enter id" />
           <input type="text" class="form-control" name="name" placeholder="Enter the name" />
           <input type="text" class="form-control" name="priceOfMonth" placeholder="Enter price of month" />
           <input type="text" class="form-control" name="minutes" placeholder="Enter amount of minutes" />
           <input type="text" class="form-control" name="sms" placeholder="Enter amount of sms" />
           <input type="text" class="form-control" name="gbInternet" placeholder="Enter GB of internet" />
           <input type="text" class="form-control" name="description" placeholder="Enter description" />
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
           <button type="submit" class="btn btn-default">Обновить</button>
        </form>
    </div>

    <br>

    <div>
        <form method="post" action="createMobile" class="form-inline">
           <input type="text" class="form-control" name="name" placeholder="Enter the name" />
           <input type="text" class="form-control" name="priceOfMonth" placeholder="Enter price of month" />
           <input type="text" class="form-control" name="minutes" placeholder="Enter amount of minutes" />
           <input type="text" class="form-control" name="sms" placeholder="Enter amount of sms" />
            <input type="text" class="form-control" name="gbInternet" placeholder="Enter GB of internet" />
           <input type="text" class="form-control" name="description" placeholder="Enter description" />
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
           <button type="submit" class="btn btn-default">Добавить</button>
        </form>
    </div>
    </#if>
</@c.page>