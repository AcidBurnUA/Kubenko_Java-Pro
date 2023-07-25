package Homework18;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(String type, double price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
    public List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .collect(Collectors.toList());
    }
    public List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.hasDiscount())
                .map(product -> new Product(
                        product.getType(),
                        product.getPrice() * 0.9,
                        product.hasDiscount(),
                        product.getCreateDate()
                ))
                .collect(Collectors.toList());
    }
    public Product findCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }
    public List<Product> getLastThreeProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
    public double calculateTotalPriceOfBooks(List<Product> products) {
        int currentYear = LocalDate.now().getYear();
        return products.stream()
                .filter(product -> product.getType().equals("Book")
                        && product.getCreateDate().getYear() == currentYear
                        && product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }
    public Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
