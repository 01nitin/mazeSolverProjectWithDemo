package mazeSolverProject;
import java.util.*;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
public class MAZE_SOLVER_PROJECT extends JFrame {
    //the grid of the project
    private final int[][] maze =
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public List<Integer> path = new ArrayList<>();

    //create the constructor
    public MAZE_SOLVER_PROJECT(){
        
        setTitle("MAZE_SOLVER");
        setLocation(200, 200); // it will give the location of frame
        setSize(640, 720); // its a grid of project
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // here we are basically calling the DFS which we are derived
        DepthFirstSearch.searchPath(maze, 1, 1, path);
        System.out.println(path);
    }
    @Override
    // we able to  perform graphics like color and all the thing's
    public void paint(Graphics g){
        g.translate(50,50); // give the grid in 50, 50 location
        for (int i= 0 ;i< maze.length; i++){
            for (int j= 0 ;j<maze[0].length ;j++){
                Color color = switch (maze[i][j]) {
                    case 1 -> Color.black;
                    case 9 -> Color.red;
                    default -> Color.white;
                }; // color objet is used to set the color

                g.setColor(color); // set the color in grid
// the rectangle define that what will be the path rect width height
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.red);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        // here creation of the path
        for (int i = 0 ; i < path.size(); i += 2){
            int pathX = path.get( i );
            int pathY = path.get( i + 1);

            System.out.println("X coordinates " + pathX); // it's giving the x coordinate
            System.out.println("y coordinates " + pathY); // it's giving the y coordinate

            g.setColor(Color.green);//this is used to define the color of the path but it's not working fine
            g.fillRect(30*pathX , 30*pathY , 30 , 30);


        }
    }

    public static void main(String[] args) {
//        System.out.println("This is the project of the maze solver using graph 2D array  and finding the shortest path ");
        MAZE_SOLVER_PROJECT  view = new MAZE_SOLVER_PROJECT();
        view.setVisible(true);
    }
}
