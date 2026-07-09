class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int i = 0 , j= 0;
        int n = matrix.length-1;
        int c = matrix[0].length-1;
        while( n >= 1 && c >= 1 ){
            for(int k=0;k<c;k++){
                ls.add(matrix[i][j]);
                j++;
            }
            for(int k=0;k<n;k++){
                ls.add(matrix[i][j]);
                i++;
            }
            for(int k=0;k<c;k++){
                ls.add(matrix[i][j]);
                j--;
            }
            for(int k=0;k<n;k++){
                ls.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            n -= 2;
            c -= 2;
        }
        if( n == 0 ){
            for(int k = 0 ; k < c + 1 ; k++){
                ls.add(matrix[i][j]);
                j++;
            }
        }
        else if( c == 0 ){
            for(int k = 0 ; k < n + 1 ; k++){
                ls.add(matrix[i][j]);
                i++;
            }
        }
        return ls;
    }
}