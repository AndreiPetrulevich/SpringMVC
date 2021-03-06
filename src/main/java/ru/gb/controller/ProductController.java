package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.model.Product;
import ru.gb.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String processForm(Product product) {
        if (product.getId() == null) {
            productService.addProduct(product);
        } else {
            productService.editProduct(product);
        }
        return "redirect:/product/allProducts";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Integer id) {

        Product product = null;
        if (id > 0) {
            try {
                product = productService.getByID(id);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(path = "/allProducts", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        log.info("model info: {}", model.toString());
        return "product-list";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteByID(@RequestParam Integer id) {
        log.info("deleted: {}", id);
        try {
            productService.deleteById(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:/product/allProducts";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam Integer id) {
        try {
            model.addAttribute("product", productService.getByID(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "add-product";
    }
}
