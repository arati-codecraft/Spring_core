package org.annotations;
import org.annotations.config.ConfigApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class ClientApplication {
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext  context=new AnnotationConfigApplicationContext(ConfigApp.class);
		 Calculator calc=(Calculator)context.getBean("calc");
		 calc.show();
	}
}
