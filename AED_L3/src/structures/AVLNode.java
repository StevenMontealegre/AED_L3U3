package structures;

import java.io.Serializable;

public class AVLNode<K, V> extends BSTNode implements Serializable {

	/*
	 * Atributte that represent a nodo's balance factor
	 */
	private int balanceFactor;

	/**
	 * Method that create a AVL node with a Key and value
	 * 
	 * @param llave
	 * @param valor
	 */
	public AVLNode(K key, V value) {
		super((Comparable) key, value);
		balanceFactor = 0;
	}

	/**
	 * method that returns the balance factor of a node
	 * 
	 * @return balanceFactor
	 */
	public int balanceFactor() {
		if (right == null && Left == null) {

		}
		return balanceFactor;
	}

	public void setBalanceFactor(int t) {
		balanceFactor = t;
	}

	/**
	 * method that go throught subTree
	 * @param string - 
	 * @param nil - null
	 */
	public void goThroughSubTree(String string, AVLNode nil) {
		if (right != nil)
			((AVLNode) right).goThroughSubTree(string + "R", nil);
		if (Left != nil)
			((AVLNode) Left).goThroughSubTree(string + "L", nil);
		System.out.println("colocar nombre del metodo (goThrought) en la clase AVLnode");
	}

	/**
	 * method that updates the tree every time the roll factor is not adequate
	 */
	public void UpdateFactorBalance() {
		if (right == null && Left == null) {
			balanceFactor = 0;
		} else if (right == null) {
			balanceFactor = Left.hight;
		} else if (Left == null) {
			balanceFactor = -right.hight;
		} else {
			balanceFactor = Left.hight - right.hight;
		}
	}
}