package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.market.entity.Cart;
import com.market.entity.Product;
import com.market.entity.Userdata;
import com.market.service.CartServiceDao;
import com.market.service.ProductServiceDao;
import com.market.service.UserServiceDao;
import com.market.service.UserServiceDaoImpl;

@Controller
public class MainController {
	
	@Autowired
	CartServiceDao	cartdao;
	@Autowired
	ProductServiceDao productdao;
	
	@Autowired
	UserServiceDao userdao;
	
	@GetMapping("/")
	public String mainpage(Model model)
	{
		
		
		return "home";
	}
	@GetMapping("/homepage")
	public String ShowHomePage(Model model)
	{
		model.addAttribute("productList", productdao.getAllProduct());
		
		return "producthome";
	}
	
/* int cartId;
		String productName;
		float price;
		int Quantity;
		float totalprice;*/
	@GetMapping("/addController/{prodId}")
	public String AddToCart(@PathVariable(value="prodId") String prodId, Model model)
	{
		
		System.out.println(prodId);
		Product product = this.productdao.getOneProduct(prodId);
		String name =product.getProductName();
		float prc = product.getPrice();
		
		Cart cart = new Cart();
		
		cart.setPrice(prc);
		cart.setProductName(name);
		int i =1;
		cart.setQuantity(i);
		cart.setTotalprice(prc*i);
		List<Cart> listc= this.cartdao.getAllCartItems();
		
		
		ListIterator<Cart> itr =  listc.listIterator(); 
		boolean flag = false;
		int existedquantity =0;
		int id= 0;
		while(itr.hasNext())
		{
			Cart cartitr = (Cart)itr.next();
			String productname = cartitr.getProductName();
			if(name.equals(productname))
			{
				existedquantity = cartitr.getQuantity();
				id = cartitr.getCartId();
				flag = true;
			}
		}
		
		if(flag)
		{
			int total = existedquantity +1;
			cart.setQuantity(total);
			cart.setCartId(id);
			cart.setTotalprice(prc*total);
			this.cartdao.addCart(cart);
		}
		
		else {
			this.cartdao.addCart(cart);
		}
		
		
		
		
		return "redirect:/homepage";
	}
	
	
	
	
	
	@GetMapping("/deletecart/{cartId}")
	public String deleteFromcart(@PathVariable(value="cartId") int cartId, Model model)
	{
		this.cartdao.deleteCart(cartId);
		return "redirect:/showCart";
	
	}
	@GetMapping("/showCart")
	public String showCart(Model model)
	{
		model.addAttribute("carLlist", this.cartdao.getAllCartItems());
		
		return "cartpage";
		
	}
	
	
	
	@GetMapping("/updatecart/{cartId}")
	public String showupdate(@PathVariable(value="cartId") int cartId, Model model)
	{
		Cart cart = this.cartdao.getOneCartItem(cartId);
		
		model.addAttribute("cart",cart);
		return "update";
	}
	
	
	@PostMapping("/update")
	public String updateform(@ModelAttribute Cart cart, Model model)
	{
		int qty = cart.getQuantity();
		float total = cart.getPrice();
		
		cart.setTotalprice(qty*total);
		this.cartdao.addCart(cart);
		
		return "redirect:/showCart";
	}
	
	
	@GetMapping("/checkout")
	public String checkout(Model model)
	{
		List<Cart> cartlist = this.cartdao.getAllCartItems();
		ListIterator<Cart> pointer = cartlist.listIterator();
		int cartPrice = 0;
		
		while(pointer.hasNext())
		{
			Cart cart1 = pointer.next();
			cartPrice+= cart1.getTotalprice();
			
		}
		
		Map<String, Object> map = new HashMap();
		map.put("list",cartlist);
		map.put("TotalAmount", cartPrice);
		
		model.addAllAttributes(map);
		this.cartdao.delete();
		
		return "checkoutpage";
	}
	
	@GetMapping("/register")
	public String register(Model model)
	{
		Userdata user = new Userdata();
		model.addAttribute("user",user);
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute Userdata user, Model model)
	{
		this.userdao.addUser(user);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/login")
	public String login(Model model) 
	{
		Userdata user = new Userdata();
		model.addAttribute("user",user);
		return "login";
	}
	
	
	@PostMapping("/validate")
	public String validate(@ModelAttribute Userdata user, Model model)
	{
		String emailcheck = user.getEmail();
		String passwordcheck = user.getPassword();
		
		List<Userdata> userlist = this.userdao.getAllUser();
		
		ListIterator<Userdata> itr = userlist.listIterator(); 
		boolean flag = false;
		while(itr.hasNext())
		{
			Userdata user1 = itr.next();
			
			String email = user1.getEmail();
			String password = user1.getPassword();
		
			if((email.equals(emailcheck)) && (password.equals(passwordcheck)))
			{
				flag = true;
			}
			
			
		}
		
		
		if(flag)
		{
			return "redirect:/homepage";
		}
		
		else 
		{
			return "redirect:/";
		}
		
	}
	

	
	@GetMapping("/logout")
	public String logout(Model model) 
	{
		return "redirect:/";
	}

}
