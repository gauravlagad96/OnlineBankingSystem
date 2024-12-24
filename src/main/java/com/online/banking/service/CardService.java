package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Card;

public interface CardService {
	
	boolean issueCard(Card card);

	List<Card> getCardsByUserId(int userId);

	boolean deleteCard(int cardId);
	
}