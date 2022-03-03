package de.telekom.sea7;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import de.telekom.sea7.base.Zahlung;

@Component
public class MyBean implements ApplicationContextAware {
	
	@Autowired private Zahlung zahlung; // null
	
	private Zahlung zahlung2; // null

	private ApplicationContext applicationContext;
	
	public MyBean() {
		System.out.println(zahlung);
	}	

	@PostConstruct
	public void init() {
		System.out.println("******* Hello from MyBean");
		System.out.println(zahlung);
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("********** Goodbye from MyBean");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		zahlung2 = (Zahlung) applicationContext.getBean("zahlung");			
	}
	
	public void listBeans() {
		applicationContext.getBeanDefinitionCount();
		for(String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
			if(beanName!="myBean") {
				var bean = applicationContext.getBean(beanName);
				System.out.println(bean.toString());
			}
		}		
	}
}