<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Mobile tariffs</h1>

    <div>
        <form method="get" action="tariffs">
            <input type="text" name="filter" placeholder="Enter the name" />
            <button type="submit">Find</button>
        </form>
    </div>

    <br></br>

    <div>
      <table border="1">
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
        <form method="post" action="update">
           <input type="text" name="id" placeholder="Enter id" />
           <input type="text" name="name" placeholder="Enter the name" />
           <input type="text" name="priceOfMonth" placeholder="Enter price of month" />
           <input type="text" name="minutes" placeholder="Enter amount of minutes" />
           <input type="text" name="sms" placeholder="Enter amount of sms" />
           <input type="text" name="description" placeholder="Enter description" />
           <button type="submit">Edit</button>
        </form>
    </div>

    <br></br>

    <div>
        <form method="post" action="createMobile">
           <input type="text" name="name" placeholder="Enter the name" />
           <input type="text" name="priceOfMonth" placeholder="Enter price of month" />
           <input type="text" name="minutes" placeholder="Enter amount of minutes" />
           <input type="text" name="sms" placeholder="Enter amount of sms" />
           <input type="text" name="description" placeholder="Enter description" />
           <button type="submit">Create</button>
        </form>
    </div>

</@c.page>