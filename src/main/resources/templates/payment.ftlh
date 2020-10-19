<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <form>
            <br><br><br><br>
            <h4 class="mb-3">Пополнение баланса</h4>

            <div class="d-block my-3">
                <div class="custom-control custom-radio">
                    <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                    <label class="custom-control-label" for="credit">Кредитная карта</label>
                </div>
                <div class="custom-control custom-radio">
                    <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                    <label class="custom-control-label" for="debit">Дебетовая карта</label>
                </div>
                <div class="custom-control custom-radio">
                    <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
                    <label class="custom-control-label" for="paypal">PayPal</label>
                </div>
                <div class="custom-control custom-radio">
                    <input id="webmoney" name="paymentMethod" type="radio" class="custom-control-input" required>
                    <label class="custom-control-label" for="webmoney">WebMoney</label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="cc-name">Имя</label>
                    <input type="text" class="form-control" id="cc-name" placeholder="" required>
                    <small class="text-muted">Полное имя, отображаемое на карте</small>
                    <div class="invalid-feedback">
                        Имя обязательное для заполнения поле!
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cc-number">Номер карты</label>
                    <input type="text" class="form-control" id="cc-number" placeholder="" required>
                    <div class="invalid-feedback">
                        Номер карты обязательное для заполнения поле!
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 mb-3">
                    <label for="cc-expiration">Срок действия</label>
                    <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                    <div class="invalid-feedback">
                        Срок действия обязательное для заполнения поле!
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="cc-cvv">CVV</label>
                    <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                    <div class="invalid-feedback">
                        Код безопасности обязательное для заполнения поле!
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-3 mb-3">
                    <form method="post" action=/payment class="form-select-button">
                        <input type="text" class="form-control" name="money" placeholder="Введите сумму (₽)"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <br>
                        <button type="submit" class="btn btn-primary btn-block">Пополнение</button>
                    </form>
                </div>
            </div>
            <br>
        </form>
    </div>
</@c.page>