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

<section class="product" id="product">

    <div class="box-container">
        <#list allFlowers as flower>
            <div class="box">
                <#--                <span class="discount">-33%</span>-->
                <div class="icons">
                    <a href="#" class="fas fa-heart"></a>
                    <a href="#" class="fas fa-share"></a>
                </div>
                <img src="/resources/images/product-1.png" alt="">
                <h3>${flower.title}</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
                <div class="price">${flower.price} ₽</div>
                <#assign categoryNameEng = flower.category.getCategoryNameEng()>
                <a href="/category/${categoryNameEng}/${flower.id}" class="btn">Перейти</a>
            </div>
        </#list>

    </div>
</section>



<script src="/resources/js/script.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>