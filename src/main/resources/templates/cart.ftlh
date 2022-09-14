<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>.Flower</title>

    <!-- font awesome cdn link  -->
<#--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">-->

    <!-- google font link  -->
<#--    <link rel="preconnect" href="https://fonts.googleapis.com">-->
<#--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>-->
<#--    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap"-->
<#--          rel="stylesheet">-->

    <!-- custom css file link  -->
<#--    <link rel="stylesheet" href="/resources/css/style.css">-->
    <link rel="stylesheet" href="/resources/css/style.cart.css">
    <link
            href="https://fonts.googleapis.com/css?family=Source+Sans+3:200,300,regular,500,600,700,800,900,200italic,300italic,italic,500italic,600italic,700italic,800italic,900italic"
            rel="stylesheet" />
    <style>
        .infoCard{
            visibility: hidden;
        }
        .btn{
            visibility: hidden;
        }
    </style>
</head>
<body>

<!-- header section starts  -->

<header>

    <div class="header-1">

        <a href="/" class="logo"><i class="fas fa-shopping-basket"></i>.Flowers</a>

        <form action="" class="search-box-container">
            <input type="search" id="search-box" placeholder="Поиск...">
            <label for="search-box" class="fas fa-search"></label>
        </form>

    </div>

    <div class="header-2">

        <div id="menu-bar" class="fas fa-bars"></div>

        <nav class="navbar">
            <a href="/">Главная</a>
            <a href="/category">Категории</a>
            <a href="/product">Позиции</a>
            <a href="#deal">Специальные предложения</a>
            <a href="#contact">Контакты</a>
        </nav>

        <div class="header-user-actions">
            <form action="/profile" method="get">
                <button class="action-btn" href="/profile">
                    <ion-icon name="person-outline"></ion-icon>
                </button>
            </form>

            <form action="/wishlist" method="get">
                <button class="action-btn" href="/wishlist">
                    <ion-icon name="heart-outline"></ion-icon>
                    <span class="count">${numberWishlist}</span>
                </button>
            </form>

            <form action="/cart" method="get">
                <button class="action-btn" href="/cart">
                    <ion-icon name="bag-handle-outline"></ion-icon>
                    <span class="count">${numberCart}</span>
                </button>
            </form>

        </div>

    </div>

</header>


<main class="container">
    <div class="item-flex">

        <!--
         - checkout section
        -->
        <section class="checkout">

            <h2 class="section-heading">Выбор даты и времени доставки</h2>
            <br><br><br>

            <h2 class="section-heading">Выбор оплаты</h2>

            <div class="payment-form">

                <div class="payment-method">

<#--                    <button class="method selected">-->
                    <button class="method payCard" onclick="card()">
                        <ion-icon name="card-outline"></ion-icon>

                        <span>Безналичный расчет</span>

