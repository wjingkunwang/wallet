package com.bjsxt.proxy;

import java.util.Random;


public class Tank implements Moveable {

	public void move() {
		
		System.out.println("Tank Moving...");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
