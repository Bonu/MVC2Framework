package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Product;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.ResourceMapping;
import mum.edu.framework.controller.Controller;
import mum.edu.framework.validator.Validator;

public class ProductController implements Controller {

@AutoWired	
 Validator productValidator;
	@ResourceMapping(value={"/","/product_input"})
 	public String inputProduct(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

 	@ResourceMapping(value={"/save","/product_save"})
	public String saveProduct(Product product, HttpServletRequest request, 
			HttpServletResponse response) {
 //        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(product);
        if (errors.isEmpty()) {
             // no validation error, execute action method
            // insert code to save product to the database

            // store product in a scope variable for the view
            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
  
            // store errors and product in a scope variable for the view
            request.setAttribute("errors", errors);
            request.setAttribute("form", product);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
 	}
}
