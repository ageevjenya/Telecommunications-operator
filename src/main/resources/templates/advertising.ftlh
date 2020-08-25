<#import "parts/common.ftlh" as c>

<@c.page>
    <form method="post" action="/advertising/delete" class="form-inline">
        <input type="number" name="advertisingId" class="from-control" value="${advertisingId?ifExists}" placeholder="Search by id">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary ml-2">Delete</button>
    </form>

    <form method="post" action="/advertising/update" class="form-inline">
        <input type="number" name="advertisingId" class="from-control" value="${advertisingId?ifExists}" placeholder="id">
        <input type="text" class="from-control" name="name" placeholder="Name">
        <input type="text" class="from-control" name="description" placeholder="Description">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary ml-2">Update</button>
    </form>

    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/advertising" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by name">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Advertising
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description">
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
        <#list advertisings as advertising>
            <div class="card my-3">
                <#if advertising.filename??>
                    <img src="/img/${advertising.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <span>${advertising.name}</span>
                    <i>${advertising.description}</i>
                </div>
                <div class="card-footer text-muted">
                    ${advertising.authorName}
                </div>
            </div>
        <#else>
            No advertising
        </#list>
    </div>
</@c.page>