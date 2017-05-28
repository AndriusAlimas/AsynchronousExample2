package com.andrius.project.AsynchronousExample2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;

public class AuctionItem implements Runnable {
	// private Fields, other fields imitted;e.g. description, condition, delivery:
	private String itemRef;
	private int highestBid; // e.g. in cents
	private User bidder;
	private List<AsyncContext> pendingRequests;
	
	// constructor using argument as reference of item:
	public AuctionItem(String ref){
		this.itemRef = ref;
		this.pendingRequests = new ArrayList<AsyncContext>();
	}

	// GETTERS:
	public int getHighestBid(){
		return highestBid;
	}
	public User getHighestBidder(){
		return bidder;
	}
	
	public void addPendingRequest(AsyncContext ac){
		synchronized(pendingRequests){
			pendingRequests.add(ac);
		}
	}
	
	/**
	 *  Call this method with any new bid updates:
	 */
	
	public void updateBid(User bidder, int bid){
		if(bid>highestBid){
			synchronized (pendingRequests) {
			  this.highestBid = bid;
			  this.bidder = bidder;
			}
			pendingRequests.notify();
		}
	}
	@Override
	/**
	 * This method handles the background processing of bid updates for this item, sending
	 * each update to every pending request and completing them
	 */
	public void run() {
		
	}
}
