class Solution {
    public String foreignDictionary(String[] words) {
        Set<Character> allChars = new HashSet<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        Queue<Character> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // Step 1: Build graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());

            boolean foundDiff = false;
            for (int j = 0; j < len; j++) {
                char ch1 = w1.charAt(j), ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    graph.putIfAbsent(ch1, new HashSet<>());
                    if (graph.get(ch1).add(ch2)) {
                        indegree.put(ch2, indegree.getOrDefault(ch2, 0) + 1);
                    }
                    foundDiff = true;
                    break;
                }
            }

            // Edge case: "abc" before "ab" → invalid
            if (!foundDiff && w1.length() > w2.length()) {
                return "";
            }
        }

        // Step 2: Collect all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
            }
        }

        // Step 3: Initialize queue with 0-indegree chars
        for (char c : allChars) {
            if (!indegree.containsKey(c)) {
                que.add(c);
            }
        }

        // Step 4: Topological sort (BFS)
        while (!que.isEmpty()) {
            char ch = que.poll();
            sb.append(ch);

            for (char next : graph.getOrDefault(ch, new HashSet<>())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    que.offer(next);
                }
            }
        }

        // Step 5: Final check
        return sb.length() == allChars.size() ? sb.toString() : "";
    }

}
