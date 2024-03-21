package in.satya.Service;

import java.util.List;
import java.util.Optional;

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

	public boolean delete(Integer pId) {
		boolean flag = false;
		try {
			Repo.deleteById(pId);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public Product update(Integer pId) {
		Optional<Product> id = Repo.findById(pId);
		if(id.isPresent()) {
			return id.get();
		}
		else {
			return null;
		}
	}

}
