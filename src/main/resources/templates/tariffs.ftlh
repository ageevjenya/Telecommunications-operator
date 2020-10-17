<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <h3 style="margin-left: 3%">Мобильная связь</h3>
    <br>

    <div style="margin-left: 3%">
        <form method="get" action="tariffs" class="form-inline">
            <input type="text" class="form-control" name="filter" placeholder="Пакет" />
            <button type="submit" class="btn btn-light" style="margin-left: 7px">Найти</button>
        </form>
    </div>

    <br><br>

    <div>
      <table class="table table-hover" style="margin-left: 3%; width: 95%">
        <tr>
            <#if isAdmin>
                <th>ID</th>
            </#if>
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
            <#if isAdmin>
                <td>${mobileTariff.id}</td>
            </#if>
          <td>${mobileTariff.name}</td>
          <td>${mobileTariff.minutes}</td>
          <td>${mobileTariff.sms}</td>
          <td>${mobileTariff.gbInternet}</td>
          <td>${mobileTariff.priceOfMonth}</td>
          <td>${mobileTariff.description}</td>
            <#if isAuth>
                <td>
                    <#if userTariffMobile?? && userTariffMobile==mobileTariff>
                        <strong style="margin-left: 10px">Подключено</strong>
                    <#else>
                        <form method="post" action="/connect" class="form-inline">
                            <input type="hidden" name="tariffMobileId" value="${mobileTariff.id?c}"/>
                            <input type="hidden" name="name" value="${mobileTariff.name}"/>
                            <input type="hidden" name="minutes" value="${mobileTariff.minutes}"/>
                            <input type="hidden" name="sms" value="${mobileTariff.sms}"/>
                            <input type="hidden" name="gbInternet"
                                   value="${mobileTariff.gbInternet}"/>
                            <input type="hidden" name="description"
                                   value="${mobileTariff.description}"/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <#if userTariffMobile??>
                                <button type="submit" class="btn btn-light">Подключить</button>
                                <#else>
                                <button type="submit" class="btn btn-dark">Подключить</button>
                            </#if>
                        </form>
                    </#if>
                </td>
            </#if>
          <#if isAdmin>
              <td><a href="/delete/${mobileTariff.id}">Удалить</a></td>
              <input type="hidden" name="_csrf" value="${_csrf.token}"/>
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
           <input type="text" class="form-control" name="gbInternet" placeholder="Enter GB of tariffHome" />
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
            <input type="text" class="form-control" name="gbInternet" placeholder="Enter GB of tariffHome" />
           <input type="text" class="form-control" name="description" placeholder="Enter description" />
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
           <button type="submit" class="btn btn-default">Добавить</button>
        </form>
    </div>
    </#if>
</@c.page>