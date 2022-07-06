package ru.netology;

import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void actionList() {
        StringBuilder actionList = new StringBuilder();
        actionList.append("Выберите товар и количество или:\n");
        actionList.append("`show` - показать Корзину\n");
        actionList.append("`clear` - очистить Корзину\n");
        actionList.append("`end` - для выхода из программы\n");
        System.out.println(actionList.toString());
    }

    public static void main(String[] args) {
        // массив объектов типа Product (массив продуктов)
        Product[] products = {
                new Product(100, "Хлеб"),
                new Product(200, "Яблоки"),
                new Product(300, "Молоко"),
                new Product(450, "Мясо"),
                new Product(750, "Рыба"),
                new Product(70, "Соль"),
                new Product(130, "Сахар")
        };

        Cart cart = new Cart(products); // новая Корзина

        while (true) {
            int productNumber = 0;
            int productCount = 0;
            // показать ProductList
            Product.showProductList("\nСписок возможных товаров для покупки", products);

            actionList(); // список вариантов ввода
            String inputString = scanner.nextLine();
            if (inputString.equals("end") || inputString.equals("exit") || inputString.equals("close")) {
                System.out.println("\nПрограмма завершена!");
                System.out.println("\nВаша корзина:");
                cart.showCart(); // показать Корзину
                break;
            } else if (inputString.equals("show")) {
                cart.showCart(); // показать Корзину
            } else if (inputString.equals("clear")) {
                cart.clearCart();
                System.out.println("Корзина очищена!");
                System.out.println("Сумма товаров в Корзине: " + cart.getCartSum());
            } else {
                String[] arr = inputString.split("\\s");
                productNumber = Integer.parseInt(arr[0]) - 1;
                productCount = Integer.parseInt(arr[1]);
                cart.addProduct(productNumber, productCount); // добавили товар в Корзину
                System.out.println("Сумма товаров в Корзине: " + cart.getCartSum()); // вывод суммы товаров в Корзине
            }
        }
    }
}