package gr.kariera.mindthecode.FinalProject.FinalProjectApplication;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.User;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.enums.ProductCategory;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.enums.UserRole;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.ProductRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.security.SecureRandom;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

	private static final String[] NAMES = {"Nick Body", "Amelia Smith", "Paul Strickland", "Thomas Mann", "Tracy Hull"};

	private static final String[] PRODUCT_NAMES = {"orange", "apple", "lemon", "cookies", "milk"};

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		for (String fullName : NAMES) {
			final String[] name = fullName.split(" ");
			var firstName = name[0];
			var lastName = name[1];

			User user = new User();
			user.setEmail(firstName.toLowerCase() + lastName.toLowerCase() + "@email.com");
			user.setUserRole(UserRole.CUSTOMER);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword("pass");

			userRepository.save(user);
		}

		for (String productName : PRODUCT_NAMES) {
			SecureRandom random = new SecureRandom();
			random.nextInt(101);
			Product product = new Product();
			product.setName(productName);
			product.setProductCategory(ProductCategory.FOOD);
			product.setPhoto("/food/" + productName + ".jpeg");
			product.setPrice(BigDecimal.valueOf(random.nextDouble(100.0)));
			product.setStock(BigDecimal.valueOf(random.nextInt(101)));

			productRepository.save(product);
		}
	}
}