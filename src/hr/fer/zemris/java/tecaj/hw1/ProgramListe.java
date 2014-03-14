package hr.fer.zemris.java.tecaj.hw1;

class ProgramListe {
	
	static class CvorListe {
		CvorListe sljedeci;
		String podatak;
	}
	
	/**
	 * This class implements basic functionalities for working with linked 
	 * lists.
	 * @param args 
	 */
	public static void main(String[] args) {
		CvorListe cvor = null;
		cvor = ubaci(cvor, "Jasna");
		cvor = ubaci(cvor, "Ana");
		cvor = ubaci(cvor, "Ivana");
		System.out.println("Ispisujem listu uz originalni poredak:");
		ispisiListu(cvor);
		cvor = sortirajListu(cvor);
		System.out.println("Ispisujem listu nakon sortiranja:");
		ispisiListu(cvor);
		int vel = velicinaListe(cvor);
		System.out.println("Lista sadrzi elemenata: " + vel);
	}

	/**
	 * Method returns the number of elements in a given list.
	 * @param cvor First element of a given list.
	 * @return Number of elements in list.
	 */
	static int velicinaListe(CvorListe cvor) {
		int i=0;
		if (cvor == null)
			return i;
		else {
			do {
				i++;
				cvor = cvor.sljedeci;
			} while (cvor != null);
		}
		return i;
	}

	/**
	 * This method adds a new element with value podatak to list.
	 * @param prvi First element of linked list.
	 * @param podatak Value to add to the list.
	 * @return First element of the list.
	 */
	static CvorListe ubaci(CvorListe prvi, String podatak) {
		// Create a new node and initialize it.
		CvorListe novi = new CvorListe();
		novi.podatak = podatak;
		novi.sljedeci = null;
		
		// Add item to list if the list is empty
		if (prvi == null)
			prvi = novi;
		else {
			// Find the last node
			CvorListe iterator = prvi;
			while (iterator.sljedeci != null)
				iterator = iterator.sljedeci;
			// Add new element to list end
			iterator.sljedeci = novi;
		}
		return prvi;		
	}

	/**
	 * Writes list elements to standard system output.
	 * @param cvor First element of linked list.
	 */
	static void ispisiListu(CvorListe cvor) {
		if (cvor == null)
			System.out.println("List is empty!");
		else {
			do {
				System.out.println(cvor.podatak);
				cvor = cvor.sljedeci;
			} while (cvor != null);
		}
	}

	/**
	 * This method sorts elements of linked list.
	 * @param cvor First node of linked list.
	 * @return First node of sorted list.
	 */
	static CvorListe sortirajListu(CvorListe cvor) {
		// Exit if list is empty, or has 1 node
		if( cvor == null || cvor.sljedeci == null )
			return cvor;
		
		CvorListe iterator1 = cvor;
		CvorListe iterator2 = null;
		String tmp = "";
				
		while (iterator1 != null) {
			iterator2 = iterator1.sljedeci;
			while (iterator2 != null) {
				if (iterator1.podatak.compareTo(iterator2.podatak) > 0) {
					tmp = iterator2.podatak;
					iterator2.podatak = iterator1.podatak;
					iterator1.podatak = tmp;
				}
				iterator2 = iterator2.sljedeci;
			}
			iterator1 = iterator1.sljedeci;
		}
		return cvor;
	}
}