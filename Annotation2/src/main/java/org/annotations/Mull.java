package org.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("mul")
public class Mull implements SetVal{
	@Value("10")
	private int a;
	@Value("20")
	private int b;
	public void setA(int a) {
	     this.a=a;
	}

	public void setB(int b) {
		this.b=b;
	}

	public int getResult() {
		// TODO Auto-generated method stub
		return a*b;
	}

}

