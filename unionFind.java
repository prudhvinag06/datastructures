//Call using the class object

class UnionFind{
    int count = 0;
    int parent[];
    int m, n; 
    
    UnionFind(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    int id = i * n + j;
                    parent[id] = id;
                    count++;
                }
            }
        }
    }
    
    public void union(int u, int v){
        int parent_u = findParent(u);
        int parent_v = findParent(v);
        
        if(parent_u != parent_v){
            parent[parent_u] = parent_v;
            count--;
        }
    }
    
    public int findParent(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = findParent(parent[u]);
    }
}
