package fr.nhpoker;

import java.io.File;

import com.airhacks.afterburner.injection.Injector;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import fr.nhpoker.core.Player;
import fr.nhpoker.core.PlayerList;

public class ApplicationController
{
	private PlayerList players;
	
	public ApplicationController()
	{
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("player", Player.class);
		xstream.alias("players", PlayerList.class);
		xstream.addImplicitCollection(PlayerList.class, "players");
		
		File playersFile = new File("rsrcs/data/players.xml");
		players = (PlayerList) xstream.fromXML(playersFile);
		System.out.println(players.getPlayers());
		
		System.out.println(xstream.toXML(players));
	}
}
