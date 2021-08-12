package com.andy.zju.graph;

class NumIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if( n== 0)
            return 0;
        
        int count=0;
        int m = grid[0].length;
        
        for(int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if(grid[i][j] == '1')
                {
                numIslandsUtil(i, j, grid);
                count++;
                }
            }
        }
        
        return count;
    }
    
    
    public void numIslandsUtil(int x, int y, char[][] grid)
    {
        if( x<0 || x>=grid.length || y<0 || y>= grid[0].length || grid[x][y] =='0')
            return;
        
        grid[x][y] = '0';
        
        numIslandsUtil(x+1, y, grid);
        numIslandsUtil(x-1, y, grid);
        numIslandsUtil(x, y+1, grid);
        numIslandsUtil(x, y-1, grid);
        
        
    }
}