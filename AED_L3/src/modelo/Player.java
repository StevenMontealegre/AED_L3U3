package modelo;

import java.io.Serializable;

/**
 * Class that represent a basket ball player
 * 
 * @author Julian
 *
 */
public class Player implements Serializable {

	/*
	 * Atribute that represent a player's name
	 */
	private String name;
	/*
	 * Atribute that represent a player's team
	 */
	private String team;
	/*
	 * Atribute that represent player's age
	 */
	private int age;
	/*
	 * Atribute that represent player's pointsPerMatch
	 */
	private double pointsPerMatch;
	/*
	 * Atribute that represent player's reboundsPerMatch
	 */
	private double reboundsPerMatch;
	/*
	 * Atribute that represent player's assistsPerMatch
	 */
	private double assistsPerMatch;
	/*
	 * Atribute that represent player's stealingPerMatch
	 */
	private double stealingPerMatch;
	/*
	 * Atribute that represent player's blocksPerMatch
	 */
	private double blocksPerMatch;

	/*
	 * Method that create a basket ball player
	 */
	public Player(String name, String team, int age, double pointsPerMatch, double reboundsPerMatch,
			double assistsPerMatch, double stealingPerMatch, double blocksPerMatch) {
		this.name = name;
		this.team = team;
		this.age = age;
		this.pointsPerMatch = pointsPerMatch;
		this.reboundsPerMatch = reboundsPerMatch;
		this.assistsPerMatch = assistsPerMatch;
		this.stealingPerMatch = stealingPerMatch;
		this.blocksPerMatch = blocksPerMatch;
	}

	/*
	 * method that returns the player's name
	 */
	public String getName() {
		return name;
	}

	/*
	 * method that returns the player's team
	 */
	public String getTeam() {
		return team;
	}

	/*
	 * method that returns the player's age
	 */
	public int getAge() {
		return age;
	}

	/*
	 * method that returns the player's points per match
	 */
	public double getPointsPerMatch() {
		return pointsPerMatch;
	}

	/*
	 * method that returns the player's rebounds per match
	 */
	public double getReboundsPerMatch() {
		return reboundsPerMatch;
	}

	/*
	 * method that returns the player's assists per match
	 */
	public double getAssistsPerMatch() {
		return assistsPerMatch;
	}

	/*
	 * method that returns the player's stealing per match
	 */
	public double getStealingPerMatch() {
		return stealingPerMatch;
	}

	/*
	 * method that returns the player's block per match
	 */
	public double getBlocksPerMatch() {
		return blocksPerMatch;
	}

	public String toString() {
		return name;
	}

}
