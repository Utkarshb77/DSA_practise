class Solution {
    public int islandPerimeter(int[][] arr) {
        int peri = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    int add = 4;
                    if( i+1 < arr.length && arr[i+1][j] == 1){
                        add -= 1;
                    }
                    if( i-1 >= 0 && arr[i-1][j] == 1){
                        add -=  1;
                    }
                    if( j+1 < arr[0].length && arr[i][j+1] == 1){
                        add -= 1;
                    }
                    if( j-1 >= 0 && arr[i][j-1] == 1){
                        add -= 1;
                    }
                    peri += add;
                }
            }
        }
        return peri;
    }
}