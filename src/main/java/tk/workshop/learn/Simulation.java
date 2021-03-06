package tk.workshop.learn;

public class Simulation {

    public static int DEAD = 0;
    public static int ALIVE = 1;

    int width;
    int height;
    int[][] board;


    public Simulation(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void printBoard() {
        System.out.println("---");
        for (int y = 0; y < height; y++) {
            String line = "|";
            for (int x = 0; x < width; x++) {
                if (this.board[x][y] == DEAD) {
                    line += ".";
                } else {
                    line += "*";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---\n");
    }

    public void setState(int x, int y, int state) {
        if (x < 0 || x >= width) {
            return;
        }

        if (y < 0 || y >= height) {
            return;
        }

        this.board[x][y] = state;
    }

    public void setAlive(int x, int y) {
        this.setState(x, y, ALIVE);
    }

    public void setDead(int x, int y) {
        this.setState(x, y, DEAD);
    }

    public int coutAliveNeighbours(int x, int y) {
        int count = 0;

        count += this.getState(x - 1, y - 1);
        count += this.getState(x, y - 1);
        count += this.getState(x + 1, y - 1);

        count += this.getState(x - 1, y);
        count += this.getState(x + 1, y);

        count += this.getState(x - 1, y + 1);
        count += this.getState(x, y + 1);
        count += this.getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }

        if (y < 0 || y >= height) {
            return 0;
        }

        return this.board[x][y];
    }

    public void step() {
        int[][] newBorad = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = coutAliveNeighbours(x, y);

                if (getState(x, y) == ALIVE) {
                    if (aliveNeighbours < 2) {
                        newBorad[x][y] = DEAD;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) { // TODO : remove
                        newBorad[x][y] = ALIVE;
                    } else if (aliveNeighbours > 3) {
                        newBorad[x][y] = DEAD;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBorad[x][y] = ALIVE;
                    }
                }
            }
        }

        this.board = newBorad;
    }
}
