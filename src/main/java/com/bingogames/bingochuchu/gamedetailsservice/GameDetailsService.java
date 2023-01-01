package com.bingogames.bingochuchu.gamedetailsservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingogames.bingochuchu.Utils.Utilities;
import com.bingogames.bingochuchu.gamedetailsRepository.GamedetailsRepository;
import com.bingogames.bingochuchu.gamedetailsmodel.Box;
import com.bingogames.bingochuchu.gamedetailsmodel.GameDetails;

@Service
public class GameDetailsService {
	
	@Autowired
	GamedetailsRepository gamedetailsRepository;
	
	@Autowired
	GameDetails gameDetails;
	
	@Autowired
	Box box;
	
	public GameDetails startNewGame(String PlayerId) {
		gameDetails.setSessionId(UUID.randomUUID().toString().replace("-", ""));
		gameDetails.setStatus("yet to Start");
		List<String> PlayerIds=new ArrayList<String>();
		PlayerIds.add(PlayerId);
		gameDetails.setPlayerIds(PlayerIds);
		int[] matrix= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		gameDetails.setInitialBox(matrix);
		box.setPlayerId(PlayerId);
		box.setBox(Utilities.getRandomBox());
		List<Box> boxes= new ArrayList<Box>();
		boxes.add(box);
		gameDetails.setBoxes(boxes);
		gameDetails.setTurn(0);
		gamedetailsRepository.save(gameDetails);
		return gameDetails;
		
	}
	
	public GameDetails joinGame(String SessionId, String PlayerId) {
		
		/*
		 * first we need to check if the session id exist or not,
		 * if it exist then get the game details. 
		 * From game Details check if the status is yet to start or not, 
		 * if the status is not yet to start, exception should be thrown.
		 * if it is yet to start,then join the game
		 * add the playerId in the list of the playerIds
		 * 
		 */
		gameDetails = gamedetailsRepository.findById(SessionId).orElseThrow(null);
		if (gameDetails.getStatus().equals("yet to Start")) {
			List<String> PlayerIds= gameDetails.getPlayerIds();
			PlayerIds.add(PlayerId);	
			box.setPlayerId(PlayerId);
			box.setBox(Utilities.getRandomBox());
			List<Box> boxes= gameDetails.getBoxes();
			boxes.add(box);
			gamedetailsRepository.save(gameDetails);
		}
		else {
			//to be done later
		}
		
		return gameDetails;
	}
	
	public void crossNumber(String SessionId, String PlayerId, int number) {
		gameDetails = gamedetailsRepository.findById(SessionId).orElseThrow(null);
		int turn= gameDetails.getTurn();
		List<String> PlayerIds=gameDetails.getPlayerIds();
		if(PlayerIds.get(turn).equals(PlayerId)) {
			if(turn < PlayerIds.size()) {
				gameDetails.setTurn(++turn);
			}
			else {
				gameDetails.setTurn(0);
			}
			int initialBox[]=gameDetails.getInitialBox();
			initialBox[number-1]=0;
			//strike check needs to be implemented
			gamedetailsRepository.save(gameDetails);
		}
		else {
			//throw an exception, its not ur turn
		}
	}
	

}
 