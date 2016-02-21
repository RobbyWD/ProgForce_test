package com.progforce.management;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.progforce.entity.domain.Category;
import com.progforce.service.CategoryService;


@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(params = "create")
	public String createForm(Model model) {
		model.addAttribute("category", new Category());
		return "category/create";
	}
	
	@RequestMapping(params = "manage")
	public String manageForm(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "category/manage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") @Valid Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "category/register";
		}
		if (category.getDescription().equals(null) || category.getName().equals(null)) return "redirect:/categories?manage";
		if (category.getDescription().equals("") || category.getName().equals("")) return "redirect:/categories?manage";
		categoryService.saveCategory(category);
		return "redirect:/categories/" + category.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") @Valid Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "category/register";
		}
		if (category.getDescription().equals(null) || category.getName().equals(null)) return "redirect:/categories?manage";
		if (category.getDescription().equals("") || category.getName().equals("")) return "redirect:/categories?manage";
		categoryService.saveCategory(category);
		return "redirect:/categories?manage";
	}
	@RequestMapping(value = "/{id}")
	public ModelAndView getCategory(@PathVariable("id") Long categoryId) {
		Category category = categoryService.findCategory(categoryId);
		return new ModelAndView("category/view", "category", category);
		
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editCategory(@PathVariable("id") Long categoryId,
			Map<String, Object> model) {
		Category category = categoryService.findCategory(categoryId);
		model.put("category", category);
		return "category/edit";
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId,
			Map<String, Object> model) {
		Category category = categoryService.findCategory(categoryId);
		model.remove("category", category);
		categoryService.deleteCategory(category);
		return "redirect:/categories?manage";
	}

}
