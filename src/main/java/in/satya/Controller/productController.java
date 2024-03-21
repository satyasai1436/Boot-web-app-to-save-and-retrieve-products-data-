package in.satya.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.satya.Entity.Product;
import in.satya.Service.productService;

@Controller
public class productController {

	@Autowired
	private productService pService;

	// to load the page and showing the empty form page and we need to set data

	@GetMapping("/")
	public ModelAndView loadForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("set", new Product());
		mav.setViewName("Set");
		return mav;
	}

	// after setting the data we need to do some action

	@PostMapping("/form")
	public String setAll(@ModelAttribute("set") Product p, Model m) {
		Product Data = pService.setData(p);
		System.out.println("Inside Save" + Data);
		if (Data.getpId() != null)
			m.addAttribute("msg", "Success");
		else
			m.addAttribute("msg", "Failed");

		return "Set";
	}

	// to retrieving the data

	@GetMapping("/get1")
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView();
		List<Product> list = pService.getAll();
		mav.addObject("msg1", list);
		mav.setViewName("data");
		return mav;
	}

	// to deleting the data using pId
	@GetMapping("/get2")
	public ModelAndView delete(@RequestParam("pId") Integer pId) {
		ModelAndView mav = new ModelAndView();
		boolean status = pService.delete(pId);
		if (status) {
			mav.addObject("del", "Success");
		} else {
			mav.addObject("del", "Failed");
		}
		mav.setViewName("data");
		return mav;
	}

	@GetMapping("/edit")
	public String showUpadateForm(Model model, Integer pId) {
		Product updatedObj = pService.update(pId);

		//System.out.println("Inside edit" + updatedObj);
		model.addAttribute("set", updatedObj);
		pService.delete(pId);
		return "Set";
	}

}
