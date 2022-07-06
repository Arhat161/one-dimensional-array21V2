package ru.netology;

public class Product {
    private int price; // цена товара
    private String name; // наименование товара
    private int count = 0; // счетчик кол-ва товара для Корзины

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return this.count;
    }

    public void addCount(int number) {
        this.count += number;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // переопределение toString()
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.getName());
        sb.append(">, ");
        sb.append("[");
        sb.append(this.getPrice());
        sb.append("]");
        return sb.toString();
    }

    // вывод в консоль списка товаров
    static public void showProductList(String listTitle, Product[] products) {
        System.out.println(listTitle);
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].getName() + " " + products[i].getPrice() + " руб/шт");
        }
    }

}