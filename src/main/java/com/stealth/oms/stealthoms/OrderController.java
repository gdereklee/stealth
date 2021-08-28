package com.stealth.oms.stealthoms;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stealth.oms.model.Order;

@RestController
public class OrderController {
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/Order")
	public Order GetOrder() {
		return new Order("test");
	}

	@GetMapping(path="/OrderDetails")
	public String GetOrderDetails(
			//@RequestHeader(name="Accept-Language", required=false) Locale locale
			) {		
		return messageSource.getMessage("good.morning.message", null, "Default message"
				, LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path="/Order/{id}")
	public Order GetOrder(@PathVariable String id) {
		return new Order(String.format("test %s",id));
	}	
}
