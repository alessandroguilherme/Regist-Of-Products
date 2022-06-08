package TypeOfProducts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import TypeOfProducts.Entities.ImportedProduct;
import TypeOfProducts.Entities.Product;
import TypeOfProducts.Entities.UsedProduct;

public class Principal {
    public static void main(String[] args) throws ParseException {
        Scanner imput = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> listOfProducts = new ArrayList<>();

        System.out.print("Enter the number of Products: ");
        int n = imput.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct #" + (i + 1) + " Data:");
            System.out.print("Common, Used or Imported (c/u/i)? ");
            char answer = imput.next().charAt(0);

            System.out.print("Name: ");
            imput.nextLine();
            String name = imput.nextLine();
            System.out.print("Price: ");
            double price = imput.nextDouble();

            if (answer == 'c') {
                listOfProducts.add(new Product(name, price));

            } else if (answer == 'u') {
                System.out.print("Manufacture Date (DD/MM/YYYY): ");
                Date manufaturedDate = sdf.parse(imput.next());
                listOfProducts.add(new UsedProduct(name, price, manufaturedDate));

            } else {
                System.out.print("Customs Fee: ");
                double customsFee = imput.nextDouble();
                listOfProducts.add(new ImportedProduct(name, price, customsFee));
            }
        }
        System.out.println();
        System.out.println("Price Tags:");
        for (Product product : listOfProducts) {
            System.out.println(product.priceTag());

        }

    }
}
