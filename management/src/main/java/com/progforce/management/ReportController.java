package com.progforce.management;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.progforce.service.CategoryService;
import com.progforce.service.ProductService;
import com.progforce.service.StoreService;



@Controller
@RequestMapping("/reports")
public class ReportController {
	
	
	@Autowired
	StoreService reportService;
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	
	@RequestMapping(params = "upload")
	public String stores( Model model) {
		reportService.upload();
		model.addAttribute("products", productService.findAllProducts());
	    return "report/upload";
	}
	
	@RequestMapping(params = "multi")
	public String multiThread( Model model) {
		reportService.upload();
		model.addAttribute("products", productService.findAllProducts());
	    return "report/upload";
	}
	
	
	@RequestMapping(params = "view")
	public String manageUsers(Model model) {
		reportService.change();
		model.addAttribute("products", productService.findAllProducts());
		return "report/view";
	}
	
	
}
