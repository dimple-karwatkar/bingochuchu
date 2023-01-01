package com.bingogames.bingochuchu.gamedetailsmodel;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("GameDetails")
public class GameDetails {
	
	@Id
	private String sessionId;
	
	private List<String> playerIds;
	private String status;
	private int initialBox[];
	private int turn;
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public List<Box> getBoxes() {
		return boxes;
	}
	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}
	private List<Box> boxes;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public List<String> getPlayerIds() {
		return playerIds;
	}
	public void setPlayerIds(List<String> playerIds) {
		this.playerIds = playerIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int[] getInitialBox() {
		return initialBox;
	}
	public void setInitialBox(int[] matrix) {
		this.initialBox = matrix;
	}
	
	
}
