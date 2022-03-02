package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.Product;
import com.test.hplusapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "searchKey") String searchKeyword){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        List<Product> list = this.productRepository.productsByName(searchKeyword);
        mav.addObject("products",list);
        return mav;
    }

}
