package com.yueting.api.listener;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.yueting.api.service.DeferredResultHolder;
import com.yueting.api.service.MockQueue;

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DeferredResultHolder deferredResultHolder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		MockQueue mockQueue = new MockQueue();
		new Thread(() -> {
			while(true) {
				if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
					String orderNumber = mockQueue.getCompleteOrder();
					logger.info("返回订单处理结果："+orderNumber);
					deferredResultHolder.getMap().get(orderNumber).setResult("place order success.");
					mockQueue.setCompleteOrder(null);
				}else {
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	
}
