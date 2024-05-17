package com.example.newone.services;

import com.example.newone.Dtos.productDto;
import com.example.newone.Models.productModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Stream;

public interface productService {

    public List<productModel> singleproduct();


}
