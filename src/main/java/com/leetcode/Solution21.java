package com.leetcode;

import com.leetcode.util.ListNode;

public class Solution21 {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 4};
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
