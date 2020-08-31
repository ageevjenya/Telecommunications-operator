<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <br>
    <#if isAdmin>
        <div>
            <form method="post" action="create" class="form-inline">
                <input type="text" class="form-control" name="deviceName" placeholder="Device name" />
                <input type="text" class="form-control" name="name" placeholder="Name" />
                <input type="text" class="form-control" name="price" placeholder="Price" />
                <input type="text" class="form-control" name="description" placeholder="Description" />
                <input type="text" class="form-control" name="shortDescription" placeholder="Short description" />
                <input type="text" class="form-control" name="specifications" placeholder="Specifications" />
                <input type="text" class="form-control" name="imgUrl" placeholder="Image URL" />
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Добавить</button>
            </form>
        </div>

        <br>

        <div>
        <form method="post" action="update" class="form-inline">
            <input type="text" class="form-control" name="deviceName" placeholder="Device name" />
            <input type="text" class="form-control" name="id" placeholder="ID" />
            <input type="text" class="form-control" name="name" placeholder="Name" />
            <input type="text" class="form-control" name="price" placeholder="Price" />
            <input type="text" class="form-control" name="description" placeholder="Description" />
            <input type="text" class="form-control" name="shortDescription" placeholder="Short description" />
            <input type="text" class="form-control" name="specifications" placeholder="Specifications" />
            <input type="text" class="form-control" name="imgUrl" placeholder="Image URL" />
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-default">Обновить</button>
        </form>
        </div>

        <br>

        <div>
            <form method="post" action="delete" class="form-inline">
                <input type="text" class="form-control" name="deviceName" placeholder="Device name" />
                <input type="text" class="form-control" name="id" placeholder="ID" />
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Удалить</button>
            </form>
        </div>
    </#if>
</@c.page>