package tpp.uni.plovdiv;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestApplication {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        try (Files.newBufferedReader())

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Set products count: ");
            int productsCount = Integer.parseInt(scanner.nextLine());
            for(int i = 0; i < productsCount; i++) {
                Product product = createProductFromConsoleInput(scanner);
                products.add(product);
            }
        }

        List<Product> heavierThan10Kg = products.stream()
                .filter(p -> p.weightInKg > 10)
                .collect(Collectors.toList());

        System.out.println(heavierThan10Kg);

        double sumWeight = products.stream()
                .mapToDouble(p -> p.weightInKg)
                .sum();
        System.out.println(sumWeight);

        BigDecimal priceSum = products.stream()
                .map(p -> p.priceInBgn)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(priceSum);
    }

    private static Product createProductFromConsoleInput(Scanner scanner) {
        System.out.println("Creating new product");
        System.out.println("Code:");
        String code = scanner.nextLine();
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Weight in kg:");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Price in BGN:");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        return createProduct(code, name, weight, price);
    }

    private static Product createProduct(String code, String name, double weightInKg, BigDecimal priceInBgn) {
        return new Product(code, name, weightInKg, priceInBgn);
    }

    private static class Product {

        String code;
        String name;
        double weightInKg;
        BigDecimal priceInBgn;

        Product(String code, String name, double weightInKg, BigDecimal priceInBgn) {
            this.code = code;
            this.name = name;
            this.weightInKg = weightInKg;
            this.priceInBgn = priceInBgn;
        }

        @Override
        public String toString() {
            return "{code: " + code + ", name: " + name + ", weightInKg: " + weightInKg + ", priceInBgn: " + priceInBgn + "}";
        }
    }
}
