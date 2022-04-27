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

