package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
    int ref;
    Map<String, Trie> children;

    public Trie() {
        ref = -1;
        children = new HashMap<>();
    }
}

public class test1233 {
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }
        List<String> ans = new ArrayList<>();
        dfs(folder, ans, root);
        return ans;
    }

    public List<String> split(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public void dfs(String[] folder, List<String> ans, Trie cur) {
        //不是-1就是一个完整的路径,不必往后继续遍历,因为后面深度只会增加
        if (cur.ref != -1) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs(folder, ans, child);
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        test1233 test1233 = new test1233();
        List<String> ans = test1233.removeSubfolders(folder);
        System.out.println(ans);
    }
}
