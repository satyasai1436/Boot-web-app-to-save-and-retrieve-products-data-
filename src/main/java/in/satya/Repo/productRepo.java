package in.satya.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satya.Entity.Product;

public interface productRepo extends JpaRepository<Product, Integer> {
	
	

}
