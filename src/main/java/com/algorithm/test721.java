package com.algorithm;

import java.util.*;

public class test721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //邮件对应的索引
        Map<String, Integer> emailToIndex = new HashMap<>();
        //邮件对应的用户名
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.getFirst();
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    //初始化邮件，索引
                    emailToIndex.put(email, emailsCount++);
                    //初始化邮件，用户名
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String email = account.get(i);
                int nextIndex = emailToIndex.get(email);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> email : indexToEmails.values()) {
            Collections.sort(email);
            String name = emailToName.get(email.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(email);
            merged.add(account);
        }
        return merged;
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int x1) {
            parent[find(x)] = find(x1);
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

    }
}

