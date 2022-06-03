package com.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        Arrays.stream(emails).forEach(
                it -> {
                    String[] names = it.split("@");
                    String[] localNames = names[0].split("\\+");
                    String result = localNames[0].replaceAll("\\.", "") + "@" + names[1];
                    set.add(result);
                }
        );
        return set.size();
    }
    public int numUniqueEmails2(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0];
            local = local.replace(".", "");
            emailSet.add(local + email.substring(i));
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        test929 test929 = new test929();
        int numUniqueEmails = test929.numUniqueEmails(emails);
        System.out.println(numUniqueEmails);
    }
}
