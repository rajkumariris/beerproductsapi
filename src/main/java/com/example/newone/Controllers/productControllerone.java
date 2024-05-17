package com.example.newone.Controllers;

import com.example.newone.Dtos.productDto;
import com.example.newone.Models.productModel;
import com.example.newone.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class productControllerone {
        private productService productservice;
        @Autowired
        public productControllerone(productService productserv){
         this.productservice = productserv;
        }
    @GetMapping("/")
    public   List<productModel>   getbeer(){
        List<productModel> productdto =   productservice.singleproduct();
         return productdto;
    }
//    @GetMapping("/products")
//    public String getanotherbeer(){
//        ResponseEntity<productDto>  products=  productservice.singleproduct();
//        return "hello world";
//    }
}
