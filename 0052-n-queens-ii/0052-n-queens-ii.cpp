class Solution {
private:
    int count = 0; 
    void solve(int row, int n, std::vector<bool>& col_occupied, 
               std::vector<bool>& diag1_occupied, std::vector<bool>& diag2_occupied) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; ++col) {
            int diag1_index = row + col; 
            int diag2_index = row - col + n - 1; 
            if (!col_occupied[col] && !diag1_occupied[diag1_index] && !diag2_occupied[diag2_index]) {
                col_occupied[col] = true;
                diag1_occupied[diag1_index] = true;
                diag2_occupied[diag2_index] = true;
                solve(row + 1, n, col_occupied, diag1_occupied, diag2_occupied);
                col_occupied[col] = false;
                diag1_occupied[diag1_index] = false;
                diag2_occupied[diag2_index] = false;
            }
        }
    }

public:
    int totalNQueens(int n) {
        
        std::vector<bool> col_occupied(n, false);
        std::vector<bool> diag1_occupied(2 * n - 1, false); 
        std::vector<bool> diag2_occupied(2 * n - 1, false);
        solve(0, n, col_occupied, diag1_occupied, diag2_occupied);    
        return count;
    }
};