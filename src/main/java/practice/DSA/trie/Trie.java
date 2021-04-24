package practice.DSA.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> children;
	Character value;
	boolean isWord;

	TrieNode(Character ch){
		this.value = ch;
		this.children = new HashMap<>();
		this.isWord = false;
	}
}

public class Trie {
	TrieNode root = new TrieNode('*');

	public void insert(String word) {
		TrieNode current = root;
		for (Character ch : word.toCharArray()) {
			current = current.children.computeIfAbsent(ch, TrieNode::new);
		}
		current.isWord = true;
	}

	public boolean find(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isWord;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("world");
		System.out.println(trie.find("wor"));
	}
}
