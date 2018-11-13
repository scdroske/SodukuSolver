package SudokuSolver;

public class Grid {
    public class Node {
        private int data, boxID;
        private Node up, down, left, right;

        private boolean[] solvable = new boolean[10];

        // Initialize the variables
        public Node() {
            this.data = 0;
            this.boxID = 0;
            this.up = null;
            this.down = null;
            this.left = null;
            this.right = null;

            for (int i = 0; i < solvable.length; i++) {
                // Set the possibility for all 1-9 to true initially
                solvable[i] = true;
            }
            solvable[0] = false;
        }

        // Constructor overload
        public Node(int data) {
            this.data = data;
        }

        // Getters and setters for the Node value
        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        // Returns ID of the box the cell belongs to
        public int getBoxID() {
            return this.boxID;
        }

        // Sets ID of the box the cell belongs to
        public void setBoxID(int id) {
            this.boxID = id;
        }

        // Getters for the adjacent nodes
        public Node getUp() {
            return this.up;
        }

        public Node getDown() {
            return this.down;
        }

        public Node getRight() {
            return this.right;
        }

        public Node getLeft() {
            return this.left;
        }

        // Setters for the adjacent nodes
        public void setUp(Node up) {
            this.up = up;
        }

        public void setDown(Node down) {
            this.down = down;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        // Set the possibility of a number to impossible
        public void setImpossible(int poss) {
            solvable[poss] = false;
        }

        // Getter for the possibilities array
        public boolean[] getPossibilities() {
            return this.solvable;
        }

        // Method for solving the node when there is only 1 possibility
        public boolean solveNode() {
            if (this.data == 0) { // If not already solved

                int poss = 0; // Number of possibilities
                int solvedVal = 0;
                for (int i = 1; i < solvable.length; i++) { // Iterate through each possibility
                    if (this.solvable[i] == true) {
                        poss++;
                        solvedVal = i;
                    }
                }
                if (poss == 1) { // If there was only 1 possibility found
                    this.data = solvedVal;
                    return true; // Return true if the cell was solved
                }
            }

            return false;
        }


    }
}