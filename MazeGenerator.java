//package com.technobium.rl;
import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;

public class MazeGenerator {
    //instance data, r to generate random features of map
    //mazeWidth and mazeHeight determine the measurements of map
    private Random r;
    int mazeWidth;
    int mazeHeight;

    //empty constructor, default dimesions are 10x10
    public MazeGenerator(){
        r = new Random();
        mazeWidth = 10;
        mazeHeight = 10;   
    }

    //constructor to set own dimensions
    public MazeGenerator(int width, int height){
        r = new Random();
        mazeWidth = width;
        mazeHeight = height;
    }

    //create_maze function
    public void CreateMaze(){
        //random exit in the measurements of map
        int[] out = new int[] {r.nextInt(mazeWidth), r.nextInt(mazeHeight)};
        //string to store the maze
        String maze = new String();
        //random seed for whether a coordinate is an obstacle
        //or not, i.e. seed = 4 means 25% it will be
        int ObstacleSeed = 4;
        //iterates through every row and assigns appropriate value
        for(int i = 0; i < mazeHeight; i++){
            for(int j=0; j < mazeWidth; j++){
                //generates random number between 0 and seed-1
                int isObstacle = r.nextInt(ObstacleSeed);
                //checks if the point is the destination
                //F designates the endpoint
                if (j==out[0] && i==out[1]){
                    maze+='F';
                //checks if obstacle when isObstacle is 0, designated by an X
                //the seed can be adjusted to increase/decrease generation
                } else if(isObstacle == 0){
                    maze+='X';
                //otherwise, it is a free space, designated by 0
                } else{
                    maze+='0';
                }
            }
        maze+="\n";
        }
        System.out.println(maze);

        //writes and adds string to a file
        try{
            File file = new File("Maze.txt");
            FileWriter w = new FileWriter(file);
            w.write(maze);
            w.close();
        } catch (IOException e){
            System.out.println("NOOO!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MazeGenerator m = new MazeGenerator();
        m.CreateMaze();
    }
}