package com.ing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.domain.ReviewHistory;
import com.ing.domain.Stock;
import com.ing.service.StockService;
import com.ing.service.TransactionService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@RestController
@EnableSwagger2
@RequestMapping("api/v1/")
public class StockController {
	
	@Autowired
	StockService stockService;
	

	@GetMapping("/stock")
	public List<Stock> getStockDetails() {
		List<Stock> stocklist  = stockService.getStockDetails();
		return stocklist;
	}
	
	@GetMapping("/hourlyCount")
	public Integer getHourlyCount() {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date1 = null,d1,d2;
		long diff,diffHours = 0;
		Calendar calobj = Calendar.getInstance();
		
		String sDate1="2019/04/07 13:48:17";  //this string will come from db
		
	    try {
			date1 = format.parse(sDate1);
			d1 = format.parse(df.format(date1));
			d2 = format.parse(df.format(calobj.getTime()));
			diff = d2.getTime() - d1.getTime();
			diffHours = diff / (60 * 60 * 1000) % 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	   
		System.out.println("Date from DB  "+df.format(date1));
		
	    System.out.println("Current Date Time : "+df.format(calobj.getTime()));
	    
	    System.out.println("Diff----------->>>> "+diffHours);
		return 0;
	}
}
