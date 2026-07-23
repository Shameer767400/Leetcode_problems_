class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<char> row[9], col[9], box[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                char c = board[i][j];
                int b = (i / 3) * 3 + (j / 3);

                if (row[i].count(c) || col[j].count(c) || box[b].count(c))
                    return false;

                row[i].insert(c);
                col[j].insert(c);
                box[b].insert(c);
            }
        }

        return true;
    }
};