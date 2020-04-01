package com.company.leetCode;


import com.company.leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return null;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) throws ExecutionException, InterruptedException {
            if(data.equals("[]")) return null;
            String[] strData = data.substring(1, data.length() - 1).split(",");
            List<Integer> intData = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>(intData);
            for(String str : strData) {
                if(str.equals("null")) intData.add(null);
                else intData.add(Integer.parseInt(str));
            }
            ExecutorService executorService = Executors.newSingleThreadExecutor();
//            RecursiveTask
            Callable<TreeNode> task = () -> {
                if(q.peek() == null) return null;
                TreeNode ret = new TreeNode(q.poll());
                ret.left = null;
                return ret;
            };
            Future<TreeNode> future = executorService.submit(() -> {
                return null;
            });
            return future.get();
        }
    }

    public static void main(String[] args) {
        String data = "[1]";
        String[] strData = data.substring(1, data.length() - 1).split(",");
        System.out.println(strData[0]);
        List<Integer> intData = Stream.of(strData).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println(intData);
    }
}
