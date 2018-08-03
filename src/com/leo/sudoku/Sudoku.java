package com.leo.sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sudoku{
    public static int WIDTH = 1000;
    public static int EDGE = 50;
    public static int BOLD_LINE_WIDTH = 7;
    public static int THIN_LINE_WIDTH = 1;
    public static Color BACK_COLOR = Color.WHITE;
    public static Color LINE_COLOR = Color.BLACK;
    public static Font SODUKU_FONT = new Font(null, Font.BOLD, 72);

    public static void main(String[] args){
        BufferedImage img = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        g.setColor(BACK_COLOR);
        g.fillRect(0, 0, WIDTH, WIDTH);

        g.setColor(LINE_COLOR);
        drawSudoku(g, EDGE, EDGE, WIDTH - EDGE * 2);

        try{
            ImageIO.write(img, "jpg", new File(".\\test.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("done!");
    }

    private static void drawSudoku(Graphics2D g, int x, int y, int width){
        drawEmptySudoku(g, x, y, width);
        drawSudokuNumber(g, x, y, width, Sudoku07.sudoku);
        drawSudokuLineH(g, x, y, width, Sudoku07.line_h);
        drawSudokuLineV(g, x, y, width, Sudoku07.line_v);
    }

    private static void drawLine(Graphics2D g, int x, int y, int length, int lineWidth, boolean horizontal){
        if(lineWidth <= 1){
            if(horizontal){
                g.drawLine(x, y, x + length, y);
            }else{
                g.drawLine(x, y, x, y + length);
            }
        }else{
            int offset = lineWidth % 2 == 0? (lineWidth - 1) / 2: lineWidth / 2;

            if(horizontal){
                g.fillRect(x, y - offset, length, lineWidth);
            }else{
                g.fillRect(x - offset, y, lineWidth, length);
            }
        }
    }

    private static void drawEmptySudoku(Graphics2D g, int x, int y, int width){
        drawLine(g, x, y, width, BOLD_LINE_WIDTH, true);
        drawLine(g, x, y + width, width, BOLD_LINE_WIDTH, true);
        drawLine(g, x, y, width, BOLD_LINE_WIDTH, false);
        drawLine(g, x + width, y, width, BOLD_LINE_WIDTH, false);

        int lineOffset = width / 9;

        for(int i = 1; i < 9; i++){
            drawLine(g, x, y + lineOffset * i, width, THIN_LINE_WIDTH, true);
            drawLine(g, x + lineOffset * i, y, width, THIN_LINE_WIDTH, false);
        }
    }

    private static void drawSudokuNumber(Graphics2D g, int x, int y, int width, int[][] data){
        int lineOffset = width / 9;

        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                String str = data[i - 1][j - 1] == 0? " ": String.valueOf(data[i - 1][j - 1]);
                drawString(g, x + lineOffset * j - lineOffset / 2, y + lineOffset * i - lineOffset / 2, str);
            }
        }
    }

    private static void drawSudokuLineH(Graphics2D g, int x, int y, int width, int[][] data){
        int lineOffset = width / 9;

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(i == 0){
                    break;
                }

                if(data[i][j] == 1){
                    drawLine(g, x + lineOffset * j, y + lineOffset * i, lineOffset, BOLD_LINE_WIDTH, true);
                }
            }
        }
    }

    private static void drawSudokuLineV(Graphics2D g, int x, int y, int width, int[][] data){
        int lineOffset = width / 9;

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(j == 0){
                    continue;
                }

                if(data[i][j] == 1){
                    drawLine(g, x + lineOffset * j, y + lineOffset * i, lineOffset, BOLD_LINE_WIDTH, false);
                }
            }
        }
    }

    private static void drawString(Graphics2D g, int x, int y, String text){
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(SODUKU_FONT);

        FontMetrics metrics = g.getFontMetrics(SODUKU_FONT);
        int strWidth = metrics.stringWidth(text);
        int strHeight = metrics.getHeight();
        int strAscent = metrics.getAscent();

        g.drawString(text, x - strWidth / 2, y - strHeight / 2 + strAscent);
    }
}
