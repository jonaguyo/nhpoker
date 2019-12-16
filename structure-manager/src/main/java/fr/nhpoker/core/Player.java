package fr.nhpoker.core;

import javafx.beans.property.SimpleIntegerProperty;

public class Player
{
	private int id;
	
	private String lastName;
	private String firstName;
	
	private int stack;
	
	private SimpleIntegerProperty stackProperty;
	
	public Player(int id, String lastName, String firstName)
	{
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
}
