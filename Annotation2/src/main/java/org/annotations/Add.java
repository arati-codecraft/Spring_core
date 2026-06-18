package org.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("add")
public class Add implements SetVal{
    @Value("100")
	private int a;
    @Value("200")
    private int b;
	public int getResult() {
		// TODO Auto-generated method stub
		return a+b;
	}

	public void setA(int a) {
		// TODO Auto-generated method stub
		this.a=a;
	}

	public void setB(int b) {
		// TODO Auto-generated method stub
		this.b=b;
	}

}

