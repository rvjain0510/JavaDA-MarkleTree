# JavaDA-MarkleTree

# Introduction
Merkle tree is a tree data structure with leaf nodes and non leaf nodes. It also known as Hash tree. The reason behind it is it only stores the hashes in its nodes instead of data. In its leaf nodes, it will store the hash of the data. Non leaf nodes contain the hash of its children. 

![image](https://user-images.githubusercontent.com/55658051/165554233-72a64835-8928-4c7f-a479-9590c87d816b.png)

## Hash Functions

 A hash or hash-value or a message digest is an array of fixed size random characters  generated when a message  or data is passed through an a  Mathematical algorithm. 

These mathematical algorithms are one way functions meaning, we can generate the output from input but not vice-versa. It has to be deterministic, meaning the input should always maps to same output regardless of the number of times it passed through it.  

Y(I) = O, where
Y  = Our hash function
I    = Input 
O  =  Output. 
Even a small change in the input produces produces completely output. This property is also known as avalanche effect.
Y(I') = O' 
These mathematical algorithms with the above properties are also known as Hash Functions.

## Usages:
Merkle tree(Hash tree)  is used to verify any kind of data stored, handled and transferred in and between computers.

Currently, the main use of Merkle tree is to make sure that data blocks received from other peers in a peer-to-peer network are received undamaged and unaltered, and even to check that the other peers do not lie and send fake blocks.

Merkle tree is used in git, Amazon's Dynamo, Cassandra as well as BitCoin.

## Working of Merkel tree
A Merkle tree totals all transactions in a block and generates a digital fingerprint of the entire set of operations, allowing the user to verify whether it includes a transaction in the block.
- Merkle trees are made by hashing pairs of nodes repeatedly until only one hash remains; this hash is known as the Merkle Root or the Root Hash.
- They're built from the bottom, using Transaction IDs, which are hashes of individual transactions. 
- Each non-leaf node is a hash of its previous hash, and every leaf node is a hash of transactional data.

# Architecture
Merkle tree is a fundamental part of blockchain technology. It is a mathematical data structure composed of hashes of different blocks of data, and which serves as a summary of all the transactions in a block. It also allows for efficient and secure verification of content in a large body of data. It also helps to verify the consistency and content of the data. Both Bitcoin and Ethereum use Merkle Trees structure. Merkle Tree is also known as Hash Tree.
A Merkle tree stores all the transactions in a block by producing a digital fingerprint of the entire set of transactions. It allows the user to verify whether a transaction can be included in a block or not.

Merkle trees are created by repeatedly calculating hashing pairs of nodes until there is only one hash left. This hash is called the Merkle Root, or the Root Hash. The Merkle Trees are constructed in a bottom-up approach.
Every leaf node is a hash of transactional data, and the non-leaf node is a hash of its previous hashes. Merkle trees are in a binary tree, so it requires an even number of leaf nodes. If there is an odd number of transactions, the last hash will be duplicated once to create an even number of leaf nodes.


![image](https://user-images.githubusercontent.com/55658051/165556455-088dd81f-1d7a-47c7-b696-909d32af5b0b.png)

### Explanation

The above example is the most common and simple form of a Merkle tree, i.e., Binary Merkle Tree. There are four transactions in a block: TX1, TX2, TX3, and TX4. Here you can see, there is a top hash which is the hash of the entire tree, known as the Root Hash, or the Merkle Root. Each of these is repeatedly hashed, and stored in each leaf node, resulting in Hash 0, 1, 2, and 3. Consecutive pairs of leaf nodes are then summarized in a parent node by hashing Hash0 and Hash1, resulting in Hash01, and separately hashing Hash2 and Hash3, resulting in Hash23. The two hashes (Hash01 and Hash23) are then hashed again to produce the Root Hash or the Merkle Root.

Merkle Root is stored in the block header. The block header is the part of the bitcoin block which gets hash in the process of mining. It contains the hash of the last block, a Nonce, and the Root Hash of all the transactions in the current block in a Merkle Tree. So having the Merkle root in block header makes the transaction tamper-proof. As this Root Hash includes the hashes of all the transactions within the block, these transactions may result in saving the disk space.

![image](https://user-images.githubusercontent.com/55658051/165556597-4691891e-cdc0-4b3e-ac42-aa327eb62f1e.png)

# Structure of the node of binary Merkle tree
It contains four variables:

- It contains a key variable.
- It contains value variable
- It contains two links.

## Find operation in Merkle tree
This function is used to check whether the given key is present in the merkle tree or not. If it is present then it will return that node else it will return null. This function is used to retrieve data from Git. When we commit a change to a repository in git. Git computes SHA-1 ( SHA-1 produces a 160-bit hash value from an arbitrary length string) over the contents of that directory tree and stores them with metadata. It is stored in .git/objects and gives you back the unique key that now refers to that data object.

### Algorithm of find function in Merkle tree

- Step 1: We will take tree and key as parameters.
- Step 2: If the tree is null then we will return null.
- Step 3: If the tree->key is equal to the key we will return the tree.
- Step 4: If the key is smaller than tree->key then we will return find(tree->left, key)
- Step 5: else return find(tree->right, key)

## Add operation in Merkle tree
This function is used to add a node into the merkle tree. This function is used to insert source code into a git repository. When we commit a change to a repository. Git computes SHA-1 over the contents of that directory tree and stores them with metadata. The metadata includes information such as pointer to parent commit and a commit message as a commit object.

### Algorithm to add a node in Merkle tree.
- Step 1: We will take key and value as parameters.
- Step 2: Take the hash(key) and store it in a variable called index.
- Step 3: store (struct node*) arr[index].head in a pointer called tree of datatype node.
- Step 4: create a new node with its key as key and value as value and both links as null.
- Step 5: If the tree is null then assign the new node to the head and increment the size by 1.
- Step 6: If the tree is not null then we will check if the key is already present in the tree using the find function.
- Step 7: If the key is already present in the tree then we will update the value.
- Step 8: If it is not present in the tree then we will use the insert function to insert the element.

### Algorithm of insert function.

- Step 1: It will take tree and item pointers of node data type as parameters.
- Step 2: If item->key is smaller than tree->key and tree->left is null then assign the item to tree->left.
- Step 3: If item->key is smaller than tree->key and tree->left is not null then call insert function with tree->left and item as parameters.
- Step 4: If item->key is greater than tree->key and tree->right is null then assign the item to tree->right.
- Step 5: If item->key is greater than tree->key and tree->right is not null then call insert function with tree->right and item as parameters.

## Delete a node from merkle tree
This function is used to delete a node from Merkle tree. If the key given is present in the merkle tree then it will delete the node from the tree. Git remembers all the files you have staged and stores them in a tree structure inside the commit. The nodes of this tree represent your files and directories. This function is used to delete these nodes.

###Algorithm to delete a node in Merkle tree.
- Step 1: We will take a key as a parameter.
- Step 2: Take the hash(key) and store it in a variable called index.
- Step 3: store (struct node*) arr[index].head in a pointer called tree of datatype node.
- Step 4: If the tree is null then the key is not present.
- Step 5: If the tree is not null then we will check if the key is already present in the tree using the find function.
- Step 6: If the find function returns null then the key is not present in the tree.
- Step 7: If it is not null then we will use the remove function to delete the element.

###Algorithm of remove function.
- Step 1: It will take tree and key as parameters.
- Step 2: If the tree is null then return null.
- Step 3: If the key is smaller than the tree->key then tree->left is equal to remove(tree->left, key) and return tree.
- Step 4: If the key is greater than the tree->key then tree->right is equal to remove(tree->right, key) and return tree.
- Step 5: else if the tree->left is equal to null and the tree->right is equal to null then decrement the size and return tree->left.
- Step 6: else if the tree->left is not equal to null and the tree->right is equal to null then decrement the size and return tree->left.
- Step 7: else if tree->left is equal to null and tree->right is not equal to null then decrement the size and return tree->right.
- Step 8: else assign tree->left to a pointer called left of data type node.
- Step 9: While left->right is not equal to null, left is equal to left->right.
- Step 10: tree->key is equal to left->key.
- Step 11: tree->value is equal to left->value.
- Step 12: tree->left is equal to remove(tree->left, tree->key).
- Step 13: Return tree.
