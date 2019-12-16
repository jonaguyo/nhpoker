package fr.nhpoker;

import com.thoughtworks.xstream.XStream;

import fr.nhpoker.core.Player;
import fr.nhpoker.core.PlayerList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ApplicationController
{
	public ApplicationController()
	{
		XStream xstream = new XStream();
		xstream.alias("player", Player.class);
		xstream.alias("players", PlayerList.class);
		xstream.addImplicitCollection(PlayerList.class, "players");
		
		PlayerList players = new PlayerList();
		Player p1 = new Player(0, "P1", "P11");
		Player p2 = new Player(1, "P2", "P22");
		Player p3 = new Player(1, "P3", "P33");
		players.addPlayer(p1);
		players.addPlayer(p2);
		
		System.out.println(xstream.toXML(players));
		
		ObservableList<Player> obsPlayers = players.getPlayers();
		obsPlayers.addListener(new ListChangeListener<Player>() 
						{
							@Override
							public void onChanged(Change<? extends Player> c)
							{
								System.out.println(c);
							}
						});
		obsPlayers.add(p3);
		
		p3.stackProperty().set(1000);
//		players.addPlayer(new Player(1, "P3", "P33"));
	}
}
