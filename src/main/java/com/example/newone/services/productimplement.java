package com.example.newone.services;

import com.example.newone.Dtos.productDto;
import com.example.newone.Models.productModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class productimplement implements productService{
    private RestTemplateBuilder restTemplateBuilder;

    public productimplement(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public  List<productModel>  singleproduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<productDto[]> product = restTemplate.getForEntity("https://api.sampleapis.com/beers/ale", productDto[].class);
       productDto[] productdto = product.getBody();
       List<productModel> allproducts = new ArrayList<>();
       List<productModel> filterproduct =new ArrayList<>();
       for(productDto product1 : productdto){
         productModel productmodel = new productModel();
         productmodel.setPrice(product1.getPrice());
         productmodel.setName(product1.getName());
         productmodel.setImage(product1.getImage());
         allproducts.add(productmodel);
       }

       for(productModel allitem: allproducts){
           String strprice =allitem.getPrice();
           String price = strprice.replace("$", "");
          Float actualprice =  Float.parseFloat(price);
           System.out.println("DEBUG");
          if(actualprice > 19){
              filterproduct.add(allitem);
          }
       }

        return filterproduct;
    }


}
