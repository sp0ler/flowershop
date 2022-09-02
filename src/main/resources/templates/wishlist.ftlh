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

</body>

</html>