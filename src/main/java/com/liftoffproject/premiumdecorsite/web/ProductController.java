package com.liftoffproject.premiumdecorsite.web;

import com.liftoffproject.premiumdecorsite.model.Product;
import com.liftoffproject.premiumdecorsite.service.ProductService;
import com.liftoffproject.premiumdecorsite.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize("hasRole('Admin')")
@PreAuthorize("isAuthenticated()")
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    // display list of products
    @RequestMapping("/viewProducts")
    public String viewHomePage(Model model) {
        return findPaginated(1, "productName", "asc", model);
    }

    @RequestMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveEmployee(@ModelAttribute("product") Product product) {
        // save product to database
        productService.saveProduct(product);
        return "redirect:/product/viewProducts";
    }

    @RequestMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") long id) {
        // call delete product method
        productService.deleteProductById(id);
        return "redirect:/product/viewProducts";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Product> listProducts = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listProducts", listProducts);
        return "products";
    }

}
