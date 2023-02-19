package com.application.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Config.JwtTokenValidatorFilter;
import com.application.DTO.OrderInputDto;
import com.application.DTO.OrderProductQuantity;
import com.application.Entities.Customer;
import com.application.Entities.OrderDetail;
import com.application.Entities.Product;
import com.application.Exception.OrderException;
import com.application.Exception.ProductException;
import com.application.Repository.CustomerRepository;
import com.application.Repository.OrderRepository;
import com.application.Repository.ProductRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	private static final  String orderPlaced="Placed";
	

	
	@Autowired
	private ProductRepository  productRepository;
      
	@Autowired
	private OrderRepository  orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public void placeOrder(OrderInputDto orderInputDto) throws OrderException,ProductException {
		System.out.println(orderInputDto);
		List<OrderProductQuantity> orderProductQuantities = orderInputDto.getOrderProductQuantities();
		
		for(OrderProductQuantity o:orderProductQuantities) {
			
			  String username = JwtTokenValidatorFilter.currentUser;
			  
			Product product = productRepository.findById(o.getProductId()).orElseThrow(() -> new ProductException("Product doesn't exist"));
			Customer customer = customerRepository.findByEmail(username).get();
			
			
			OrderDetail  orderDetail = new OrderDetail();
			orderDetail.setUserFullName(orderInputDto.getFullName());
			orderDetail.setCreatedDate(new Date());
			orderDetail.setAddress(orderInputDto.getFullAddress());
			orderDetail.setContactNumber(orderInputDto.getContactNumber());
			orderDetail.setAlternateContactNumber(orderInputDto.getAlternateContactNumber());
			orderDetail.setOrderStatus(orderPlaced);
			orderDetail.setOrderAmount(product.getProductPrice()*o.getProductQuantity());
			orderDetail.setProduct(product);
			orderDetail.setCustomer(customer);
			
			orderRepository.save(orderDetail);
		 	
		}
		
	}

}
