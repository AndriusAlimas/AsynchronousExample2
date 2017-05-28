package com.andrius.project.AsynchronousExample2;

import java.util.Hashtable;

public class AuctionSystem {
	// this is key-value pair collection of items:
	private Hashtable<String,AuctionItem> items;
	
	// default constructor:
	public AuctionSystem(){
		// this will be initialised when context Initialised:
		items = new Hashtable<String,AuctionItem>();
		// Initialise the list of items here - here's two examples :
		String[] itemCodes = {"ABC001", "XYZ987"};
		for(String c : itemCodes){
			// create an auction item using item code constructor in the parameter:
			AuctionItem item = new AuctionItem(c);
			items.put("ABC001", item); // we put that item in collection
			new Thread(item).start(); // start new Thread job AuctionItem run() method
		}
	}
	
	public AuctionItem findItem(String ref){
		return items.get(ref);
	}
	
}
