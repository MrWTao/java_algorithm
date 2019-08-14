package leetcode.easy;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * 输出: 16
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        int i = new IslandPerimeter().islandPerimeter(grid);
        System.out.println(i);
    }

    private int islandPerimeter(int[][] grid) {
        int islandCount = 0;// 岛屿的数目
        int neighborCount = 0;// 相邻的岛屿的边的数目--始终向右向下比较，不会重复
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islandCount++;
                    if(i!=grid.length-1&&grid[i+1][j]==1){
                        neighborCount++;
                    }
                    if(j!=grid[0].length-1&&grid[i][j+1]==1){
                        neighborCount++;
                    }
                }
            }
        }
        return islandCount*4-2*neighborCount;
    }
}
