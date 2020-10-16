<#macro comfaq>
    <br>
    <h3 style="padding-left: 20%">F.A.Q.</h3><br>
    <#list faq as f>
        <div class="accordion" id="accordion" style="padding-left: 20%; width: 80%">
            <div class="card">
                <div class="card-header" style="background-color: white" id="${f.id}">
                    <h2 class="mb-0">
                        <button class="btn btn-link btn-dark btn-block text-center" style="color: white/*#314A40*/" type="button" data-toggle="collapse" data-target="#collapse${f.id}" aria-expanded="false" aria-controls="collapse${f.id}">
                            ${f.question}
                        </button>
                    </h2>
                </div>

                <div id="collapse${f.id}" class="collapse" aria-labelledby="${f.id}" data-parent="#accordion">

                    <div class="card-body text-center">
                        ${f.answer}
                    </div>
                </div>
            </div>
        </div>
    </#list>
</#macro>