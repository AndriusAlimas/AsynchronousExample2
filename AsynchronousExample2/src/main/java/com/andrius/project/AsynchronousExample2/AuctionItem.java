package com.andrius.project.AsynchronousExample2;

public class AuctionItem implements Runnable {
	// private Fields:
	private String itemRef;
	
	// constructor using argument as reference of item:
	public AuctionItem(String ref){
		this.itemRef = ref;
	}

	@Override
	public void run() {
		
	}
}
