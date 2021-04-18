package Matrix;

import java.util.LinkedList;
import java.util.Queue;

// Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
//0: Empty cell
//1: Cells have fresh oranges
//2: Cells have rotten oranges
//Determine what is the minimum time required so that all the oranges become rotten.
// A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot every orange then simply return -1.
public class RotAllOranges {

    class Ele {
        int x, y;
        Ele(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    boolean checkAll(int[][] mat){
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                if(mat[i][j] == 1)
                    return true;
        return false;
    }

    int rotOranges(int[][] mat){
        int m = mat.length, n = mat[0].length;

        Queue<Ele> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 2)
                    q.add(new Ele(i, j));
            }
        }

        q.add(new Ele(-1, -1));
        int ans = 0;

        while(!q.isEmpty()){
            // This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in the current time
            // frame so we can increase the count of the required time.
            boolean flag = false;

            Ele tmp = q.poll();

            // validate for (i - 1, j)
            if(tmp.x - 1 >= 0 && mat[tmp.x - 1][tmp.y] == 1){
                if(!flag){
                    ans++;
                    flag = true;
                }
                q.add(new Ele(tmp.x - 1, tmp.y));
            }

            // validate for (i + 1, j)
            if(tmp.x + 1 < m && mat[tmp.x + 1][tmp.y] == 1){
                if(!flag){
                    ans++;
                    flag = true;
                }
                q.add(new Ele(tmp.x + 1, tmp.y));
            }

            // validate for (i, j + 1)
            if(tmp.y + 1 < n && mat[tmp.x][tmp.y + 1] == 1){
                if(!flag){
                    ans++;
                    flag = true;
                }
                q.add(new Ele(tmp.x, tmp.y + 1));
            }

            // validate for (i, j - 1)
            if(tmp.y - 1 >= 0 && mat[tmp.x][tmp.y - 1] == 1){
                if(!flag){
                    ans++;
                    flag = true;
                }
                q.add(new Ele(tmp.x, tmp.y - 1));
            }

            q.poll();

            // If queue is not empty, only then add otherwise loop would be infinite, you dumbf**k
            if(!q.isEmpty())
                q.add(new Ele(-1, -1));
        }

        return checkAll(mat) ? -1 : ans;
    }

}
