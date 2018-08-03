package com.leo.sudoku;

public interface Sudoku01{
    public static final int[][] sudoku = new int[][]{
                    {
                                    0, 0, 9, 1, 0, 6, 0, 0, 7
                    }, {
                                    0, 5, 0, 0, 9, 0, 0, 0, 1
                    }, {
                                    9, 0, 8, 2, 0, 0, 7, 0, 0
                    }, {
                                    0, 9, 0, 0, 1, 0, 0, 4, 0
                    }, {
                                    5, 0, 0, 0, 2, 0, 0, 0, 4
                    }, {
                                    0, 2, 0, 0, 5, 0, 0, 8, 0
                    }, {
                                    0, 0, 5, 0, 0, 2, 9, 0, 8
                    }, {
                                    8, 0, 0, 0, 7, 0, 0, 9, 0
                    }, {
                                    1, 0, 0, 7, 0, 9, 8, 0, 0
                    }
    };

    public static final int[][] line_h = new int[][]{
                    {
                                    1, 1, 1, 1, 1, 1, 1, 1, 1
                    }, {
                                    0, 1, 0, 1, 1, 0, 1, 1, 0
                    }, {
                                    1, 0, 1, 1, 0, 0, 1, 0, 0
                    }, {
                                    0, 0, 1, 0, 0, 1, 0, 1, 0
                    }, {
                                    0, 0, 0, 0, 0, 0, 1, 0, 0
                    }, {
                                    0, 0, 1, 0, 0, 0, 0, 0, 0
                    }, {
                                    0, 1, 0, 1, 0, 0, 1, 0, 0
                    }, {
                                    0, 0, 1, 0, 0, 1, 1, 0, 1
                    }, {
                                    0, 1, 1, 0, 1, 1, 0, 1, 0
                    }
    };

    public static final int[][] line_v = new int[][]{
                    {
                                    1, 1, 0, 0, 0, 0, 1, 0, 0
                    }, {
                                    1, 0, 1, 1, 0, 1, 0, 1, 1
                    }, {
                                    1, 1, 1, 0, 1, 1, 1, 0, 1
                    }, {
                                    1, 1, 0, 1, 1, 1, 0, 1, 1
                    }, {
                                    1, 1, 0, 1, 1, 1, 1, 0, 1
                    }, {
                                    1, 1, 1, 0, 1, 1, 1, 0, 1
                    }, {
                                    1, 1, 0, 1, 1, 1, 0, 1, 1
                    }, {
                                    1, 1, 1, 0, 1, 0, 1, 1, 0
                    }, {
                                    1, 0, 0, 1, 0, 0, 0, 0, 1
                    }
    };
}