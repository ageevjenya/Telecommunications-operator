<#import "parts/common.ftl" as c>

<@c.page>
<br>
  <h3>Send resume</h3><br>
    <p><strong>Vacancy: ${vacancy.name}</strong></p>
<br></br>

    <div>
            <form method="post" class="form-inline">
               <input type="text" class="form-control" name="firstName" placeholder="Enter firstname" />
               <input type="text" class="form-control" name="lastName" placeholder="Enter lastname" />
               <input type="text" class="form-control" name="birthday" placeholder="Enter birthday" />
               <input type="text" class="form-control" name="phone" placeholder="Enter phone" />
               <input type="text" class="form-control" name="email" placeholder="Enter e-mail" />
               <input type="text" class="form-control" name="text" placeholder="About yourself..." />
               <button type="submit" class="btn btn-default">Send</button>
            </form>
        </div>

    <br></br>
    <a href="/vacancy/${id}" class="btn text-nowrap-light">Back to vacancy</a>

</@c.page>