package fr.nhpoker.gui;

import javax.inject.Inject;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;

import fr.nhpoker.ApplicationController;
import fr.nhpoker.core.Player;
import javafx.fxml.FXML;

public class MainPresenter
{
	@Inject
	private ApplicationController controller;
	
	@FXML
	private JFXTreeTableView<Player> allPlayersList;
	@FXML
	private JFXTreeTableView<Player> sessionPlayersList;
	
	public void initialize()
	{
		System.out.println(controller);
		
		JFXTreeTableColumn<Player, String> idColum = new JFXTreeTableColumn<>("ID");
		
		allPlayersList.getColumns().addAll(idColum);
	}
}
