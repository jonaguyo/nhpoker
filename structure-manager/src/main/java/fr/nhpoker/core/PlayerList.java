package fr.nhpoker.core;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class PlayerList
{
	@XStreamOmitField
	public static final Callback<Player, Observable[]> extractor = p -> new Observable[] { p.stackProperty() };
	
	@XStreamOmitField
	private ObservableList<Player> playerList = null;
	
	private List<Player> players = new ArrayList<>();
	
	public PlayerList()
	{
		
	}

	public ObservableList<Player> getPlayers()
	{
		if(playerList == null)
		{
			playerList = FXCollections.observableList(players, extractor);
		}
		
		return playerList;
	}
}
