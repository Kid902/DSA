class Solution {
    class Pair{
        int row;
        int col;
        int value;
        Pair(int row,int col,int value){
            this.row=row;
            this.col=col;
            this.value=value;
        }
    }
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        if((n+m)%2==0)return false;
        if(grid[0][0]==')'||grid[n-1][m-1]=='(')return false;
        int[][]arr=new int[n][m];
        boolean[][][]visited=new boolean[n][m][(n+m)/2+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='(')arr[i][j]=1;
                else arr[i][j]=-1;
            }
        }
        Queue<Pair>queue=new LinkedList<>();
        queue.offer(new Pair(0,0,arr[0][0]));
        visited[0][0][arr[0][0]]=true;
        int[]allowedRow={1,0};
        int[]allowedCol={0,1};
        while(!queue.isEmpty()){
            Pair cur=queue.poll();
            if(cur.row==n-1&&cur.col==m-1){
                if(cur.value==0)return true;
                else continue;
            }
            for(int i=0;i<2;i++){
                int newRow=cur.row+allowedRow[i];
                int newCol=cur.col+allowedCol[i];
                if(isValidPath(newRow,newCol,n,m)){
                   int newVal=cur.value+arr[newRow][newCol];
                   int maxPossibleValue=(n-1-newRow)+(m-1-newCol);
                   if(newVal>=0&&newVal<=maxPossibleValue&&!visited[newRow][newCol][newVal]){
                       visited[newRow][newCol][newVal]=true;
                       queue.offer(new Pair(newRow,newCol,newVal));
                   }
                }
            }
        }
        return false;
    }
    public boolean isValidPath(int row,int col,int n,int m){
        return row>=0&&row<n&&col>=0&&col<m;
    }
}