package ru.netology;

class Cart {
    private Product[] productInCart;
    private int sumProducts = 0; // сумма всех товаров в Корзине

    // клонируем массив продуктов в Корзину
    public Cart(Product[] products) {
        this.productInCart = products.clone();
    }

    // добавляем продукт в Корзину на основе номера продукта и его количества
    public void addProduct(int productNumber, int productCount) {
        int price = this.productInCart[productNumber].getPrice(); // цена продукта
        this.productInCart[productNumber].addCount(productCount); // увеличиваем количество продукта
        int count = this.productInCart[productNumber].getCount(); // получаем количество в Корзине
        this.sumProducts = this.sumProducts + (price * count); // получаем сумму этого товара в Корзине
    }

    // Показать Корзину (вывод одновременно с пересчетом)
    public void showCart() {
        this.sumProducts = 0;
        // вывод шапки Корзины
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("|%-20s  |  %7s  |  %7s  |  %7s |%n", "Наименование товара", "Количество", "Цена/за ед.", "Общая стоимость");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < this.productInCart.length; i++) {
            // вывод каждой строки в Корзине, если кол-во заказанных продуктов не равно нулю
            if (this.productInCart[i].getCount() > 0) {
                System.out.printf("|%-20s  |  %10s  |  %11s  |  %15s |%n", this.productInCart[i].getName(), this.productInCart[i].getCount(), this.productInCart[i].getPrice(), (this.productInCart[i].getCount() * this.productInCart[i].getPrice()));
            }
            // подсчет общей суммы Корзины
            this.sumProducts += this.productInCart[i].getCount() * this.productInCart[i].getPrice();
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%73s", "Итого " + this.sumProducts + " руб.");
    }

    // Вернуть сумму товаров в Корзине
    public int getCartSum() {
        this.sumProducts = 0;
        for (int i = 0; i < this.productInCart.length; i++) {
            // подсчет общей суммы Корзины
            this.sumProducts += this.productInCart[i].getCount() * this.productInCart[i].getPrice();
        }
        return this.sumProducts;
    }

    // очистить Корзину
    public void clearCart() {
        this.sumProducts = 0;
        for (int i = 0; i < this.productInCart.length; i++) {
            this.productInCart[i].setCount(0);
        }
    }
}