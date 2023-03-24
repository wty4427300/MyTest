package com.algorithm;

public class test1032 {
}

class StreamChecker {

    private StringBuilder sb = new StringBuilder();
    private TrieTree trie = new TrieTree();

    public StreamChecker(String[] words) {
        for (String w : words) {
            trie.insert(w);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return trie.query(sb);
    }
}

class TrieTree{
    TrieTree[] children=new TrieTree[26];
    boolean isEnd=false;

    public void insert(String words){
        TrieTree node=this;
        //倒序构建字典树
        for (int i=words.length()-1;i>=0;i--){
            int idx=words.charAt(i)-'a';
            if (node.children[idx]==null){
                node.children[idx]=new TrieTree();
            }
            node=node.children[idx];
        }
        node.isEnd=true;
    }

    public boolean query(StringBuilder s){
        TrieTree node=this;
        for (int i=s.length()-1,j=0;i>=0&&j<201;i--,j++){
            int idx=s.charAt(i)-'a';
            if (node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
            if (node.isEnd){
                return true;
            }
        }
        return false;
    }
}
