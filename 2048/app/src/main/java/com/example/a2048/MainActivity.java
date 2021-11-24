package com.example.a2048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int yellow = Color.parseColor("#FFFF00");
    int blue = Color.parseColor("#0000FF");
    int red = Color.parseColor("#FF0000");
    int cement = Color.parseColor("#ada6a6");
    TextView[][] textView = {
            {(TextView) findViewById(R.id.z0),(TextView)findViewById(R.id.z1),(TextView)findViewById(R.id.z2),(TextView)findViewById(R.id.z3)},
            {(TextView)findViewById(R.id.o0),(TextView)findViewById(R.id.o1),(TextView)findViewById(R.id.o2),(TextView)findViewById(R.id.o3)},
            {(TextView)findViewById(R.id.t0),(TextView)findViewById(R.id.t1),(TextView)findViewById(R.id.t2),(TextView)findViewById(R.id.t3)},
            {(TextView)findViewById(R.id.u0),(TextView)findViewById(R.id.u1),(TextView)findViewById(R.id.u2),(TextView)findViewById(R.id.u3)}};
    Intent goSecond = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coloring(textView);
    }
    public void up(View v) {
        Button b_up = (Button) findViewById(R.id.b_up);
        if (end(textView)) {
            goSecond.putExtra("rate", rating(textView));
            goSecond.setClass(this, goSecond.class);
            startActivity(goSecond);
            finish();
        }
        b_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveUp(textView);
                randomAdd(textView);
                coloring(textView);
            }
        });
    }
    public void down(View v) {
        Button b_down = (Button) findViewById(R.id.b_down);
        if (end(textView)) {
            goSecond.putExtra("rate", rating(textView));
            goSecond.setClass(this, goSecond.class);
            startActivity(goSecond);
            finish();
        }
        b_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveDown(textView);
                randomAdd(textView);
                coloring(textView);
            }
        });
    }
    public void left(View v) {
        Button b_left = (Button) findViewById(R.id.b_left);
        if (end(textView)) {
            goSecond.putExtra("rate", rating(textView));
            goSecond.setClass(this, goSecond.class);
            startActivity(goSecond);
            finish();
        }
        b_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveLeft(textView);
                randomAdd(textView);
                coloring(textView);
            }
        });
    }
    public void right(View v) {
        Button b_right = (Button) findViewById(R.id.b_right);
        if (end(textView)) {
            goSecond.putExtra("rate", rating(textView));
            goSecond.setClass(this, goSecond.class);
            startActivity(goSecond);
            finish();
        }
        b_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveRight(textView);
                randomAdd(textView);
                coloring(textView);
            }
        });
    }

    public int rating(TextView[][] g) {
        int mx = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                mx = Math.max(Integer.parseInt(g[row][col].getText().toString()), mx);
            }
        }
        return mx;
    }

    public boolean emptySpace(TextView[][] g) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (g[i][j].getText().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean end(TextView[][] g) {
        if (!emptySpace(g)) {
            for (int row = 0; row < 4; row++) {
                for (int col = 1; col < 4; col++) {
                    if (g[row][col].getText().equals(g[row][col - 1].getText())) {
                        return true;
                    }
                }
            }
            for (int col = 0; col < 4; col++) {
                for (int row = 1; row < 4; row++) {
                    if (g[row][col].getText().equals(g[row - 1][col].getText())) {
                        return true;
                    }
                }
            }
            return false;
        }else {
            return true;
        }
    }

    public void randomAdd(TextView[][] g) {
        if (emptySpace(g)) {
            int a = (int) (Math.random() * 4);
            int b = (int) (Math.random() * 4);
            while (true) {
                if (g[a][b].getText().equals("")) {
                    g[a][b].setText("2");
                    break;
                }
                a = (int) (Math.random() * 4);
                b = (int) (Math.random() * 4);
            }
        }
    }

    public void coloring(TextView[][] grid) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j].getText().toString().equals("2")) {
                    grid[i][j].setBackgroundColor(yellow);
                } else if (grid[i][j].getText().toString().equals("")) {
                    grid[i][j].setBackgroundColor(cement);
                } else if (grid[i][j].getText().toString().equals("128")) {
                    grid[i][j].setBackgroundColor(blue);
                } else if (grid[i][j].getText().toString().equals("256")) {
                    grid[i][j].setBackgroundColor(red);
                } else {
                    grid[i][j].setBackgroundColor(yellow);
                }
            }
        }
    }
    public void moveUp(TextView[][] g) {
        // moving up an element only without addition
        for (int col = 0; col < 4; col++) {
            for (int i = 0, pos = 0; i < 4; i++) {
                if (!(g[i][col].getText()).equals("") && g[pos][col].getText().equals("")) {
                    g[pos][col].setText(g[i][col].getText());
                    g[i][col].setText("");
                    pos++;
                } else if (!g[pos][col].getText().equals("")) {
                    pos++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (g[j - 1][i].getText().equals(g[j][i].getText()) && !g[j - 1][i].getText().equals("")) {
                    int res = Integer.parseInt((g[j][i].getText().toString())) + Integer.parseInt((g[j - 1][i].getText().toString()));
                    System.out.println(res);
                    g[j - 1][i].setText((Integer.toString(res)));
                    g[j][i].setText("");
                }
            }
        }
        for (int col = 0; col < 4; col++) {
            for (int i = 0, pos = 0; i < 4; i++) {
                if (!(g[i][col].getText()).equals("") && g[pos][col].getText().equals("")) {
                    g[pos][col].setText(g[i][col].getText());
                    g[i][col].setText("");
                    pos++;
                } else if (!g[pos][col].getText().equals("")) {
                    pos++;
                }
            }
        }
    }
    public void moveDown(TextView[][] g) {
        // moving up an element only without addition
        for (int col = 0; col < 4; col++) {
            for (int i = 3, pos = 3; i >= 0; i--) {
                if (!(g[i][col].getText()).equals("") && g[pos][col].getText().equals("")) {
                    g[pos][col].setText(g[i][col].getText());
                    g[i][col].setText("");
                    pos--;
                } else if (!g[pos][col].getText().equals("")) {
                    pos--;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (g[j][i].getText().equals(g[j - 1][i].getText()) && !g[j - 1][i].getText().equals("")) {
                    int res = Integer.parseInt((g[j][i].getText().toString())) + Integer.parseInt((g[j - 1][i].getText().toString()));
                    //System.out.println(res);
                    g[j][i].setText((Integer.toString(res)));
                    g[j - 1][i].setText("");
                }
            }
        }
        for (int col = 0; col < 4; col++) {
            for (int i = 3, pos = 3; i >= 0; i--) {
                if (!(g[i][col].getText()).equals("") && g[pos][col].getText().equals("")) {
                    g[pos][col].setText(g[i][col].getText());
                    g[i][col].setText("");
                    pos--;
                } else if (!g[pos][col].getText().equals("")) {
                    pos--;
                }
            }
        }
    }
    public void moveLeft(TextView[][] g) {
        // moving up an element only without addition
        for (int row = 0; row < 4; row++) {
            for (int col = 0, pos = 0; col < 4; col++) {
                if (!(g[row][col].getText()).equals("") && g[row][pos].getText().equals("")) {
                    g[row][pos].setText(g[row][col].getText());
                    g[row][col].setText("");
                    pos++;
                } else if (!g[row][pos].getText().equals("")) {
                    pos++;
                }
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 1; col < 4; col++) {
                if (g[row][col - 1].getText().equals(g[row][col].getText()) && !g[row][col].getText().equals("")) {
                    int res = Integer.parseInt((g[row][col].getText().toString())) + Integer.parseInt((g[row][col - 1].getText().toString()));
                    //System.out.println(res);
                    g[row][col - 1].setText((Integer.toString(res)));
                    g[row][col].setText("");
                }
            }
        }
       for (int row = 0; row < 4; row++) {
            for (int col = 0, pos = 0; col < 4; col++) {
                if (!(g[row][col].getText()).equals("") && g[row][pos].getText().equals("")) {
                    g[row][pos].setText(g[row][col].getText());
                    g[row][col].setText("");
                    pos++;
                } else if (!g[row][pos].getText().equals("")) {
                    pos++;
                }
            }
        }
    }
    public void moveRight(TextView[][] g) {
        // moving up an element only without addition
        for (int row = 0; row < 4; row++) {
            for (int col = 3, pos = 3; col >= 0; col--) {
                if (!(g[row][col].getText()).equals("") && g[row][pos].getText().equals("")) {
                    g[row][pos].setText(g[row][col].getText());
                    g[row][col].setText("");
                    pos--;
                } else if (!g[row][pos].getText().equals("")) {
                    pos--;
                }
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 3; col > 0; col--) {
                if (g[row][col - 1].getText().equals(g[row][col].getText()) && !g[row][col].getText().equals("")) {
                    int res = Integer.parseInt((g[row][col].getText().toString())) + Integer.parseInt((g[row][col - 1].getText().toString()));
                    //System.out.println(res);
                    g[row][col].setText((Integer.toString(res)));
                    g[row][col - 1].setText("");
                }
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 3, pos = 3; col >= 0; col--) {
                if (!(g[row][col].getText()).equals("") && g[row][pos].getText().equals("")) {
                    g[row][pos].setText(g[row][col].getText());
                    g[row][col].setText("");
                    pos--;
                } else if (!g[row][pos].getText().equals("")) {
                    pos--;
                }
            }
        }
    }
}





