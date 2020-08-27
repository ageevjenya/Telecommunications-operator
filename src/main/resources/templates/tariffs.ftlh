<#import "parts/common.ftlh" as c>
<@c.page>
    <br>
    <h3>Mobile tariffs</h3>
    <br>

    <div>
        <form method="get" action="tariffs" class="form-inline">
            <input type="text" class="form-control" name="filter" placeholder="Enter the name" />
            <button type="submit" class="btn btn-default">Find</button>
        </form>
    </div>

    <br></br>

    <div>
      <table class="table table-hover">
        <tr>
          <th>Name</th>
          <th>Minutes</th>
          <th>SMS</th>
          <th>Price of month</th>
          <th>Description</th>
          <th>Delete</th>
        </tr>
        <#list mobileTariffs as mobileTariff>
        <tr>
          <td>${mobileTariff.name}</td>
          <td>${mobileTariff.minutes}</td>
          <td>${mobileTariff.sms}</td>
          <td>${mobileTariff.priceOfMonth}</td>
          <td>${mobileTariff.description}</td>
          <td><a href="/delete/${mobileTariff.id}">Delete</a></td>
        </tr>
        </#list>
      </table>
    </div>

    <br></br>

    <div>
        <form method="post" action="update" class="form-inline">
           <input type="text" class="form-control" name="id" placeholder="Enter id" />
           <input type="text" class="form-control" name="name" placeholder="Enter the name" />
           <input type="text" class="form-control" name="priceOfMonth" placeholder="Enter price of month" />
           <input type="text" class="form-control" name="minutes" placeholder="Enter amount of minutes" />
           <input type="text" class="form-control" name="sms" placeholder="Enter amount of sms" />
           <input type="text" class="form-control" name="description" placeholder="Enter description" />
           <button type="submit" class="btn btn-default">Edit</button>
        </form>
    </div>

    <br></br>

    <div>
        <form method="post" action="createMobile" class="form-inline">
           <input type="text" class="form-control" name="name" placeholder="Enter the name" />
           <input type="text" class="form-control" name="priceOfMonth" placeholder="Enter price of month" />
           <input type="text" class="form-control" name="minutes" placeholder="Enter amount of minutes" />
           <input type="text" class="form-control" name="sms" placeholder="Enter amount of sms" />
           <input type="text" class="form-control" name="description" placeholder="Enter description" />
           <button type="submit" class="btn btn-default">Create</button>
        </form>
    </div>

</@c.page>