
 package com.market.controller;
  
 import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.RestController;
  
  import com.market.entity.Product; import
  com.market.service.ProductServiceDao;
  
  @CrossOrigin(origins = "http://localhost:3000")
  @RestController 
  public class apiController {
 
  @Autowired 
  ProductServiceDao productdao;
  
 
  @GetMapping("/gp") 
   public List<Product> getallp(){
  
  return this.productdao.getAllProduct(); }
  
  }
  
  
 