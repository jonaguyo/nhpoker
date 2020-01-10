package fr.nhpoker.core;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javafx.beans.property.SimpleIntegerProperty;

public class Player extends RecursiveTreeObject<Player>
{
	private int id;
	
	private String lastName;
	private String firstName;
	
	private int stack;

	@XStreamOmitField
	private SimpleIntegerProperty stackProperty;
	
	public Player(int id, String lastName, String firstName)
	{
		super();
		
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public int getId()
	{
		return id;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public SimpleIntegerProperty stackProperty()
	{
		if(stackProperty == null)
		{
			stackProperty = new SimpleIntegerProperty(stack);
		}
		
		return stackProperty;
	}

	@Override
	public String toString()
	{
		return "Player [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", stack=" + stack + "]";
	}
}
