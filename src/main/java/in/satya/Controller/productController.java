package in.satya.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.satya.Entity.Product;
import in.satya.Service.productService;

@Controller
public class productController {

	@Autowired
	private productService pService;

	@GetMapping("/")
	public ModelAndView loadForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("set", new Product());
		mav.setViewName("Set");
		return mav;
	}

	@PostMapping("/form")
	public ModelAndView setAll(Product p) {
		ModelAndView mav = new ModelAndView();
		pService.setData(p);
		mav.addObject("msg", "success");
		mav.setViewName("data1");
		return mav;
	}
	@GetMapping("/get1")
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView();
		List<Product> list = pService.getAll();
		mav.addObject("msg1",list );
		mav.setViewName("data");
		return mav;
	}

}