<#--                        <ion-icon class="checkmark fill" name="checkmark-circle-outline"></ion-icon>-->
                        <ion-icon class="checkmark" name="checkmark-circle-outline"></ion-icon>
                    </button>

                    <button class="method payCash" onclick="cash()">
                        <ion-icon name="cash-outline"></ion-icon>

                        <span>Наличный расчет</span>

                        <ion-icon class="checkmark" name="checkmark-circle-outline"></ion-icon>
                    </button>

                </div>

                <form class="infoCard" id="infoCard">

                    <div class="cardholder-name">
                        <label for="cardholder-name" class="label-default">Имя владельца</label>
                        <input type="text" name="cardholder-name" id="cardholder-name" class="input-default">
                    </div>

                    <div class="card-number">
                        <label for="card-number" class="label-default">Номер карты</label>
                        <input type="number" name="card-number" id="card-number" class="input-default">
                    </div>

                    <div class="input-flex">

                        <div class="expire-date">
                            <label for="expire-date" class="label-default">Дата истечения срока</label>

                            <div class="input-flex">

                                <input type="number" name="day" id="expire-date" placeholder="31" min="1" max="31"
                                       class="input-default">
                                /
                                <input type="number" name="month" id="expire-date" placeholder="12" min="1" max="12"
                                       class="input-default">

                            </div>
                        </div>

                        <div class="cvv">
                            <label for="cvv" class="label-default">CVV</label>
                            <input type="number" name="cvv" id="cvv" class="input-default">
                        </div>

                    </div>

                </form>

            </div>


            <form action="/payCard" id="buttonCard">
                <button class="btn btn-primary buttonCard" id="buttonCard">
                    <b>Оплатить 1</b> $ <span id="payAmount">2.15</span>
                </button>
            </form>

            <form action="/payCash" id="buttonCash">
                <button class="btn btn-primary buttonCash" id="buttonCash">
                    <b>Оплатить 2</b> $ <span id="payAmount">2.15</span>
                </button>
            </form>


        </section>


        <!--
          - cart section
        -->
        <section class="cart">

            <div class="cart-item-box">

                <h2 class="section-heading">Order Summery</h2>

                <#list cartItems as cartItem>
                    <#assign flower = cartItem.getFlower()>

                    <div class="product-card ${cartItem.id}">

                        <div class="card">

                            <div class="img-box">
                                <img src="/resources/images/product-1.png" alt="Green tomatoes" width="80px" class="product-img">
                            </div>

                            <div class="detail">

                                <h4 class="product-name">${flower.title}</h4>

                                <div class="wrapper">

                                    <div class="product-qty">
                                        <button id="decrement">
                                            <ion-icon name="remove-outline"></ion-icon>
                                        </button>

                                        <span id="quantity">1</span>

                                        <button id="increment">
                                            <ion-icon name="add-outline"></ion-icon>
                                        </button>
                                    </div>

                                    <div class="price">
                                        <span id="price">#{flower.price}</span> ₽
                                    </div>

                                </div>

                            </div>

                            <iframe name="deleteFlowerFromCart" id="deleteFlowerFromCart" style="display: none;"></iframe>
                            <form action="/deleteFlowerFromCart" method="post" target="deleteFlowerFromCart" id="delete ${cartItem.id}">
                                <button class="product-close-btn" formmethod="post" type="submit">
                                    <ion-icon name="close-outline"></ion-icon>
                                    <input type="hidden" >
                                </button>
                                <input type="hidden" name="cartItemId" value="${cartItem.id}"/>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>

                        </div>
                    </div>

                </#list>

            </div>

            <div class="wrapper">

                <div class="discount-token">

                    <label for="discount-token" class="label-default">Gift card/Discount code</label>

                    <div class="wrapper-flex">

                        <input type="text" name="discount-token" id="discount-token" class="input-default">

                        <button class="btn btn-outline">Apply</button>

                    </div>

                </div>

                <div class="amount">

                    <div class="subtotal">
                        <span>Subtotal</span> <span>$ <span id="subtotal">2.05</span></span>
                    </div>

                    <div class="tax">
                        <span>Tax</span> <span>$ <span id="tax">0.10</span></span>
                    </div>

                    <div class="shipping">
                        <span>Shipping</span> <span>$ <span id="shipping">0.00</span></span>
                    </div>

                    <div class="total">
                        <span>Total</span> <span>$ <span id="total">2.15</span></span>
                    </div>

                </div>

            </div>

        </section>

    </div>

</main>







<script src="/resources/js/script.cart.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

<script>
    function card() {
        const buttonCard = document.getElementsByClassName('btn btn-primary buttonCard');
        const buttonCash = document.getElementsByClassName('btn btn-primary buttonCash');
        const infoCard = document.getElementsByClassName('infoCard');
        const payCard = document.getElementsByClassName('payCard');
        const payCash = document.getElementsByClassName('payCash');

        buttonCard[0].style.visibility = 'inherit';
        buttonCash[0].style.visibility = 'hidden';

        infoCard[0].style.display = '';
        infoCard[0].style.visibility = 'inherit';

        buttonCard[0].style.display = '';
        buttonCash[0].style.display = 'none';

        payCard[0].className = "method payCard selected";
        payCash[0].className = "method payCash";
    }

    function cash() {
        const buttonCard = document.getElementsByClassName('btn btn-primary buttonCard');
        const buttonCash = document.getElementsByClassName('btn btn-primary buttonCash');
        const infoCard = document.getElementsByClassName('infoCard');
        const payCard = document.getElementsByClassName('payCard');
        const payCash = document.getElementsByClassName('payCash');

        buttonCard[0].style.visibility = 'hidden';
        buttonCash[0].style.visibility = 'inherit';

        infoCard[0].style.display = 'none';
        infoCard[0].style.visibility = 'hidden';

        buttonCard[0].style.display = 'none';
        buttonCash[0].style.display = '';

        payCard[0].className = "method payCard";
        payCash[0].className = "method payCash selected";

    }

    function decrementCart() {
        const cartElem = document.getElementById('cart');
        let increment = Number(cartElem.textContent);
        increment--;
        cartElem.textContent = String(increment);
    }

    function deleteDiv(id) {
        const elements = document.getElementsByClassName('product-card ' + id);
        while(elements.length > 0){
            elements[0].parentNode.removeChild(elements[0]);
        }

        // TODO
        // decrementCart()

        let xhr = new XMLHttpRequest();
        xhr.open('GET', '/deleteFlowerFromCart?id=' + id, true);
        xhr.send(null);
    }

    <#list cartItems as cartItem>
        let element${cartItem.id} = document.getElementById("delete ${cartItem.id}");
        element${cartItem.id}.onclick = function () {
            deleteDiv(${cartItem.id});
        }
    </#list>

</script>

</body>

</html>