public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int[] edge : times){
            if(!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int max = 0;
        pq.add(new int[]{k, 0});
        while(pq.size() > 0){
            int[] val = pq.remove();
            int u = val[0];
            int w = val[1];
            if(visited[u])
                continue;
            visited[u] = true;
            n--;
            max = Math.max(max, w);
            if(n == 0)
                return max;
            if(!map.containsKey(u))
                continue;
            for(int[] edge : map.get(u)){
                if(!visited[edge[0]])
                pq.add(new int[]{edge[0], w + edge[1]});
            }
        }
        
        return n == 0 ? max : -1;
    }
