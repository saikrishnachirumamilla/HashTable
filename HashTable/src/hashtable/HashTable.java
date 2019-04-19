package hashtable;

public class HashTable {
	
	private String[] hashTable;
	private int tableSize;
	private int insertCount;
	static int collisionCounter;
	
	public HashTable(int tableSize) {
		this.tableSize = tableSize;
		hashTable = new String[this.tableSize];
	}

	public String[] getHashTable() {
		return hashTable;
	}

	public void setHashTable(String[] hashTable) {
		this.hashTable = hashTable;
	}

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}
	
	public int getInsertCount() {
		return insertCount;
	}

	public void setInsertCount(int insertCount) {
		this.insertCount = insertCount;
	}

	public static int getCollisionCounter() {
		return collisionCounter;
	}

	public static void setCollisionCounter(int collisionCounter) {
		HashTable.collisionCounter = collisionCounter;
	}

	private int getIndex(String key) {
		return (key.hashCode( ) & 0x7fffffff)%this.tableSize;
	}
	
	public void insert(String value) {
		
		int index = getIndex(value);
		
		if(this.hashTable[index] == null) {
			this.hashTable[index] = value;
			this.insertCount++;
		}else {
			collisionCounter++;
			int newIndex = quadraticProbing(index);
			if(newIndex != -1) {
				this.hashTable[newIndex] = value;
				this.insertCount++;
			}
		}
		double loadFactor = (1.0*insertCount)/this.tableSize;
		if(loadFactor > 0.5) {
			//System.out.println("Collisions"+collisionCounter);
			rehash();
		}
		
	}
	
	private void rehash() {
		String [] oldHashTable = this.hashTable;
		int updatedTableSize = getNextPrime(2*this.tableSize);
		this.hashTable = new String[updatedTableSize];
		this.insertCount = 0;
		this.tableSize = updatedTableSize;
		for (int i = 0; i < oldHashTable.length; i++) {
			if(oldHashTable[i] != null) {
				insert(oldHashTable[i]);
			}
		}
	}
	
	private int quadraticProbing(int oldIndex) {
		int i = 1;
		int newIndex = -1;
		while (true) {
			newIndex = (oldIndex+(int)Math.pow(i, 2))%this.tableSize;
			if(this.hashTable[newIndex] == null) {
				break;
			}else {
				i++;
			}
		}
		return newIndex;
	}
	
	private int getNextPrime(int tableSize){
		int flag;
		tableSize++;
		while (true) {
			flag = 0;
			for (int i = 2; i <= Math.sqrt(tableSize); i++) {
				if(tableSize%i == 0) {
					flag++;
				}
			}
			if(flag == 0) {
				return tableSize;
			}else {
				tableSize++;
				continue;
			}
		}
	}
}
