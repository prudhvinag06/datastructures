
//Leetcode 200

class Solution {
    public int numIslands(char[][] grid){
        UnionFind uf = new UnionFind(grid);
        int m = grid.length; 
        int n = grid[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    for(int k = 0; k < 4; k++){
                        int new_x = dx[k] + i;
                        int new_y = dy[k] + j;
                        if(new_x < 0 || new_x >= m || new_y < 0 || new_y >= n || grid[new_x][new_y] == '0')
                            continue;
                        int id1 = i * n + j;
                        int id2 = new_x * n + new_y;
                        
                        uf.union(id1, id2);
                        
                    }
                }
            }
        }
        
        return uf.count;
    }
}

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
