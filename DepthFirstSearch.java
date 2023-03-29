package mazeSolverProject;
import java.util.*;
public class DepthFirstSearch {
    public  static boolean searchPath(int[][]maze, int x ,int y , List<Integer> path){
        if(maze[y][x]== 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x]== 0){
            maze[y][x]= 2; // visited the path means 2

            // four direction we have w'll choose to go in any direction
            int dx = -1;
            int dy = 0 ;
            // it executes when this path is true
            if(searchPath(maze , x+dx , y+dy, path)){
                path.add(x);  // add the coordinate
                path.add(y);
                return true;
            }

            dx = 1 ;
            dy = 0;
            if(searchPath(maze, x+dx , y+dy, path)){
                path.add(x);  // add the coordinate
                path.add(y);
                return true;

            }

            dx = 0;
            dy = -1;
            if(searchPath(maze, x+dx , y+dy, path)) {
                path.add(x);  // add the coordinate
                path.add(y);
                return true;
            }

            dx = 0  ;
            dy = 1;
            if(searchPath(maze, x+dx , y+dy, path)) {
                path.add(x);  // add the coordinate
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
