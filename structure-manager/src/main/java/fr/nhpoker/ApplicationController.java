package fr.nhpoker;

import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

import fr.nhpoker.core.Player;
import fr.nhpoker.core.PlayerList;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class ApplicationController
{
	public static final ListChangeListener<Player> listener = new ListChangeListener<Player>()
	{
		@Override
		public void onChanged(Change<? extends Player> c)
		{
			System.out.println(c);
		}
	};
	
	public static final Callback<Player, Observable[]> callback = p -> new Observable[] { p.stackProperty() };
	LinkedList<Player> test;
	ObservableList<Player> testobs;
	PlayerList players;
	Player p = new Player(0, "pp", "PP");
	
	public ApplicationController()
	{
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		xstream.alias("player", Player.class);
		xstream.alias("players", PlayerList.class);
		xstream.addImplicitCollection(PlayerList.class, "players");
		
		players = new PlayerList();
		test = new LinkedList<>();
		testobs = FXCollections.observableList(test, callback);
		testobs.addListener(listener);
		testobs.add(p);
		p.stackProperty().set(1000);
	}
}
