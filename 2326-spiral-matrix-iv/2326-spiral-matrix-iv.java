class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(arr[i] , -1);
        }
        ListNode s = head;
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;
        while( top <= bottom && left <= right && s != null ){
            // left → right
            for(int k = left ; k <= right && s != null ; k++ ){
                arr[top][k] = s.val;
                s=s.next;
            }
            top++;
            // top → bottom
            for(int k = top ; k <= bottom && s != null ; k++){
                arr[k][right] = s.val;
                s=s.next;
            }
            right--;
            // right → left
            for(int k = right ; k >= left && s != null; k-- ){
                arr[bottom][k] = s.val;
                s=s.next;
            }
            bottom--;
            // bottom → top
            for(int k = bottom ; k >= top && s != null ; k--){
                arr[k][left] = s.val;
                s=s.next;
            }
            left++;
            
        }
        return arr;
    }
}