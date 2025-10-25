class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string> board(n, string(n, '.'));
        vector<bool> cols(n, false), d1(2 * n - 1, false), d2(2 * n - 1, false);
        backtrack(0, n, cols, d1, d2, board, res);
        return res;
    }
    
    void backtrack(int row, int n, vector<bool>& cols, vector<bool>& d1, vector<bool>& d2, vector<string>& board, vector<vector<string>>& res) {
        if (row == n) {
            res.push_back(board);
            return;
        }
        for (int col = 0; col < n; ++col) {
            int id1 = row - col + n - 1;
            int id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            board[row][col] = 'Q';
            cols[col] = d1[id1] = d2[id2] = true;
            backtrack(row + 1, n, cols, d1, d2, board, res);
            cols[col] = d1[id1] = d2[id2] = false;
            board[row][col] = '.';
        }
    }
};
