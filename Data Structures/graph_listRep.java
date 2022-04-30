/*
https://leetcode.com/problems/number-of-provinces/
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        LinkedList<Integer> graph[] = new LinkedList[n];
        for(int i = 0; i < n; i++)
            graph[i] = (new LinkedList<>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1)
                    graph[i].add(j);
            }
        }
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, visited, graph);  
            }
        }
        return provinces;
    }
    
    public void dfs(int node, boolean[] visited, LinkedList<Integer> graph[]){
        visited[node] = true;
        
        for(int x : graph[node]){
            if(!visited[x])
                dfs(x, visited, graph);
        }
    }
    
    
}
