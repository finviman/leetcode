package com.home;

import java.util.*;

public class FullPermutation {

    public static void main(String[] args) {
        FullPermutation f = new FullPermutation();
        List<Integer> testData = new ArrayList<>();
        testData.add(1);
        testData.add(2);
        testData.add(3);
        List<List<Integer>> permutation = f.permutation(testData);
        for (List<Integer> sub : permutation) {
            f.outPutList(sub);
        }
    }

    private void outPutList(List<Integer> data) {
        System.out.print("[");
        for (Integer datum : data) {
            System.out.print(datum+",");
        }
        System.out.println("]");
    }

    private List<List<Integer>> permutation(List<Integer> list) {
        assert list!=null && list.size()>0;
        if (list.size()==1) {
            List<Integer> one = new ArrayList<>();
            one.add(list.get(0));
            return Collections.singletonList(one);
        }else {
            Integer lastOne = list.remove(list.size() - 1);
            List<List<Integer>> subResult = permutation(list);
            List<List<Integer>> thisResult = new ArrayList<>();
            for (List<Integer> subPermute : subResult) {
                thisResult.addAll(permuteStep(lastOne, subPermute));
            }
            return thisResult;
        }
    }

    private List<List<Integer>> permuteStep(Integer moreOne, List<Integer> currentPermute) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < currentPermute.size()+1; i++) {
            List<Integer> newPer = new ArrayList<>();
            for (int k = 0; k < currentPermute.size() + 1; k++) {
                //初始化
                newPer.add(0);
            }
            newPer.set(i, moreOne);
            for (int j = 0; j < currentPermute.size(); j++) {
                if (j < i) {
                    newPer.set(j, currentPermute.get(j));
                }
                if (j >= i) {
                    newPer.set(j + 1, currentPermute.get(j));
                }
            }
            result.add(newPer);
        }
        return result;
    }
}
