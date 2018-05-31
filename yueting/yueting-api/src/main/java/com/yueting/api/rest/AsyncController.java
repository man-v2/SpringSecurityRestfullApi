package com.yueting.api.rest;

import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.yueting.api.service.DeferredResultHolder;
import com.yueting.api.service.MockQueue;

//@RestController
public class AsyncController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MockQueue mockQueue;
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	@GetMapping("/order")
	public Callable<String> order() {
		logger.info("主线程开始.");
		
		DeferredResult a = new DeferredResult<>();
		
		Callable<String> result = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				logger.info("副线程开始.");
				Thread.sleep(1000);
				logger.info("副线程返回.");
				return "success";
			}
		};
		
		logger.info("主线程返回.");
		return result;
	}
	
	@GetMapping("/sync")
	public DeferredResult<String> orderSync() throws Exception {
		logger.info("主线程开始.");
		String orderNumber = RandomStringUtils.random(8);
		mockQueue.setPlaceOrder(orderNumber);
		
		DeferredResult<String> result = new DeferredResult<String>();
		deferredResultHolder.getMap().put(orderNumber, result);
		logger.info("主线程返回.");
		
		return result;
	}
}
