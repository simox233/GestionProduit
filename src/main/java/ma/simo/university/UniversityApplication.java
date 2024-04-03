package ma.simo.university;

import ma.simo.university.entities.Product;
import ma.simo.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Ordinateur", 4222, 4));
        productRepository.save(new Product(null, "Imprimante", 2000, 3));
        productRepository.save(new Product(null, "Printer", 1500, 1));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());

        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("************");


    }
}
