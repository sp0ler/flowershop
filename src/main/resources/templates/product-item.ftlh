<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>.Flower</title>

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- google font link  -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        a{
            text-decoration: none;
        }

        .wishlist .ion-icon{
            color: var(--green);
            background-color: var(--white);
            margin: -17px auto
        }

        .breadcrumb{
            background-color: #ffffff;
            color: var(--green);
            font-size: 14pt;
        }

        .breadcrumb a{
            color: var(--black);
            font-size: 14pt;
        }

        .small-img-group{
            display: flex;
            justify-content: space-between;
            position: relative;
        }

        .small-img-col{
            flex-basis: 24%;
            cursor: pointer;

        }

        .font-size{
            font-size: 14pt;
        }

        .font-size-h3{
            font-size: 20pt;
            font-weight: bold;
            text-transform: uppercase;
        }

        .font-size-h2{
            font-size: 16pt;
        }

        .font-size-h4{
            font-size: 18pt;
        }

        .font-size-span{
            font-size: 16pt;
        }

        .btn{
            display: inline-block;
            margin-top: 1rem;
            background:var(--green);
            color:#fff;
            padding:.8rem 3rem;
            font-size: 1.7rem;
            text-align: center;
            cursor: pointer;
        }

        .btn:hover{
            background:var(--black);
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
                    <span class="count" id="wishlist">${numberWishlist}</span>
                </button>
            </form>

            <form action="/cart" method="get">
                <button class="action-btn" href="/cart">
                    <ion-icon name="bag-handle-outline"></ion-icon>
                    <span class="count" id="cart">${numberCart}</span>
                </button>
            </form>

        </div>

    </div>

</header>

<!-- header section ends -->

<section class="container product-item my-5 pt-5">
    <iframe name="flower" id="flower" style="display: none;"></iframe>
    <form method="post" action="/cart" target="flower" id="flower" name="flower">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Главная</a></li>
            <li class="breadcrumb-item"><a href="/category/${flower.getCategory().getCategoryNameEng()}">${flower.getCategory().getCategoryName()}</a></li>
            <li class="breadcrumb-item active" aria-current="page">${flower.title}</li>
        </ol>
    </nav>

    <div class="row mt-5">
        <div class="col-lg-5 col-md-12 col-12 pb-1">
            <img class= "img-fluid w-100 pb-1" src="/resources/images/product-9.png" id="MainImg" alt="">

            <div class="small-img-group">
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-8.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-7.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-6.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-5.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-4.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-3.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-2.png" alt="">
                </div>
                <div class="small-img-col">
                    <img class= "small-img" width="100%" src="/resources/images/product-1.png" alt="">
                </div>
            </div>
        </div>

        <div class="col-lg-6 col-md-12 col-12">
            <br><br><br>
            <h3 class="font-size-h3">${flower.title}</h3>
            <br><br>
            <h2 class="font-size-h2">${flower.price} ₽</h2>


<#--                <button class="btn font-size">В корзину</button>-->
            <input class="btn font-size" type="submit" value="В корзину" onclick="incrementCart()">
            <button class="wishlist" href="#" onclick="incrementWishlist()">
                <ion-icon class="ion-icon" size="large" name="heart-outline"></ion-icon>
            <#--heart-sharp-->
            </button>

            <input type="hidden" name="flowerId" value="${flower.id}">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <h4 class="mt-5 font-size-h4">Описание</h4>
            <br>
            <span class="font-size-span">${flower.description}</span>
        </div>
    </div>
    </form>


</section>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

<script>
    const MainImg = document.getElementById('MainImg');
    const smallImg = document.getElementsByClassName('small-img');

    smallImg[0].onclick = function () {
        MainImg.src = smallImg[0].src;
    }
    smallImg[1].onclick = function () {
        MainImg.src = smallImg[1].src;
    }
    smallImg[2].onclick = function () {
        MainImg.src = smallImg[2].src;
    }
    smallImg[3].onclick = function () {
        MainImg.src = smallImg[3].src;
    }
    smallImg[4].onclick = function () {
        MainImg.src = smallImg[4].src;
    }
    smallImg[5].onclick = function () {
        MainImg.src = smallImg[5].src;
    }
    smallImg[6].onclick = function () {
        MainImg.src = smallImg[6].src;
    }
    smallImg[7].onclick = function () {
        MainImg.src = smallImg[7].src;
    }
    smallImg[8].onclick = function () {
        MainImg.src = smallImg[8].src;
    }

    function incrementCart() {
        const cartElem = document.getElementById('cart');
        let increment = Number(cartElem.textContent);
        increment++;
        cartElem.textContent = String(increment);
    }

    function incrementWishlist() {
        const wishlistElem = document.getElementById('wishlist');
        let increment = Number(wishlistElem.textContent);
        increment++;
        wishlistElem.textContent = String(increment);
    }

</script>

</body>
</html>