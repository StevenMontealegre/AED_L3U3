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

	/**
	 * Method that create a basket ball player
	 * 
	 * @param name             - player's name
	 * @param team             - player's team
	 * @param age              - player's age
	 * @param pointsPerMatch   - player's points per match
	 * @param reboundsPerMatch - player's rebounds per match
	 * @param assistsPerMatch  player's assists per petch
	 * @param stealingPerMatch - player's stealing per match
	 * @param blocksPerMatch   - player's block per match
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

	/**
	 * method that returns the player's name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * method that returns the player's team
	 * 
	 * @return team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * method that returns the player's age
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * method that returns the player's points per match
	 * 
	 * @return pointsPerMatch
	 */
	public double getPointsPerMatch() {
		return pointsPerMatch;
	}

	/**
	 * method that returns the player's rebounds per match
	 * 
	 * @return reboundsPerMatch
	 */
	public double getReboundsPerMatch() {
		return reboundsPerMatch;
	}

	/**
	 * method that returns the player's assists per match
	 * @return assistsPerMatch
	 */
	public double getAssistsPerMatch() {
		return assistsPerMatch;
	}

	/**
	 * method that returns the player's stealing per match
	 * @return stealingPerMatch
	 */
	public double getStealingPerMatch() {
		return stealingPerMatch;
	}

	/**
	 * method that returns the player's block per match
	 * @return blocksPerMatch
	 */
	public double getBlocksPerMatch() {
		return blocksPerMatch;
	}

	/**
	 * Method that returns the atributte name of the object player
	 */
	public String toString() {
		return name;
	}

}
