<#import "parts/common.ftlh" as c>

<@c.page>
    <br> <br><br><br>
    <form method="post" action="/promo/delete" class="form-inline">
        <input type="number" name="promoId" class="from-control" value="${promoId?ifExists}" placeholder="Search by id">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary ml-2">Delete</button>
    </form>

    <form method="post" action="/promo/update" class="form-inline">
        <input type="number" name="promoId" class="from-control" value="${promoId?ifExists}" placeholder="id">
        <input type="text" class="from-control" name="name" placeholder="Name">
        <input type="text" class="from-control" name="description" placeholder="Description">
        <input type="text" class="from-control" name="startDate" placeholder="Start date">
        <input type="text" class="from-control" name="endDate" placeholder="End date"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary ml-6">Update</button>
    </form>

    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/promo" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by name">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Promo
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Description">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="startDate" placeholder="Start date">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="endDate" placeholder="End date">
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list promos as promo>
            <div class="card my-3">
                <#if promo.filename??>
                    <img src="/img/${promo.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <span>${promo.name}</span>
                    <span>${promo.startDate}</span>
                    <span>${promo.endDate}</span>
                    <i>${promo.description}</i>
                </div>
                <div class="card-footer text-muted">
                    ${promo.authorName}
                </div>
            </div>
        <#else>
            No promo
        </#list>
    </div>
</@c.page>