package fr.nhpoker.core;

import java.util.LinkedList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerList
{
	@XStreamOmitField
	private ObservableList<Player> playerList = null;
	
	private List<Player> players;
	
	public PlayerList()
	{
		this.players = new LinkedList<>();
	}

	public ObservableList<Player> getPlayers()
	{
		if(playerList == null)
		{
			playerList = FXCollections.observableList(players);
		}
		
		return playerList;
	}
}
