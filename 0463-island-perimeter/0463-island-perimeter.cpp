class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int perimeter = 0;
        int rows = grid.size();
        int cols = grid[0].size();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    
                    // Check if there's land above
                    if (i > 0 && grid[i-1][j] == 1) {
                        perimeter -= 2;
                    }
                    
                    // Check if there's land to the left
                    if (j > 0 && grid[i][j-1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        
        return perimeter;
    }
};