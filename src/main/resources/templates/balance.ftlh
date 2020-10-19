<#import "parts/common.ftlh" as c>
<@c.page>
    <br><br><br>
    <div class="container-fluid">
        <div class="row mb-3 row justify-content-end">
            <div class="col-md-2">
                <div class="card flex-row mb-4 shadow-sm h-md-250">
                    <div class="d-flex flex-column bd-highlight mb-2">
                        <div class="p-2 bd-highlight">
                            <h6 class="text-left text-muted">Баланс на сегодня</h6>
                                <h3 class="text-secondary">${balance.money}</h3>
                        </div>
                        <div class="p-2 bd-highlight">

                            <h6 class="text-left text-muted">Мой номер</h6>
                            <h5>${balance.number}</h5>
                            <br>
                            <form method="post" action=/balance/save class="form-select-button">
                                <input type="text" class="form-control" name="money" placeholder="Введите сумму (₽)"/>
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <br>
                                <button type="submit" class="btn btn-dark btn-block">Пополнение</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</@c.page>
