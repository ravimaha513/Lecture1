package com.info.lecture1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class QItem {

    int row;
    int column;
    int dist;


    public QItem(int row, int column, int dist) {
        this.row = row;
        this.column = column;
        this.dist = dist;
    }

}

class RobotFlag {

    boolean[][] visited = new boolean[4][4];

    public List<String> printDirections(List<String> inputString) {

        char[][] chars = new char[4][4];

        for(int i =0; i < inputString.size(); i++){
            chars[i] = inputString.get(i).toCharArray();
        }

        System.out.println(Arrays.deepToString(chars));

        System.out.println(minDistance(chars));

        return Arrays.asList("DOWN");
    }

    public int minDistance(char[][] grid) {

        QItem source = new QItem(0, 0, 0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == '-') visited[i][j] = true;
                else visited[i][j] = false;

                if (grid[i][j] == 'b') {
                    source.row = i;
                    source.column = j;

                }
            }

        }

        Queue<QItem> q = new LinkedList<>();

        q.add(source);

        visited[source.row][source.column] = true;

        while (!q.isEmpty()) {

            QItem p = q.peek();

            if (grid[p.row][p.column] == 'd') return p.dist;

            //moving UP
            if (p.row - 1 >= 0 &&
                    visited[p.row - 1][p.column] == false) {
                q.add(new QItem(p.row - 1, p.column, p.dist + 1));
                visited[p.row - 1][p.column] = true;
            }

            //moving down
            if (p.row + 1 < 4 &&
                    visited[p.row + 1][p.column] == false) {
                q.add(new QItem(p.row + 1, p.column, p.dist + 1));
                visited[p.row + 1][p.column] = true;
            }

            // moving left
            if (p.column - 1 >= 0 &&
                    visited[p.row][p.column - 1] == false) {
                q.add( new QItem(p.row, p.column - 1, p.dist + 1));
                visited[p.row][p.column - 1] = true;
            }

            // moving right
            if (p.column + 1 < 4 &&
                    visited[p.row][p.column + 1] == false) {
                q.add(new QItem(p.row, p.column + 1, p.dist + 1));
                visited[p.row][p.column + 1] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

                new RobotFlag().printDirections(Arrays.asList(
                        "b---",
                        "f---",
                        "----",
                        "----"
                ));
    }

}


