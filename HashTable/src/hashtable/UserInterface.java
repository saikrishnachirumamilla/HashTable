package hashtable;

public class UserInterface {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable(31);
		hashTable.insert("linked");
		hashTable.insert("tree");
		hashTable.insert("array");
		hashTable.insert("graph");
		hashTable.insert("hashset");
		hashTable.insert("double");
		hashTable.insert("bubble");
		hashTable.insert("merge");
		hashTable.insert("quick");
		hashTable.insert("insert");
		hashTable.insert("dijkstra");
		hashTable.insert("recurs");
		hashTable.insert("struct");
		hashTable.insert("node");
		hashTable.insert("head");
		hashTable.insert("tail");
		hashTable.insert("avl tree");
		hashTable.insert("MAC");
		hashTable.insert("WINDOW");
		hashTable.insert("LINUX");
		System.out.println("Number of Collisions: "+HashTable.collisionCounter);
		//System.out.println(hashTable.getTableSize());
//		for (int i = 0; i < hashTable.getTableSize(); i++) {
//			System.out.println(hashTable.getHashTable()[i]);
//		}
	}
}
