<#import "parts/common.ftl" as c>

<@c.page>
  <h1>Send resume</h1>
    <p>${vacancy.name}</p>
<br></br>

    <div>
            <form method="post">
               <input type="text" name="firstName" placeholder="Enter firstname" />
               <input type="text" name="lastName" placeholder="Enter lastname" />
               <input type="text" name="birthday" placeholder="Enter birthday" />
               <input type="text" name="phone" placeholder="Enter phone" />
               <input type="text" name="email" placeholder="Enter email" />
               <input type="text" name="text" placeholder="About yourself..." />
               <button type="submit">Send</button>
            </form>
        </div>

    <br></br>
    <a href="/vacancy/${id}">Back to vacancy</a>

</@c.page>