package hr.fer.zemris.java.tecaj.hw1;

class ProgramStabla {
	static class CvorStabla {
		CvorStabla lijevi;
		CvorStabla desni;
		String podatak;
	}

	public static void main(String[] args) {
		CvorStabla cvor = null;
		cvor = ubaci(cvor, "Jasna");
		cvor = ubaci(cvor, "Ana");
		cvor = ubaci(cvor, "Ivana");
		cvor = ubaci(cvor, "Anamarija");
		cvor = ubaci(cvor, "Vesna");
		cvor = ubaci(cvor, "Kristina");
		System.out.println("Ispisujem stablo inorder:");
		ispisiStablo(cvor);
		cvor = okreniPoredakStabla(cvor);
		System.out.println("Ispisujem okrenuto stablo inorder:");
		ispisiStablo(cvor);
		int vel = velicinaStabla(cvor);
		System.out.println("Stablo sadrzi elemenata: " + vel);
		boolean pronaden = sadrziPodatak(cvor, "Ivana");
		System.out.println("Trazeni podatak je pronaden: " + pronaden);
	}

	/**
	 * Method searches the tree for the argument podatak.
	 * @param korijen Root node of the tree.
	 * @param podatak Wanted node.
	 * @return Return true if node is found, and false otherwise.
	 */
	static boolean sadrziPodatak(CvorStabla korijen, String podatak) {
		if (korijen == null)
			return false;
		else if (korijen.podatak.equals(podatak)) {
			return true;
		}
		else if (korijen.podatak.compareTo(podatak) >  0)
			return sadrziPodatak(korijen.desni, podatak);
		else
			return sadrziPodatak(korijen.lijevi, podatak);
	}
	
	/**
	 * Method returns tree size. 
	 * @param cvor Root node of the tree.
	 * @return Number of nodes in the tree.
	 */
	static int velicinaStabla(CvorStabla cvor) {
		if (cvor == null)
			return 0;
		else {
			return 1 + velicinaStabla(cvor.lijevi) + velicinaStabla(cvor.desni);
		}
	}

	/**
	 * This method adds new node to binary tree.
	 * @param korijen Root node of the tree.
	 * @param podatak New value to add to the tree.
	 * @return Root node of the tree.
	 */
	static CvorStabla ubaci(CvorStabla korijen, String podatak) {
		// Create new node and initialize it
		CvorStabla noviCvor = new CvorStabla();
		noviCvor.podatak = podatak;
		// Insert new node into existing tree
		if(korijen == null)
			korijen = noviCvor;
		else {
			if(korijen.podatak.compareTo(podatak) > 0) {
				if (korijen.lijevi != null)
					ubaci(korijen.lijevi, podatak);
				else
					korijen.lijevi = noviCvor;
			}
			else {
				if (korijen.desni != null)
					ubaci(korijen.desni, podatak);
				else
					korijen.desni = noviCvor;
			}
		}
		return korijen;
	}

	/**
	 * This method outputs all tree nodes inorder to system output.
	 * @param cvor
	 */
	static void ispisiStablo(CvorStabla cvor) {
		if (cvor != null) {
			ispisiStablo(cvor.lijevi);
			System.out.println(cvor.podatak);
			ispisiStablo(cvor.desni);
		}
	}
	
	/**
	 * This method reverser the order of the binary tree.
	 * @param korijen Root node of the tree.
	 * @return Root node node of the tree.
	 */
	static CvorStabla okreniPoredakStabla(CvorStabla korijen) {
		CvorStabla tmp = new CvorStabla();
		if(korijen == null)
			return korijen;
		tmp = korijen.lijevi;
		korijen.lijevi = korijen.desni;
		korijen.desni = tmp;
		okreniPoredakStabla(korijen.lijevi);
		okreniPoredakStabla(korijen.desni);
		return korijen;
	}
	
}