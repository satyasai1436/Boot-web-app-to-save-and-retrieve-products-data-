package in.satya.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.satya.Entity.Product;
import in.satya.Repo.productRepo;

@Service
public class productService {
	@Autowired
	private productRepo Repo;

	public Product setData(Product p) {
		
		return Repo.save(p);

	}

	public List<Product> getAll() {
		List<Product> list = Repo.findAll();
			
		return list;

	}

}
