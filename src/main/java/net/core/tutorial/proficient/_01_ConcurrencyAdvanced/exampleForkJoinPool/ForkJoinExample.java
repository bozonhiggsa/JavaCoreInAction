package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleForkJoinPool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinExample {

    static class TreeNode {

        int value;
        Set<TreeNode> children;

        TreeNode(int value, TreeNode... children) {
            this.value = value;
            this.children = Sets.newHashSet(children);
        }
    }

    public static class CountingTask extends RecursiveTask<Integer> {

        private final TreeNode node;

        public CountingTask(TreeNode node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            return node.value + node.children.stream()
                    .map(childNode -> new CountingTask(childNode).fork())
                    .collect(Collectors.summingInt(ForkJoinTask::join));
        }
    }

    static class Sets {

        public static Set<TreeNode> newHashSet(TreeNode... children){

            Set<TreeNode> set = new HashSet<>();
            for (TreeNode node: children) {
                set.add(node);
            }
            return set;
        }
    }
}
