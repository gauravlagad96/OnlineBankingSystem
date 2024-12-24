package com.online.banking.entities;

public class Card {
	private int cardId;
	private int userId;
	private String cardNumber;
	private String cardType;
	private String expiryDate;
	private String createdAt;

	// Constructors
	public Card() {
	}

	public Card(int cardId, int userId, String cardNumber, String cardType, String expiryDate, String createdAt) {
		this.cardId = cardId;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expiryDate = expiryDate;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
