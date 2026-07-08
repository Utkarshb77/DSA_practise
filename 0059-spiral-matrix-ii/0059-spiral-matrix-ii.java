class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int x = 1;
        int i=0 , j=0, nrow = n-1;
        while(nrow >= 1){
            for(int k = 0 ; k < nrow ; k++ ){
                arr[i][j] = x++;
                j++;
            }
            for(int k = 0 ; k < nrow ; k++ ){
                arr[i][j] = x++;
                i++;
            }
            for(int k = 0 ; k < nrow ; k++ ){
                arr[i][j] = x++;
                j--;
            }
            for(int k = 0 ; k < nrow ; k++ ){
                arr[i][j] = x++;
                i--;
            }   
            i++;
            j++;
            nrow -= 2;
        }
        if( nrow == 0) arr[i][j] = x;
        return arr;
    }
}